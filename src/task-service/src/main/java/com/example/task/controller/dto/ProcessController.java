package com.example.task.controller.dto;

import com.example.task.rest.client.api.ProcessDefinitionApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProcessController {

    private final ProcessDefinitionApi processDefinitionApi;

    @GetMapping("/v1/process-definitions")
    public ResponseEntity<String> getProcessDefinitions() {
        final var processDefinitions = processDefinitionApi.getProcessDefinitions(null, null, null, null,
            null, null, null, null, null, null, null,
            null, null, null, null, null, null,
            null, null, null, null, null, null,
            null, null, null, null, null,
            null, null, null, null, null,
            null, null, null);
        return ResponseEntity.ok("OK");
    }
}
