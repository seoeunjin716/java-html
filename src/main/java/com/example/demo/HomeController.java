package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "index"; // Renders templates/index.html
	}

	@GetMapping("/calculator.html")
	public String calculator() {
		return "calculator"; // Renders templates/calculator.html
	}
}


