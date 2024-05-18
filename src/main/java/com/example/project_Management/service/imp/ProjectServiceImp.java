package com.example.project_Management.service.imp;

import com.example.project_Management.dto.ProjectDto;
import com.example.project_Management.model.Project;
import com.example.project_Management.repo.ProjectRepo;
import com.example.project_Management.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImp  implements ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ProjectDto createProject(ProjectDto projectDto) {
        Project  project = modelMapper.map(projectDto, Project.class);
        projectRepo.save(project);
        return projectDto;
    }

    @Override
    public void deteteProject(Long id) {
        projectRepo.deleteById(id);
    }

    @Override
    public ProjectDto updateProject(ProjectDto projectDto, Long id) {
        Optional<Project> projectlist = projectRepo.findById(id);
        Project project = modelMapper.map(projectDto,Project.class);
        projectRepo.save(project);
        return projectDto;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepo.findAll();

    }

    @Override
    public List<Project> readProject() {
        return projectRepo.findAll();
    }


}
