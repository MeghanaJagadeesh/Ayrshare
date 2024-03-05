package com.planotech.ayrshare_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Quantum")
public class LoadFileController {

	@GetMapping("/post")
	public String loadPostFile() {
		return "post";
	}
}
