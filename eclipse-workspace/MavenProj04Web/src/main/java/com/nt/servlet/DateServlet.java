package com.nt.servlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("dateurl")
public class DateServlet extends HttpServlet {
	
	
	
	@Override
	public  void doGet(HttpServletRequest req,HttpSevletResponse resp)throws ServletException, IOException{
		super.doGet(req,resp);
		
		
	}

}
