package com.ravi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Registration() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		//getting data from html form
		String userName=request.getParameter("name");
		String email_id=request.getParameter("email_id");
		
		//Object of HttpSession
		HttpSession session=request.getSession();
		
		//creating session by key and value
		session.setAttribute("reg_email", email_id);
		
		//redirect to another page
		response.sendRedirect("./Login.html");
		
	}

}
