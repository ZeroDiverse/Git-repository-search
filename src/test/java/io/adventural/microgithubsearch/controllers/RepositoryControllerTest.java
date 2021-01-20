package io.adventural.microgithubsearch.controllers;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.adventural.microgithubsearch.dto.RepositoryResponse;
import io.adventural.microgithubsearch.models.Repository;
import io.adventural.microgithubsearch.services.RepositoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = RepositoryController.class)
public class RepositoryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RepositoryService repositoryService;

    @Test
    void whenValidInput_thenReturns200() throws Exception {

        given(repositoryService.getRepositoryByNameWithPageAndPerPage(anyString(), anyInt(), anyInt())).willReturn(new RepositoryResponse());

        MvcResult result = mockMvc.perform(get("/api/v1/github/repositories")
                .param("name", "java")
                .param("page", "1")
                .param("perPage", "1")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();
    }
}
