package io.adventural.microgithubsearch.mock;

import io.adventural.microgithubsearch.dto.RepositoryResponse;
import io.adventural.microgithubsearch.models.Repository;
import io.adventural.microgithubsearch.services.RepositoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class RepositoryServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private final RepositoryService repositoryService = new RepositoryService();

    @Test
    public void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedObject() throws ExecutionException, InterruptedException {
        List<Repository> repositories = Collections.singletonList(Repository.builder().language("Java").fullName("TheAlgorithms/Java").description("All Algorithms implemented in Java").stargazersCount(33957L).build());
        RepositoryResponse repository = new RepositoryResponse(1L, true, repositories);
        Mockito
                .when(restTemplate.getForEntity(
                        "https://api.github.com/search/repositories?q=java&page=1&per_page=1", RepositoryResponse.class))
          .thenReturn(new ResponseEntity<>(repository, HttpStatus.OK));

        RepositoryResponse repository1 = repositoryService.getRepositoryByNameWithPageAndPerPage("java", 1, 1);
        assertThat(repository1).isEqualTo(repository);
        assertThat(repository1.getTotalCount()).isEqualTo(1L);
        System.out.println("Test finished");
    }
}