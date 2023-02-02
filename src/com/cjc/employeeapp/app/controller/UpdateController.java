package com.cjc.employeeapp.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.cjc.employeeapp.app.model.Employee;
import com.cjc.employeeapp.app.servicei.Servicei;
import com.cjc.employeeapp.app.serviceimpl.ServiceImpl;
import com.cjc.employeeapp.app.util.HIbernateUtil;

@WebServlet(urlPatterns = "/editform")
public class UpdateController extends HttpServlet{
	
	Servicei si = new ServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("empid"));
		
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
//-----------------------------------------Update data at given Id--Query-1-----------------------------		
		
		si.updateEmployee(id,name,username,password);

//----------------------------------------View All Data--Query-2------------------------------------------
		
		List<Employee> empList = si.viewAll();
		
//--------------------------------------------------------------------------------------------------		
		
		req.setAttribute("allData", empList);
		RequestDispatcher rd = req.getRequestDispatcher("success.jsp");
		rd.forward(req, resp);
	
	}

}
