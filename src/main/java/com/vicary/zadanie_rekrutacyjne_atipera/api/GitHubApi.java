package com.vicary.zadanie_rekrutacyjne_atipera.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Component
public class GitHubApi {

    private final WebClient webClient;
}
