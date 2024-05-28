package com.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/categories")
public class CategoriesController {
	public CategoriesController() {
		System.err.println("in ctor of " + getClass());
	}

	@RequestMapping("/list")
	public ModelAndView listAllCategoires() {
		System.err.println("in list all catetgories");
		return new ModelAndView("/categories/list", "category_list", null);
	}
	
}
