package com.vicary.atipera.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("api-configuration")
@Configuration
@Getter
@Setter
public class ApiConfiguration {
    private String bearerToken;
}
