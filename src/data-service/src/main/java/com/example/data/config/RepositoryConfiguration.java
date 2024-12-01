package com.example.data.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.support.Repositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RepositoryConfiguration implements RepositoryRestConfigurer {

    @Autowired
    private Repositories repositories;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        this.repositories.iterator().forEachRemaining(config::exposeIdsFor);
        config.setReturnBodyForPutAndPost(false);
        config.setReturnBodyOnDelete(false);
        config.useHalAsDefaultJsonMediaType(false);
    }
}

