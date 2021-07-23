package com.example.myassigneeservice.controller;

import com.example.myassigneeservice.model.Assignee;
import com.example.myassigneeservice.service.AssigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssigneeController {

    private AssigneeService assigneeService;
    private Environment environment;

    @Autowired
    public AssigneeController(AssigneeService assigneeService, Environment environment) {
        this.assigneeService = assigneeService;
        this.environment = environment;
    }

    @GetMapping
    public ResponseEntity<String> getStatus()
    {
        return ResponseEntity.ok("assignee-service is up and running on port: "+environment.getProperty("local.server.port"));
    }
    @PostMapping("/assignees")
    public ResponseEntity<Assignee> createAssignee(@RequestBody Assignee assignee)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(assigneeService.createAssignee(assignee));
    }
    @GetMapping("/assignees")
    public ResponseEntity<List<Assignee>> getAllAssignees()
    {
        return ResponseEntity.ok(assigneeService.displayAllAsignee());
    }
    @GetMapping("/assignees/{assigneeName}")
    public Assignee getAllAssigneeByName(@PathVariable("assigneeName") String assigneeName)
    {
        return assigneeService.getAssigneeByName(assigneeName);
    }
}
