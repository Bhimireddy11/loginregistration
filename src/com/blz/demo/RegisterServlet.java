package com.blz.demo;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blz.demo.model.User;
import com.blz.demo.service.UserService;
import com.blz.demo.service.UserServiceImpl;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private User User;
	private UserService UserService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		User = new User();
		UserService = new UserServiceImpl();

		User.setEmail(request.getParameter("email"));
		User.setPassword(request.getParameter("password"));
		User.setDob(request.getParameter("dob"));
		User.setAddress(request.getParameter("address"));
		User.setPhoneno(request.getParameter("ph"));
		User.setName(request.getParameter("name"));
		User.setSurname(request.getParameter("surname"));
		User.setZip(request.getParameter("zip"));
		boolean status = UserService.Register(User);
		out.println("Status :" +status);
		if (status) {
			out.println("Data is added to the table");
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			  out.println("record added:" + User);
			  out.println("record added successfully"); rs.include(request,
			  response);
		}
	}
}
