package com.hibernate.model;

import static org.junit.Assert.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateIDTest {

private static SessionFactory sf = null;
	
	@BeforeClass
	public static void beforeClass(){
		try {
			sf = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testStudentSave() {
		Student s = new Student();
		s.setName("s1");
		s.setAge(1);
		
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
	}
	
	@AfterClass
	public static void afterClass(){
		sf.close();
	}

}
