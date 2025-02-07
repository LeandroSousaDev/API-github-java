package com.leandross.API.GitHub.controller;

import com.leandross.API.GitHub.client.GitHubClient;
import com.leandross.API.GitHub.dto.RepositoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class GitHubController {

    @Autowired
    private GitHubClient gitHubClient;

    @GetMapping("/repos")
    public ResponseEntity<List<RepositoryResponse>> listRepos(@RequestHeader("token") String token) {

       var repos = gitHubClient.listRepos(
                "Bearer " + token,
                null,
                "public"
        );

        return ResponseEntity.ok(repos);
    }
}
