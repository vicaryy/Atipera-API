package com.vicary.atipera.configuration;

import org.springframework.stereotype.Component;

@Component
public class ApiInfo {
    private static ApiConfiguration apiConfiguration;
    public final static String GITHUB_ADDRESS = "https://api.github.com";

    public ApiInfo(ApiConfiguration apiConfiguration) {
        ApiInfo.apiConfiguration = apiConfiguration;
    }

    public static String getBearerToken() {
        return apiConfiguration.getBearerToken() == null ? "" : "Bearer " + apiConfiguration.getBearerToken();
    }
}
