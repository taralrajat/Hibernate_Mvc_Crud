package com.cjc.employeeapp.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.cjc.employeeapp.app.model.Employee;
import com.cjc.employeeapp.app.servicei.Servicei;
import com.cjc.employeeapp.app.serviceimpl.ServiceImpl;
import com.cjc.employeeapp.app.util.HIbernateUtil;

@WebServlet(urlPatterns = "/register")
public class registerController extends HttpServlet{
	
	Servicei si = new ServiceImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String stringId = request.getParameter("id");
		int id = Integer.parseInt(stringId);
		
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	//-------------------------------------------------------------------------Save--Data----------------
		
				
		
		si.saveEmployee(id, name, username, password);  // service interface
		
		
	//-----------------------------------------------------------------------------------------------------
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
		
		
	
	}

}
