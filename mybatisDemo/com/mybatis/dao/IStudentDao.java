package com.mybatis.dao;

import java.util.List;
import java.util.Map;

import com.mybatis.entity.Student;

public interface IStudentDao {
	void insertStudent(Student student);
	void insertStudentCacheId(Student student);
	
	void deleteStudentById(int id);
	void updateStudent(Student student);
	
	List<Student> selectAllStudents();
	Map<String,Object> selectAllStudentsMap();
	Student selectStudentById(int id);
	List<Student> selectStudentsByName(String name);
	List<Student> selectStudentsByCondition(Map<String, Object> map);
	List<Student> selectStudentsByCondition2(String name,int age);
	List<Student> selectStudentsBycondition3(Student studnet);
	List<Student> selectStudentsByChoose(Student student);
	List<Student> selectStudentsByForeach(int[] ids);
	List<Student> selectStudentsByForeach2(List<Integer> ids);
	List<Student> selectStudentsByForeach3(List<Student> ids);
}
