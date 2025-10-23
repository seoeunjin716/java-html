package com.seoeunjin.api.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "index"; // Renders templates/index.html
	}

	@GetMapping("/auth")
	public String auth() {
		return "auth/index"; // Renders templates/auth/index.html
	}

	@GetMapping("/calculator.html")
	public String calculator() {
		return "calculator"; // Renders templates/calculator.html
	}

	@GetMapping("/auth/register.html")
	public String register() {
		return "auth/register"; // Renders templates/auth/register.html
	}

	@GetMapping("/auth/login.html")
	public String login() {
		return "auth/login"; // Renders templates/auth/login.html
	}

	@GetMapping("/about")
	public String about() {
		return "company/about"; // Renders templates/auth/login.html
	}

	@GetMapping("/lca")
	public String lca() {
		return "carbon/lca"; // Renders templates/auth/login.html
	}

	@GetMapping("/emission")
	public String emission() {
		return "carbon/emission"; // Renders templates/auth/login.html
	}

	@GetMapping("/report")
	public String report() {
		return "carbon/report"; // Renders templates/auth/login.html
	}

	@GetMapping("/contents/calculator/plus")
	public String plus() {
		return "contents/calculator/plus"; // Renders templates/auth/login.html
	}

	@GetMapping("/contents/calculator/nanum")
	public String nanum() {
		return "contents/calculator/nanum"; // Renders templates/auth/login.html
	}

	@GetMapping("/contents/calculator/gob")
	public String gob() {
		return "contents/calculator/gob"; // Renders templates/auth/login.html
	}

	@GetMapping("/contents/calculator/minus")
	public String minus() {
		return "contents/calculator/minus"; // Renders templates/auth/login.html
	}
}


