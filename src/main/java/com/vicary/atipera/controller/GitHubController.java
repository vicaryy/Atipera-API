package com.vicary.atipera.controller;

import com.vicary.atipera.exception.ApiException;
import com.vicary.atipera.service.GitHubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class GitHubController {

    private final GitHubService gitHubService;

    @GetMapping("/user")
    public ResponseEntity<?> getUserData(@RequestParam("username") String username) {
        try {
            return ResponseEntity.ok(gitHubService.getUser(username));
        } catch (ApiException ex) {
            return new ResponseEntity<>(ex.getError(), HttpStatusCode.valueOf(ex.getError().getStatus()));
        }
    }
}
