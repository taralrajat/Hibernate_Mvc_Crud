package com.cjc.employeeapp.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.cjc.employeeapp.app.model.Employee;
import com.cjc.employeeapp.app.servicei.Servicei;
import com.cjc.employeeapp.app.serviceimpl.ServiceImpl;
import com.cjc.employeeapp.app.util.HIbernateUtil;
@WebServlet(urlPatterns = "/login")
public class loginController extends HttpServlet{
	
	Servicei si = new ServiceImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
//----------------------------------------------------case 1---Admin--(View all Data)-------------------------------
		
		Session session = HIbernateUtil.getSessionFactory().openSession();

		if("admin".equals(username) && "admin".equals(password))
		{
			List<Employee> empList = si.viewAll();
			
			//-------------------------------------------------------------------------
			
			request.setAttribute("allData", empList);
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}
//----------------------------------------------------------case 2--for Single Employee-------------------------------		
		else
		{
			
			List<Employee> empList  = si.loginEmployee(username, password);
			
			//----------------------------------------------------------------
			
			if(!empList.isEmpty())
			{
				request.setAttribute("allData", empList);
				request.getRequestDispatcher("success.jsp").forward(request, response);
			}
			else
			{
				request.getRequestDispatcher("login.jsp").forward(request, response);	
			}
			
		}
		
	}

}
