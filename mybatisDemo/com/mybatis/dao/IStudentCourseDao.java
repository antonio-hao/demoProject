package com.mybatis.dao;

import com.mybatis.entity.Students;

public interface IStudentCourseDao {
	Students selectStudentsById(int sid);
}
