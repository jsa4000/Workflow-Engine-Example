package com.example.data.task;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ExternalTaskSubscription("creditScoreChecker")
public class PersonTask implements ExternalTaskHandler {

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        // https://docs.camunda.org/manual/7.22/user-guide/data-formats/json/
        log.info("PersonTask has being executed");

        final var variable = externalTask.getAllVariables().get("localVariable");

        log.info(variable.toString());

        externalTaskService.complete(externalTask);
    }
}
