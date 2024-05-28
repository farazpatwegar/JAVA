package com.blogs.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//Mnadatory class lavel annotaton to tell SC
//following is req handling spring brean
//singleton n eager 

public class TestController {

	public TestController() {
		System.err.println("in ctor of "+getClass());
	}
	
	@PostConstruct
	public void myInit() {
		System.out.println("in init of"+getClass());
		
	}
	//add a reqvest handling method to forward the clnt to the view layer 
	//to display the welcome msg 
	
	@RequestMapping("/test1")
	public String testMe()
	{
		System.out.println("in test me ");
		return "/display";//LVM , Handler returns LVM => D.S. => V.R. 
	}
	
	
}
