package com.example.project_Management.service;

import com.example.project_Management.dto.ProjectDto;
import com.example.project_Management.model.Project;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProjectService {

    ProjectDto createProject (ProjectDto projectDto);

    void deteteProject(Long id);

    ProjectDto  updateProject(ProjectDto projectDto, Long id);

    List<Project> getAllProjects();

    List<Project> readProject();






}