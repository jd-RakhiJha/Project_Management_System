package com.example.project_Management.repo;

import com.example.project_Management.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project , Long> {
}
