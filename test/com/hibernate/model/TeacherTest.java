package com.hibernate.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TeacherTest {
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
	public void testTeacherSave() {
		Teacher t = new Teacher();
		t.setName("t2");
		t.setTitle("ÖÐ¼¶");
		t.setBirthDate(new Date());
		t.setTitle("A");

		Session session = sf.openSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
	}
	
	@AfterClass
	public static void afterClass(){
		sf.close();
	}

}
