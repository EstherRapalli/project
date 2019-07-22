package com.hibernate.main;

import java.util.List;
import java.sql.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.model.Employee;
import com.hibernate.model.EmployeeDetail;


public class HibernateWithMainOneToOne {

	public static void main(String[] args) {

		Configuration config = new Configuration()
				.configure("hibernate.cfg.xml");
		ServiceRegistry registry = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties()).build();
		SessionFactory factory = config.buildSessionFactory(registry);

		Session session = factory.getCurrentSession();
		Transaction txn = session.beginTransaction();


		EmployeeDetail employeeDetail = new EmployeeDetail(101, "10th Street",
				"LA", "San Francisco", "U.S.");

		Employee employee = new Employee(101, "Nina", "Mayers",
				new Date(121212), "114-857-965");
		
		//imp
		employee.setEmployeeDetail(employeeDetail);
		employeeDetail.setEmployee(employee);

	//	session.save(employee);
		
		
				
		EmployeeDetail ed=(EmployeeDetail)session.get(EmployeeDetail.class, 101L);
		System.out.println(ed.getCity());
		System.out.println(ed.getEmployee().getFirstname());
		System.out.println(ed.getEmployee().getLastname());
			
		
	/*	Employee e=(Employee)session.get(Employee.class, 101L);
		
		System.out.println(e.getFirstname());
		System.out.println(e.getLastname());
		System.out.println(e.getEmployeeDetail().getCity());
		System.out.println(e.getEmployeeDetail().getCountry());
		
		*/

		/*
		 * List<Employee> employees =
		 * session.createQuery("from Employee").list(); for (Employee employee1
		 * : employees) { System.out.println(employee1.getFirstname() + " , " +
		 * employee1.getLastname() + ", " +
		 * employee1.getEmployeeDetail().getState()); }
		 */
		txn.commit();

	}

}
