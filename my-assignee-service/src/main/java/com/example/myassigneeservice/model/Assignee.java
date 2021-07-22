package com.example.myassigneeservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Assignee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer assigneeId;
    private String assigneeName;
    @JsonProperty
    private Boolean isAvailable;

    public Assignee(String assigneeName, Boolean isAvailable) {
        this.assigneeName = assigneeName;
        this.isAvailable = isAvailable;
    }
}
