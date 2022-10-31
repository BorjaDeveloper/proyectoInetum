package com.app.proyectoInetum.Daos;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.app.proyectoInetum.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{
	

}