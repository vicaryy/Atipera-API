package com.vicary.zadanie_rekrutacyjne_atipera.controller;

import com.vicary.zadanie_rekrutacyjne_atipera.model.GitHubUser;
import com.vicary.zadanie_rekrutacyjne_atipera.service.GitHubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class GitHubController {

    private final GitHubService gitHubService;

    @GetMapping
    public GitHubUser getUserData(@RequestParam("username") String username) {
        return null;
    }
}
