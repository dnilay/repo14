package com.example.taskservice.proxy;

import com.example.taskservice.model.Assignee;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "assignee-service")
public interface AssigneeProxy {
    @GetMapping("/assignees/{assigneeName}")
    public Assignee getAssigneeByName(@PathVariable("assigneeName") String name);
}
