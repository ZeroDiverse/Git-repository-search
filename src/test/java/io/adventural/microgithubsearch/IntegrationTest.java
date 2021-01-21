package io.adventural.microgithubsearch;

import io.adventural.microgithubsearch.models.Repository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testRestTemplate_WillReturnTheCorrectData(){
        ResponseEntity<Repository[]> repositoryResponseEntity = restTemplate.getForEntity("/api/v1/github/repositories?name=java&perPage=3&page=2", Repository[].class);

        assertThat(repositoryResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(repositoryResponseEntity.getBody()).isNotEmpty();
        assertThat(repositoryResponseEntity.getBody().length).isEqualTo(3);
        assertThat(repositoryResponseEntity.getBody()[0].getLanguage()).isEqualTo("Java");

    }
}
