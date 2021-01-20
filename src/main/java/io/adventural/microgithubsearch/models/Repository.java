package io.adventural.microgithubsearch.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown=true)
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Repository {
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "full_name")
    private String fullName;
    @JsonProperty(value = "description")
    private String description;
    @JsonProperty(value = "stargazers_count")
    private Long stargazersCount;
}
