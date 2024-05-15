package org.study;
import org.study.model.Person;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<Person> staff = new ArrayList<>();
		staff.add(new Person("Manuel", 29));
		staff.add(new Person("Ema", 22));
		
		request.setAttribute("staff", staff);
		request.getRequestDispatcher("view.jsp").forward(request, response);
	}


}
