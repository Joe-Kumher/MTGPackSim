package com.mtg.config; // You can create a 'config' package or use your main package

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration // This marks the class as a Spring configuration source
public class RestClientConfig {

    @Bean // This annotation tells Spring to create a bean from the object returned by this method
    public RestClient customRestClient() {
        // You can customize the RestClient here if needed (e.g., setting a base URL, default headers)
        return RestClient.create();
    }
}