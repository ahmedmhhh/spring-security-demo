package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/showLoginPage")
	public String showLoginPage() {
		return "fancy-login";
	}

	@GetMapping("/leaders")
	public String LeaderPage(){
		return "leaders";
	}
	@GetMapping("/systems")
	public String AdminPage(){
		return "systems";
	}

	@GetMapping("/access-denied")
	public String AccessDenied(){
		return "access-denied";
	}
}
