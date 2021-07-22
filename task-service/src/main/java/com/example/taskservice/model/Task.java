package com.example.taskservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "task_table")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "task_id")
    private String taskId;
    @Column(name = "severe_level")
    @Enumerated(EnumType.STRING)
    private SEVERE_LEVEL severe_level;
    @Column(name = "assignee_name")
    private String assigneeName;
}
