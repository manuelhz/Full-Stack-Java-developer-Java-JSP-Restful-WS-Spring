package org.study;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.study.DAO.AppDAOImpl;
import org.study.config.AppConfig;
import org.study.model.User;

import io.micrometer.observation.Observation.Context;
import jakarta.validation.Valid;


@Controller
public class AppController {
	@RequestMapping("/")
	public ModelAndView homepage() {
		ModelAndView model = new ModelAndView("index");
		List<User> users = new ArrayList<User>();
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(
				AppConfig.class);
		AppDAOImpl DAO = context.getBean("DAOBean", AppDAOImpl.class);
		// remove number 1 from listUsers(1)
		users = DAO.listUsers(1);
		model.addObject("users", users);
		context.close();
		return model;
	}
	@RequestMapping("/addUser")
	public String addUser(Model model, @Valid User user, BindingResult result) {
		
		if(result.hasErrors()) {
			model.addAttribute("user", user);
			return "addUser";
		} else {
			if (user.getName() != null && user.getEmail() != null) {
				AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(AppConfig.class);
				AppDAOImpl DAO = context.getBean("DAOBean", AppDAOImpl.class);
				DAO.addUser(user);
				context.close();
				return "forward:/";
			} else {
				System.out.println("loading form");
				return "addUser";
			}			
		}		
	}	
}