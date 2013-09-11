package com.test.app.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;





import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.app.dto.FormDTO;



@Controller
public class HomeController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView displayHome(ModelAndView mv){
		mv.setViewName("/home");
		return mv;
	}
	
	@ModelAttribute
	public FormDTO createFormBean(){
		return new FormDTO();
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String submitMessage(@Valid FormDTO formDTO, BindingResult result,
								SessionStatus sessionStatus,
								RedirectAttributes redirectAttrs){
		
		if(result.hasErrors()){
			return "/home";
		}
		String message = formDTO.toString();
		sessionStatus.setComplete();
		redirectAttrs.addFlashAttribute("message", message);
		
		return "redirect:/";
	}
}
