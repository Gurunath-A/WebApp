package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet implementation class loginSrv
 */
public class LoginServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
	{
		String str1=request.getParameter("Username");
		String str2=request.getParameter("Password");
		
		LoginBean lb=new LoginBean();
		int i=lb.checkLogin(str1,str2);
		PrintWriter out=response.getWriter();
		
		if(i==1)
		{
			out.println("<h1>LOGIN SUCCESS</h1>");
		}
		else {
			out.println("<h1>OOPS! LOGIN FAILED</h1>");
		}
		out.close();	
	}

}
