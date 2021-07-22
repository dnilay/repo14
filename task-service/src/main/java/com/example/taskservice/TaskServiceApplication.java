package com.example.taskservice;

import com.example.taskservice.dao.TaskDao;
import com.example.taskservice.model.SEVERE_LEVEL;
import com.example.taskservice.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@SpringBootApplication
@EnableEurekaClient
public class TaskServiceApplication implements CommandLineRunner {

    private TaskDao taskDao;

    @Autowired
    public TaskServiceApplication(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(TaskServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        taskDao.save(new Task(UUID.randomUUID().toString(), SEVERE_LEVEL.HIGH,"John"));
        taskDao.save(new Task(UUID.randomUUID().toString(), SEVERE_LEVEL.LOW,"Mary"));
        taskDao.save(new Task(UUID.randomUUID().toString(), SEVERE_LEVEL.HIGH,"Sachin"));
        taskDao.save(new Task(UUID.randomUUID().toString(), SEVERE_LEVEL.MEDIUM,"Rahul"));
    }

    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
