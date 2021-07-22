package com.example.taskservice.controller;

import com.example.taskservice.model.Assignee;
import com.example.taskservice.model.Task;
import com.example.taskservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class TaskController {
    private TaskService taskService;
    private RestTemplate restTemplate;
    private Environment environment;
    @Autowired
    public TaskController(TaskService taskService,Environment environment,RestTemplate restTemplate) {
        this.taskService = taskService;
        this.environment=environment;
        this.restTemplate=restTemplate;
    }
    @GetMapping
    public ResponseEntity<String> getStatus()
    {
        return ResponseEntity.ok("task-service is up and running on port: "+environment.getProperty("local.server.port"));
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody Task task)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(task));
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> displayAllTask()
    {
        return ResponseEntity.ok(taskService.displayAlltask());
    }

    @GetMapping("/tasks/assignees")
    public ResponseEntity<List<Assignee>> displayAllAssignee()
    {
        List<Assignee> list=restTemplate.getForObject("http://localhost:8088/assignee-service/assignees",List.class);
       return ResponseEntity.ok(list);
    }
}
