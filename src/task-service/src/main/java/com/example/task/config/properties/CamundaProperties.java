package com.example.task.config.properties;

import lombok.Data;

@Data
public class CamundaProperties {

    private Web web;

    @Data
    public static class Web {

        private String url;
    }
}
