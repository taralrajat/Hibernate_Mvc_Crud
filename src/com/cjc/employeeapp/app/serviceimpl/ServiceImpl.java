package com.cjc.employeeapp.app.serviceimpl;

import java.util.List;

import com.cjc.employeeapp.app.daoi.Daoi;
import com.cjc.employeeapp.app.daoimpl.DaoImpl;
import com.cjc.employeeapp.app.model.Employee;
import com.cjc.employeeapp.app.servicei.Servicei;

public class ServiceImpl implements Servicei{

//-------------Service--Layer--------------------------------	
//Buisness related code	

	Daoi di = new DaoImpl();
	
	@Override
	public void saveEmployee(int i, String n, String u, String p) {
	

		
		di.saveEmployee(i, n, u, p);	
		
	}

	@Override
	public List<Employee> viewAll() {
		
		List<Employee> elist = di.viewAll();
		
		return elist; 
	}

	@Override
	public List<Employee> loginEmployee(String u, String p) {
		

		
		List<Employee> empList = di.loginEmployee(u, p);
		
		return empList;
	}

	@Override
	public void deleteEmployee(int id) {  //5
		
	// deleteController >>>>>>	Service Layer
		
		di.deleteEmployee(id);   //5
		
	}

	@Override
	public Employee editEmployee(int id) {
		
		
		Employee e = di.editEmployee(id);   //e
		
		//return editEmployee(id);//e
		
		return e;
	}

	@Override
	public void updateEmployee(int id, String n, String u,String p) {
	
		di.updateEmployee(id, n, u, p);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
