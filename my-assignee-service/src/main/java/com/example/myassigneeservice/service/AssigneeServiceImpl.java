package com.example.myassigneeservice.service;

import com.example.myassigneeservice.dao.AssigneeDao;
import com.example.myassigneeservice.model.Assignee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssigneeServiceImpl implements AssigneeService{
private AssigneeDao assigneeDao;

@Autowired
    public AssigneeServiceImpl(AssigneeDao assigneeDao) {
        this.assigneeDao = assigneeDao;
    }

    @Override
    public Assignee createAssignee(Assignee assignee) {
        return assigneeDao.save(assignee);
    }

    @Override
    public List<Assignee> displayAllAsignee() {
        return assigneeDao.findAll();
    }
}
