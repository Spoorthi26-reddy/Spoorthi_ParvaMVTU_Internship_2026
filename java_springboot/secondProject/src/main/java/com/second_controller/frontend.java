package com.second_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class frontend {
	@Controller
	public class FrontendController {
		
		@GetMapping({"","/","/about"})
		public String home() {
			return "about";
		}
	}
}
