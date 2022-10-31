package com.app.proyectoInetum.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.app.proyectoInetum.entity.Task;
import com.app.proyectoInetum.Daos.TaskRepository;


@Controller
@RequestMapping("/tareas")
public class TaskController {
	
	private final Logger logg = LoggerFactory.getLogger(Task.class);
	
	@Autowired
	private TaskRepository taskRepository;
	
	
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("tasks", taskRepository.findAll());
		return "hometask";
	}
	
	@GetMapping("/createtask")
	public String CreateTask( ) {
		return "createtask";
	}
	
	@PostMapping("/save")
	public String save(Task task) {
		logg.info("Informacion del objeto proyecto, {}", task);
		taskRepository.save(task);
		return "redirect:/tareas";
	}
	
	@GetMapping("/edittask/{id}")
	public String edit(@PathVariable Integer id, Model m) {
		Task t= taskRepository.getOne(id);
		logg.info("Objeto recuperado {}", t);
		m.addAttribute("task", t);
		return "edittask";
	}
	
	@GetMapping("/delete/{id}")
	public String delete( @PathVariable Integer id) {
		Task t= taskRepository.getOne(id);
		logg.info("Objeto eliminado {}", t);
		taskRepository.delete(t);
		return "redirect:/tareas";
	}

}