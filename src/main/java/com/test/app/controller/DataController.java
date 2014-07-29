package com.test.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@RequestMapping("/data")
@Controller
public class DataController {
/*
	@RequestMapping(value="/1", method=RequestMethod.GET)
	public ModelAndView displayHome(ModelAndView mv){
		mv.setViewName("jsonView");
		return mv;
	}
*/
	@RequestMapping(value="/1", method=RequestMethod.GET)
	public void firstjson(Model model){
		model.addAttribute("mystr");
	}
}
