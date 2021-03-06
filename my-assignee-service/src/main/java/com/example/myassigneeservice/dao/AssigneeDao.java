package com.example.myassigneeservice.dao;

import com.example.myassigneeservice.model.Assignee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AssigneeDao extends JpaRepository<Assignee,Integer> {

    @Query
    public Assignee findByAssigneeName(String assignee);
}
