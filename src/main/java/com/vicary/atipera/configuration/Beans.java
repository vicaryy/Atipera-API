package com.vicary.atipera.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Beans {

    @Bean
    public WebClient getWebClient() {
        return WebClient.builder().build();
    }
}
