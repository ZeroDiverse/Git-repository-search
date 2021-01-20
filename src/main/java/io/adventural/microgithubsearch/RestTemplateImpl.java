package io.adventural.microgithubsearch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateImpl {
        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
}
