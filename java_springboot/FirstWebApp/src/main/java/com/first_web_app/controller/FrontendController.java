package com.first_web_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {
	
	@GetMapping({"","/","/home"})
	public String home() {
		return "home";
	}
}
