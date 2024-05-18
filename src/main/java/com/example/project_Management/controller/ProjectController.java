package com.example.project_Management.controller;

import com.example.project_Management.dto.ProjectDto;
import com.example.project_Management.model.Project;
import com.example.project_Management.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/project")
public class ProjectController {

  @Autowired
  private ProjectService projectService;

    @PostMapping("/create")
    public ResponseEntity<?> createProject (@RequestBody ProjectDto projectDto){
    ProjectDto projectDto1 = projectService.createProject(projectDto);
    return new ResponseEntity<>(projectDto1, HttpStatus.OK);
    }

    @GetMapping("/getAllProject")
    public ResponseEntity<?> getAllProjects() {
        List<Project> projectList = projectService.getAllProjects();
        return new ResponseEntity<>(projectList, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?>deteteProject (@PathVariable("id") Long id) {
        projectService.deteteProject(id);
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("Message", "Student Delete Successfully");
        return new ResponseEntity<>(stringMap, HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateProject(@RequestBody ProjectDto projectDto, @PathVariable("id") Long id) {
        projectDto.setId(id);
        projectService.updateProject(projectDto, id);

        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("Message", "Student Update Successful");
        return new ResponseEntity<>(stringMap, HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<?> readProject(@PathVariable("id") Long id) {
        projectService.readProject();
        Map<String, String> map = new HashMap<>();
        map.put("Message", "Read Only The Student Details");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }



}
