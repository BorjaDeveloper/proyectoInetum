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
import com.app.proyectoInetum.entity.Project;
import com.app.proyectoInetum.Daos.ProjectRepository;


@Controller
@RequestMapping("/proyectos")
public class ProjectController {
	
	private final Logger logg = LoggerFactory.getLogger(Project.class);
	
	@Autowired
	private ProjectRepository projectRepository;
	
	
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("projects", projectRepository.findAll());
		return "homeproject";
	}
	
	@GetMapping("/createproject")
	public String CreateProject( ) {
		return "createproject";
	}
	
	@PostMapping("/save")
	public String save(Project project) {
		logg.info("Informacion del objeto proyecto, {}", project);
		projectRepository.save(project);
		return "redirect:/proyectos";
	}
	
	@GetMapping("/editproject/{id}")
	public String edit(@PathVariable Integer id, Model m) {
		Project p= projectRepository.getOne(id);
		logg.info("Objeto recuperado {}", p);
		m.addAttribute("project", p);
		return "editproject";
	}
	
	@GetMapping("/delete/{id}")
	public String delete( @PathVariable Integer id) {
		Project p= projectRepository.getOne(id);
		logg.info("Objeto eliminado {}", p);
		projectRepository.delete(p);
		return "redirect:/proyectos";
	}

}