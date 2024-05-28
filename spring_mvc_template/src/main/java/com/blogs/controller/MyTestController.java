package com.blogs.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//base pattern of the incoming url-pattern 
//can be supplied at the class lavel ==optional BUT reco.
@RequestMapping("/test")//>= can intercept any reqvest (GET|PUT|DELETE|PATCH)
public class MyTestController {

	public MyTestController() {
		System.out.println("in ctor of "+getClass());
	}
	//add req handling method to display server side time 
	
	@GetMapping("test2")//==@reqvestmapping(method=GET)
	public ModelAndView renderDynResult() {
		System.out.println("in render dyn res");
		/*
		 * o.s.e.s. ModelAndView : class that holds LVM + results
		 * Results are represented by model attributes]
		 * (name, valuer pair)
		 * Constructor 
		 * ModelAndView(
		 */
		return new ModelAndView("/test/display","server_ts",LocalDateTime.now());
	}
	
	
}
