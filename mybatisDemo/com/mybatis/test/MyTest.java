package com.mybatis.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.dao.ICarDao;
import com.mybatis.dao.ICountryDao;
import com.mybatis.dao.INewsLabelDao;
import com.mybatis.dao.IStudentCourseDao;
import com.mybatis.dao.IStudentDao;
import com.mybatis.dao.StudentDaoImpl;
import com.mybatis.entity.Car;
import com.mybatis.entity.Country;
import com.mybatis.entity.NewsLabel;
import com.mybatis.entity.NewsLabels;
import com.mybatis.entity.Student;
import com.mybatis.entity.Students;
import com.mybatis.utils.MyBatisUtils;                   

public class MyTest {
	
	private  IStudentDao dao;
	private  ICountryDao countryDao;
	private ICarDao carDao;
	private INewsLabelDao newsLabelDao;
	private IStudentCourseDao studentCourseDao;
	private  SqlSession sqlSession;

	@Before
	public void before(){
		dao = new StudentDaoImpl();	
		sqlSession = MyBatisUtils.getSqlSession();
		countryDao = sqlSession.getMapper(ICountryDao.class);
		carDao = sqlSession.getMapper(ICarDao.class);
		newsLabelDao = sqlSession.getMapper(INewsLabelDao.class);
		studentCourseDao = sqlSession.getMapper(IStudentCourseDao.class);
	}
	
	@Test
	public void testInsertStudent(){
		Student student = new Student("xiao高",22,93);
		dao.insertStudent(student);
	}
	
	@Test
	public void testInsertStudentCacheId(){
		Student student = new Student("李四",24,83);
		System.out.println("插入前：student = " + student);
		dao.insertStudentCacheId(student);
		System.out.println("插入后：student = " + student);
	}
	
	@Test
	public void testDeleteStudentById(){
		dao.deleteStudentById(26);
	}
	
	@Test
	public void testupdateStudent(){
		Student student = new Student("哈哈",22,76);
		student.setId(21);
		dao.updateStudent(student);
	}
	
	@Test
	public void testSelectAllStudents(){
		List<Student> students = dao.selectAllStudents();
		if(students.size()>0){
			for (Student student : students) {
				System.out.println(student);
			}
		}
	}
	
	@Test
	public void testSelectAllStudentsMap(){
		Map<String, Object> map = dao.selectAllStudentsMap();
		System.out.println(map.get(21));
	}
	
	@Test
	public void testSelectStudentById(){
		Student student = dao.selectStudentById(22);
		System.out.println(student);
	}
	
	@Test
	public void testSelectStudentsByName(){
		List<Student> students = dao.selectStudentsByName("王");
		if(students.size()>0){
			for (Student student : students) {
				System.out.println(student);
			}
		}
	}
	
	@Test
	public void testSelectStudentsByCondition(){
		Student stu = new Student("田七",27,85);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("nameCon", "李");
		map.put("ageCon",23);
		map.put("scoreCon", stu);
		List<Student> students = dao.selectStudentsByCondition(map);
		if(students.size()>0){
			for (Student student : students) {
				System.out.println(student);
			}
		}
	}
	
	@Test
	public void testSelectStudentsByCondition2(){
		List<Student> students = dao.selectStudentsByCondition2("李",23);
		if(students.size()>0){
			for (Student student : students) {
				System.out.println(student);
			}
		}
	}
	
	@Test
	public void testSelectStudentsByCondition3(){
		Student stu = new Student("李",22,80);
		List<Student> students = dao.selectStudentsBycondition3(stu);
		if(students.size()>0){
			for (Student student : students) {
				System.out.println(student);
			}
		}
	}
	
	@Test
	public void testSelectStudentsByChoose(){
		Student stu = new Student("李",22,80);
		List<Student> students = dao.selectStudentsByChoose(stu);
		if(students.size()>0){
			for (Student student : students) {
				System.out.println(student);
			}
		}
	}
	
	@Test
	public void testSelectStudentsByForeach(){
		int[] ids = {21,23,24};
		List<Student> students = dao.selectStudentsByForeach(ids);
		if(students.size()>0){
			for (Student student : students) {
				System.out.println(student);
			}
		}
	}
	
	@Test
	public void testSelectStudentsByForeach2(){
		List<Integer> ids = new ArrayList<Integer>(); 
		ids.add(21);
		ids.add(24);
		List<Student> students = dao.selectStudentsByForeach2(ids);
		if(students.size()>0){
			for (Student student : students) {
				System.out.println(student);
			}
		}
	}
	
	@Test
	public void testSelectStudentsByForeach3(){
		Student stu1 = new Student();
		stu1.setId(21);
		Student stu2 = new Student();
		stu2.setId(24);
		List<Student> stus = new ArrayList<Student>(); 
		stus.add(stu1);
		stus.add(stu2);
		List<Student> students = dao.selectStudentsByForeach3(stus);
		if(students.size()>0){
			for (Student student : students) {
				System.out.println(student);
			}
		}
	}
	
	@Test
	public void testSelectCountryById(){
			Country country = countryDao.selectCountryById(1);
			//System.out.println(country);
			System.out.println(country.getCname());
			//System.out.println(country.getMinisters());
		}
	
	@Test
	public void testSelectCarById(){
			Car car = carDao.selectCarById(1);
			System.out.println(car);
		}
	
	@Test
	public void testSelectChildrenByParent(){
			List<NewsLabel> children = newsLabelDao.selectChildrenByParent(1);
			for (NewsLabel newsLabel : children) {
				System.out.println(newsLabel);
			}
		}
	
	@Test
	public void testSelectNewsLabelById(){
			NewsLabel newslabel = newsLabelDao.selectNewsLabelById(1);

				System.out.println(newslabel);
		}
	
	@Test
	public void testSelectNewsLabelsById(){
			NewsLabels newslabels = newsLabelDao.selectNewsLabelsById(3);

				System.out.println(newslabels);
		}
	
	@Test
	public void testSelectStudentsById(){
		Students student = studentCourseDao.selectStudentsById(1);
				System.out.println(student);
		}
	
}
