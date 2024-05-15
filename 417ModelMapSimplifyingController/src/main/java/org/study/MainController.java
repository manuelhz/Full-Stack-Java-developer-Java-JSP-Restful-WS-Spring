package org.study;



import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.study.model.User;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("userFormView");
		User user = new User();		
		modelAndView.addObject("user", user);		
		return modelAndView;
	}
	@PostMapping("/displayUserInfo")
	public ModelAndView displayUserInfo(@ModelAttribute("user") @Valid User user, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("displayUserInfo");
		modelAndView.addObject("user", user);
		if(result.hasErrors()) {
			ModelAndView repopulateModelAndView = new ModelAndView("userFormView");		
			repopulateModelAndView.addObject("user", user);			
			System.out.println("Has error!!");
			
			return repopulateModelAndView;
		} else {
			System.out.println("All good!!");
			return modelAndView;
		}
		
		
	}
	

}