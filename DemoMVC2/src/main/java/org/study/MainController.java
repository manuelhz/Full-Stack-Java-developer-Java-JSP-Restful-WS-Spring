package org.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Welcome() {
		return "hello";
	}
	@RequestMapping(value = "displayname")
	public String displayName(HttpServletRequest request) {
		String firstName = request.getParameter("firstName");
		request.setAttribute("firstName", firstName);
		return "displayName";
	}
}