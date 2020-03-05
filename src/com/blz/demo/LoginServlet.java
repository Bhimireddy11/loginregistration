package com.blz.demo;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blz.demo.model.User;
import com.blz.demo.service.UserService;
import com.blz.demo.service.UserServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private User User;
	private UserService Userservice;
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		User = new User();
		Userservice = new UserServiceImpl();
		HttpSession session=request.getSession(false);
	      String name=(String)session.getAttribute("email");
	      String Password=(String)session.getAttribute("pass");
		User.setEmail(request.getParameter("email"));
		User.setPassword(request.getParameter("pass"));

		if (Userservice.checkUser(User.getEmail(), User.getPassword())) {
			RequestDispatcher rs = request.getRequestDispatcher("Welcome");
			rs.forward(request, response);
		} else {
			out.println("Username or Password incorrect");
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.include(request, response);
		}
	}
}
