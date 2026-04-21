package com.suman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyLoginPageController {

	@RequestMapping("login")
	public ModelAndView dologin()
	{
		System.out.println("Login...page started...");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		return mv;
	}
}
