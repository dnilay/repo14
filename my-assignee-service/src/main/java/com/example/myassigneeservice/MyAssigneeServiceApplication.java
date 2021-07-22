package com.example.myassigneeservice;

import com.example.myassigneeservice.dao.AssigneeDao;
import com.example.myassigneeservice.model.Assignee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MyAssigneeServiceApplication implements CommandLineRunner  {
private AssigneeDao assigneeDao;

@Autowired
    public MyAssigneeServiceApplication(AssigneeDao assigneeDao) {
        this.assigneeDao = assigneeDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyAssigneeServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        assigneeDao.save(new Assignee("John",true));
        assigneeDao.save(new Assignee("Mary",false));
        assigneeDao.save(new Assignee("Sachin",false));
        assigneeDao.save(new Assignee("rahul",true));
    }
}
