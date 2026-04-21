package com.kodewala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MySampleMVC {
	
	@RequestMapping("/showpage")
	public ModelAndView doLogin() {
		System.out.println("SampleController.doLogin():::::::::::");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sign-up");
		return mv;
	}
	

}
