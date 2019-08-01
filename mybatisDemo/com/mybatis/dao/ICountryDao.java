package com.mybatis.dao;

import com.mybatis.entity.Country;

public interface ICountryDao {
	Country selectCountryById(int cid);
}
