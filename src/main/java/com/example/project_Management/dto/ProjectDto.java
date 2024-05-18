package com.example.project_Management.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProjectDto {

    private Long id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}
