package io.adventural.microgithubsearch.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.adventural.microgithubsearch.models.Repository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryResponse {
    @JsonProperty(value = "total_count")
    private Long totalCount;
    @JsonProperty(value = "incomplete_results")
    private Boolean incompleteResults;
    @JsonProperty(value = "items")
    private List<Repository> items;
}
