package com.mahesh.todo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "task")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    private String id; // Unique identifier for the task
    private String title; // Title of the task
    private String description; // Detailed description of the task
    private boolean completed; // Status of the task (true or false)
}
