package com.app.proyectoInetum.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/proyectoInetum")
public class ApiController {
	
	
	@GetMapping("")
	public String home() {
		return "home";
	}
	
	
}