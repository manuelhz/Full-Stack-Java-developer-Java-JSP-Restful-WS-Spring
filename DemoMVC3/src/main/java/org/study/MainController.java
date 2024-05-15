package org.study;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class MainController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Welcome() {
		return "hello";
	}
	
	//@RequestMapping(value = "displayname")
	//RequestMapping hansle enythibg but GetMapping only get
	@GetMapping(value = "displayname")
	public ModelAndView displayName(@RequestParam("firstName") String firstName, 
			Model model) {
		ModelAndView modelAndView = new ModelAndView("displayName");
		Date date = new Date();
		List<String> names = new ArrayList<>();
		names.add("Manuel");
		names.add("Chand");
		names.add("Mike");
		names.add("John");
		modelAndView.addObject("date", date);
		modelAndView.addObject("name", firstName);
		modelAndView.addObject("team", names);
		return modelAndView;
	}
}