package com.ravi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
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
		
		//creating session object
		HttpSession session=request.getSession();
		String reg_email=(String)session.getAttribute("reg_email"); //getting session object
		
		if(reg_email.equals(email_id)) //comparing registration email to login email
		{
			HttpSession session1=request.getSession(); //session object
			
			session1.setAttribute("name", userName);  //setting attribute in key and value form
			
			//redirect to another page
		    response.sendRedirect("./Welcome.jsp");
		}
		else
		{
			response.sendRedirect("./Reg.html");
		}
		
		
	}

}
