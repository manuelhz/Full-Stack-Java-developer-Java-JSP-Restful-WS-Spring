package org.study;



import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.study.model.User;

@Controller
public class MainController {
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("userFormView");
		User user = new User();
		
		Map<String, String> genderMap = new HashMap<String, String>();
		genderMap.put("male", "Male");
		genderMap.put("female", "Female");
		
		Map<String, String> countryMap = new HashMap<String, String>();
		countryMap.put("chile", "Chile");
		countryMap.put("USA", "The United States");
		countryMap.put("uk", "The United Kingdom");
		countryMap.put("australia", "Australia");
		
		modelAndView.addObject("user", user);
		modelAndView.addObject("genderMap", genderMap);
		modelAndView.addObject("countryMap", countryMap);
		return modelAndView;
	}
	@PostMapping("/displayUserInfo")
	public ModelAndView displayUserInfo(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView("displayUserInfo");		
		modelAndView.addObject("user", user);
		return modelAndView;
		
	}
	

}