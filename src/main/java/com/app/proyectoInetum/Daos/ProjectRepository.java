package com.app.proyectoInetum.Daos;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.app.proyectoInetum.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{
	

}