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
@WebServlet(urlPatterns = "/delete")
public class DeleteController extends HttpServlet{
	
	Servicei si = new ServiceImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("empid"));  // id = 5

//-------------------------------------------------------------Delete-Query-------------------------------------
		
		si.deleteEmployee(id);  // 5
		
//---------------------------------------------------------view All Data-Query-----------------------------------
		
	
		List<Employee> empList = si.viewAll();
		
		
//----------------------------------------------------------------------------------------------------------		
		
		request.setAttribute("allData", empList);
		RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
		rd.forward(request, response);
	}

}
