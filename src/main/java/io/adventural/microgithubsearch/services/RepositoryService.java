package io.adventural.microgithubsearch.services;

import io.adventural.microgithubsearch.dto.RepositoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("repositoryService")
public class RepositoryService {
    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public RepositoryResponse getRepositoryByNameWithPageAndPerPage(String name, Integer page, Integer perPage) {

        ResponseEntity<RepositoryResponse> repositoryResponse = restTemplate.getForEntity("https://api.github.com/search/repositories?q=" + name + "&page=" + page + "&per_page=" + perPage, RepositoryResponse.class);
        System.out.println(repositoryResponse.getStatusCode());
        return repositoryResponse.getBody();
    }
}
