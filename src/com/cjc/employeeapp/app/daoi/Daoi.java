package com.cjc.employeeapp.app.daoi;

import java.util.List;

import com.cjc.employeeapp.app.model.Employee;

public interface Daoi {
	
	public void saveEmployee(int i, String n, String u, String ps);

	public List<Employee> viewAll();
	
	public List<Employee> loginEmployee(String u, String p);
	
	public void deleteEmployee(int id);
	
	public Employee editEmployee(int id);
	
	public void updateEmployee(int id, String n, String u,String p);
}
