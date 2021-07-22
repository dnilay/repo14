package com.example.taskservice.model;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Assignee {
    private Integer assigneeId;
    private String assigneeName;
    @JsonProperty
    private Boolean isAvailable;

    public Assignee(String assigneeName, Boolean isAvailable) {
        this.assigneeName = assigneeName;
        this.isAvailable = isAvailable;
    }
}

