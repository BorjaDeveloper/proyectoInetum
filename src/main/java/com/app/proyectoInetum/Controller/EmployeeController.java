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
import com.app.proyectoInetum.entity.Employee;
import com.app.proyectoInetum.Daos.EmployeeRepository;


@Controller
@RequestMapping("/empleados")
public class EmployeeController {
	
	private final Logger logg = LoggerFactory.getLogger(Employee.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("employees", employeeRepository.findAll());
		return "homeempleados";
	}
	
	@GetMapping("/createemployee")
	public String CreateEmployee( ) {
		return "createemployee";
	}
	
	@PostMapping("/save")
	public String save(Employee employee) {
		logg.info("Informacion del objeto empleado, {}", employee);
		employeeRepository.save(employee);
		return "redirect:/empleados";
	}
	
	@GetMapping("/editemployee/{id}")
	public String edit(@PathVariable Integer id, Model m) {
		Employee e= employeeRepository.getOne(id);
		logg.info("Objeto recuperado {}", e);
		m.addAttribute("employee", e);
		return "editemployee";
	}
	
	@GetMapping("/delete/{id}")
	public String delete( @PathVariable Integer id) {
		Employee e= employeeRepository.getOne(id);
		logg.info("Objeto eliminado {}", e);
		employeeRepository.delete(e);
		return "redirect:/empleados";
	}

}