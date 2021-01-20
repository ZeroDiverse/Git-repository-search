package io.adventural.microgithubsearch.controllers;

import io.adventural.microgithubsearch.dto.RepositoryResponse;
import io.adventural.microgithubsearch.models.Repository;
import io.adventural.microgithubsearch.services.RepositoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/github/repositories")
@AllArgsConstructor
@Slf4j
public class RepositoryController {

    private final RepositoryService repositoryService;

    @GetMapping(value = {"/", ""})
    public ResponseEntity<List<Repository>> findGitHubRepositoriesByNameWithPerPageAndPage(@RequestParam String name, @RequestParam Integer perPage, @RequestParam Integer page) throws ExecutionException, InterruptedException {
        RepositoryResponse completableFutureResponse = repositoryService.getRepositoryByNameWithPageAndPerPage(name, page, perPage);
        return ResponseEntity.status(200).body(completableFutureResponse.getItems());
    }
}
