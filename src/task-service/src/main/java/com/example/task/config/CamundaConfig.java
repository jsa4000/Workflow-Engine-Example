package com.example.task.config;

import com.example.task.config.properties.CamundaProperties;
import com.example.task.rest.client.api.ProcessDefinitionApi;
import com.example.task.rest.client.invoker.ApiClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamundaConfig {

    @Bean
    @ConfigurationProperties(prefix = "camunda")
    CamundaProperties camundaProperties() {
        return new CamundaProperties();
    }

    @Bean
    ProcessDefinitionApi processDefinitionApi(final CamundaProperties camundaProperties) {
        final var apiClient = new ApiClient();
        apiClient.setBasePath(camundaProperties.getWeb().getUrl());
        return new ProcessDefinitionApi(apiClient);
    }
}
