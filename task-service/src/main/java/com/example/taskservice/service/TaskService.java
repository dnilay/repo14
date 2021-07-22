package com.example.taskservice.service;

import com.example.taskservice.model.Task;

import java.util.List;

public interface TaskService {
    public Task createTask(Task task);
    public List<Task> displayAlltask();
}
