package com.test.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JustController1 {
    @RequestMapping(value="/just", method=RequestMethod.GET)
	public ModelAndView justmapping(ModelAndView mv){
    	mv.setViewName("just");
    	return mv;
    }
	
}
