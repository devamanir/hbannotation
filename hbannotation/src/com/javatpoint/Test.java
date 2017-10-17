package com.javatpoint;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class Test {
	public static void main(String[] args) {
		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();

		/*
		 * Transaction t=session.beginTransaction();
		 * 
		 * Employee e1=new Employee(); e1.setId(1001); e1.setFirstName("sonoo");
		 * e1.setLastName("jaiswal");
		 * 
		 * Employee e2=new Employee(); e2.setId(1002); e2.setFirstName("vimal");
		 * e2.setLastName("jaiswal");
		 * 
		 * Employee e3=new Employee(); e3.setId(1003); e3.setFirstName("vimal");
		 * e3.setLastName("jaiswal");
		 * 
		 * Employee e4=new Employee(); e4.setId(1004); e4.setFirstName("vimal");
		 * e4.setLastName("jaiswal"); session.persist(e1); session.persist(e2);
		 * session.persist(e3); session.persist(e4); t.commit();
		 */
		Query query = session.createQuery("from Employee");
		List<Employee> emp = query.list();
		ExportReport exportReport = new ExportReport();
		exportReport.exportDatabasesReport(emp);
		for (Employee e : emp) {
			System.out.println("===========================================");
			System.out.println(e.getId());
			System.out.println(e.getFirstName());
			System.out.println(e.getLastName());
		}
		session.close();
		System.out.println("successfully saved");
	}
}
