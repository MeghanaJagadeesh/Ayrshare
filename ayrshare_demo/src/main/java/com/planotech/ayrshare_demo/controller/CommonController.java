package com.planotech.ayrshare_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

	@GetMapping("/")
	public String load() {
		return "index.html";
	}
	
	
}
