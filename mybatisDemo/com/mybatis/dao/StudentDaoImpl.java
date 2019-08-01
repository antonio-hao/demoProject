package com.mybatis.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.entity.Student;
import com.mybatis.utils.MyBatisUtils;

public class StudentDaoImpl implements IStudentDao {

	private SqlSession sqlSession;

	@Override
	public void insertStudent(Student student) {
		
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//4.相关操作
			sqlSession.insert("test.insertStudent", student);
			sqlSession.commit();
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
	}

	@Override
	public void insertStudentCacheId(Student student) {

		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//4.相关操作
			sqlSession.insert("test.insertStudentCacheId", student);
			sqlSession.commit();
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		
	}

	@Override
	public void deleteStudentById(int id) {
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//4.相关操作
			sqlSession.delete("test.deleteStudentById", id);
			sqlSession.commit();
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		
	}

	@Override
	public void updateStudent(Student student) {
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//4.相关操作
			sqlSession.update("test.updateStudent", student);
			sqlSession.commit();
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		
	}

	@Override
	public List<Student> selectAllStudents() {
		List<Student> students = new ArrayList<Student>();
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//4.相关操作
			students = sqlSession.selectList("test.selectAllStudents");
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return students;
	}

	@Override
	public Map<String, Object> selectAllStudentsMap() {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//4.相关操作
			map = sqlSession.selectMap("test.selectAllStudents", "id");
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return map;
	}

	@Override
	public Student selectStudentById(int id) {
		Student student = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//4.相关操作
			student = sqlSession.selectOne("test.selectStudentById",id);
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return student;
	}

	@Override
	public List<Student> selectStudentsByName(String name) {

		List<Student> students = new ArrayList<Student>();
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//4.相关操作
			students = sqlSession.selectList("test.selectStudentsByName",name);
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return students;
	}

	@Override
	public List<Student> selectStudentsByCondition(Map<String, Object> map) {
		List<Student> students = new ArrayList<Student>();
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//4.相关操作
			students = sqlSession.selectList("test.selectStudentsByCondition",map);
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return students;
	}
	
	@Override
	public List<Student> selectStudentsByCondition2(String name,int age) {
		List<Student> students = new ArrayList<Student>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("0", name);
		map.put("1", age);
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//4.相关操作
			students = sqlSession.selectList("test.selectStudentsByCondition2",map);
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return students;
	}

	@Override
	public List<Student> selectStudentsBycondition3(Student student) {
		List<Student> students = new ArrayList<Student>();
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//4.相关操作
			students = sqlSession.selectList("test.selectStudentsByCondition3",student);
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return students;
	}
	
	@Override
	public List<Student> selectStudentsByChoose(Student student) {
		List<Student> students = new ArrayList<Student>();
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//4.相关操作
			students = sqlSession.selectList("test.selectStudentsByChoose",student);
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return students;
	}
	
	@Override
	public List<Student> selectStudentsByForeach(int[] ids) {
		List<Student> students = new ArrayList<Student>();
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//4.相关操作
			students = sqlSession.selectList("test.selectStudentsByForeach",ids);
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return students;
	}
	
	@Override
	public List<Student> selectStudentsByForeach2(List<Integer> ids) {
		List<Student> students = new ArrayList<Student>();
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//4.相关操作
			students = sqlSession.selectList("test.selectStudentsByForeach2",ids);
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return students;
	}
	
	@Override
	public List<Student> selectStudentsByForeach3(List<Student> ids) {
		List<Student> students = new ArrayList<Student>();
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//4.相关操作
			students = sqlSession.selectList("test.selectStudentsByForeach3",ids);
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return students;
	}


}
