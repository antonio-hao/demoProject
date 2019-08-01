package com.mybatis.dao;

import com.mybatis.entity.Car;

public interface ICarDao {
	Car selectCarById(int cid);
}
