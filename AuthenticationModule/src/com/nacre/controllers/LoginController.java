
package com.nacre.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.dao.LoginDao;

public class LoginController {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userName=request.getParameter("username");
		String password=request.getParameter("userpass");
		
		String userType=LoginDao.validate(userName,password);
		
		if(userType!=null)
		{
			if(userType=="Admin")
			response.sendRedirect("Admin.jsp"); // can  add html file also
			
			if(userType=="Doctor")
				response.sendRedirect("Doctor.html");
			
			if(userType=="Financer")
				response.sendRedirect("Financer.html");
		}
		else{
			response.sendRedirect("Login-Error.html"); 
		    }
		
		out.close();
	}

}
