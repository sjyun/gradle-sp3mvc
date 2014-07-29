package com.test.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SubController {
	@RequestMapping(value="/sub", method=RequestMethod.GET)
	public ModelAndView displayHome(ModelAndView mv){
		System.out.println("subview");
		mv.setViewName("sub");
		return mv;
	}
}
