package com.mybatis.dao;

import java.util.List;

import com.mybatis.entity.NewsLabel;
import com.mybatis.entity.NewsLabels;

public interface INewsLabelDao {
	List<NewsLabel> selectChildrenByParent(int pid);
	NewsLabel selectNewsLabelById(int id);
	
	NewsLabels selectNewsLabelsById(int id);
}
