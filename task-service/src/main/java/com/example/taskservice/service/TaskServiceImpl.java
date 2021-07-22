package com.example.taskservice.service;

import com.example.taskservice.dao.TaskDao;
import com.example.taskservice.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImpl implements TaskService{

    private TaskDao taskDao;

    @Autowired
    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public Task createTask(Task task) {
        return taskDao.save(task);
    }

    @Override
    public List<Task> displayAlltask() {
        return taskDao.findAll();
    }
}
