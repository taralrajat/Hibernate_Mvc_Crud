package com.cjc.employeeapp.app.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.cjc.employeeapp.app.daoi.Daoi;
import com.cjc.employeeapp.app.model.Employee;
import com.cjc.employeeapp.app.util.HIbernateUtil;

public class DaoImpl implements Daoi{

//---------------Dao---Layer-----------------
	
//DataBase related Code
	Session session = HIbernateUtil.getSessionFactory().openSession();
	
	@Override
	public void saveEmployee(int i, String n, String u, String p) {
				
		Employee e = new Employee();
		
		e.setId(i);        // id
		e.setName(n);      // name 
		e.setUsername(u);  // username
		e.setPassword(p);  // password
		
		session.save(e);
		session.beginTransaction().commit();	
	}

	@Override
	public List<Employee> viewAll() {
		
		List<Employee> empList = session.createQuery("from Employee").getResultList();

		return empList;
			
//		return >>>> empList
		
	}

	@Override
	public List<Employee> loginEmployee(String u, String p) {
		
		Query<Employee> q = session.createQuery("from Employee where username=:u and password=:p");
		
		q.setParameter("u", u); // username
		q.setParameter("p", p); // password
		
		List<Employee> empList = q.getResultList();
		
		return empList;
	}

	@Override
	public void deleteEmployee(int id) {
		
		Session session = HIbernateUtil.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();//------------
			
		Query<Employee> q = session.createQuery("delete from Employee where id=:inputId");
		
		q.setParameter("inputId", id);  //5
		
		q.executeUpdate();
		
		tx.commit();//----------------
	}

	@Override
	public Employee editEmployee(int id) {
		
		Session session = HIbernateUtil.getSessionFactory().openSession();
		
		Query<Employee> q = session.createQuery("from Employee where id=:inputId");
		
		q.setParameter("inputId", id);
		
		Employee e = q.getSingleResult();
		
		return e;
	}

	@Override
	public void updateEmployee(int id, String n, String u,String p) {
		
		Session session = HIbernateUtil.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		Query<Employee> q = session.createQuery("update Employee set name=:n, username=:u, password=:p where id=:i");

		q.setParameter("n", n);
		q.setParameter("u", u);
		q.setParameter("p", p);
		q.setParameter("i", id);
		
		q.executeUpdate();
		tx.commit();
	}
	

	
	
	
	
	
	
	
	
	
//      delete /  update  -----> Transaction Required****

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
