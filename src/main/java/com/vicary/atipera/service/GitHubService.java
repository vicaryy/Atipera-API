package com.vicary.atipera.service;

import com.vicary.atipera.configuration.ApiInfo;
import com.vicary.atipera.exception.ApiException;
import com.vicary.atipera.model.Branch;
import com.vicary.atipera.model.ErrorResponse;
import com.vicary.atipera.model.Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GitHubService {

    private final WebClient webClient;

    public List<Repository> getUser(String username) {
        List<Repository> repos = getRepos(username);
        repos.forEach(e -> e.setBranches(getBranches(e.getBranchesUrl().split("\\{")[0])));
        return repos;
    }

    private List<Repository> getRepos(String username) {
        List<Repository> repos = webClient.get()
                .uri("%s/users/%s/repos".formatted(ApiInfo.GITHUB_ADDRESS, username))
                .header("Accept", "application/json")
                .header("Authorization", ApiInfo.getBearerToken())
                .retrieve()
                .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(), clientResponse -> handleError(clientResponse, username))
                .bodyToMono(new ParameterizedTypeReference<List<Repository>>() {
                })
                .block();

        if (repos != null)
            repos = repos.stream()
                    .filter(e -> !e.isFork())
                    .toList();
        return repos;
    }

    private List<Branch> getBranches(String branchUrl) {
        return webClient.get()
                .uri(branchUrl)
                .header("Accept", "application/json")
                .header("Authorization", ApiInfo.getBearerToken())
                .retrieve()
                .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(), this::handleError)
                .bodyToMono(new ParameterizedTypeReference<List<Branch>>() {
                })
                .block();
    }

    private Mono<Throwable> handleError(ClientResponse clientResponse, String username) {
        ErrorResponse error = clientResponse.bodyToMono(ErrorResponse.class).block();
        if (error != null && error.getStatus() == 404)
            error.setMessage("Username '%s' not found".formatted(username));
        return Mono.error(new ApiException(error));
    }

    private Mono<Throwable> handleError(ClientResponse clientResponse) {
        ErrorResponse error = clientResponse.bodyToMono(ErrorResponse.class).block();
        return Mono.error(new ApiException(error));
    }
}
