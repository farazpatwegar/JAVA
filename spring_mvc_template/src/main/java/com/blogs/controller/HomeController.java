package com.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	public HomeController() {
System.out.println("In HomeController Ctor"+getClass());
	}

	@RequestMapping("/")
	public String showHomePage() {
		System.out.println("in deliver index page");
		return "/index";
	}
}
