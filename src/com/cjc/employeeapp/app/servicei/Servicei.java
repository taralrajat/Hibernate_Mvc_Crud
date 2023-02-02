package com.cjc.employeeapp.app.servicei;

import java.util.List;

import com.cjc.employeeapp.app.model.Employee;

public interface Servicei {
	
	public void saveEmployee(int i, String n, String u, String p);  // RegisterServlet
	
	public List<Employee> viewAll();     // loginServlet--Case 1-- Admin---show all data
	
	public List<Employee> loginEmployee(String u, String p);// loginServlet--Case 2--Single user

	public void deleteEmployee(int id);
	
	public Employee editEmployee(int id);
	
	public void updateEmployee(int id, String n, String u,String p);
}









//    operation   delete  /   save   /   update ------->  void
//
//
//   admin       ----->  view ALl Database Data  ------>  Return Type
//   Single USer ----->  view Single User Data
//
//
//
//
//
