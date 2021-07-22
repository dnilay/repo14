package com.example.myassigneeservice.service;

import com.example.myassigneeservice.model.Assignee;

import java.util.List;

public interface AssigneeService {

    public Assignee createAssignee(Assignee assignee);
    public List<Assignee> displayAllAsignee();
}
