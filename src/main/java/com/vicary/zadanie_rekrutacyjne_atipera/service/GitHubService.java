package com.vicary.zadanie_rekrutacyjne_atipera.service;

import com.vicary.zadanie_rekrutacyjne_atipera.api.GitHubApi;
import com.vicary.zadanie_rekrutacyjne_atipera.model.GitHubUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GitHubService {

    private final GitHubApi api;

    public GitHubUser getUser(String username) {
        return new GitHubUser();
    }
}
