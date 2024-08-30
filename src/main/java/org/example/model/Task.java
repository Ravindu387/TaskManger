package org.example.model;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@ToString
public class Task {
    private String title;
    private String description;
    private String date;



    public Task(String taskTitle, String taskDescription, String completionDate) {
        this.title=taskTitle;
        this.description=taskDescription;
        this.date=completionDate;
    }
}
