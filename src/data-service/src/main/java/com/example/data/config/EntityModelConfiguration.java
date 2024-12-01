package com.example.data.config;

import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;

@Configuration
public class EntityModelConfiguration implements RepresentationModelProcessor<EntityModel<?>> {

    @Override
    public EntityModel<?> process(@NotNull EntityModel<?> model) {
        return EntityModel.of(model.getContent());
    }

}
