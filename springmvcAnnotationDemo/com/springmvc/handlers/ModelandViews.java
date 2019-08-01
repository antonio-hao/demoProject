package com.springmvc.handlers;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.springmvc.beans.Student;

@Controller  //表示当前类是一个处理器
@RequestMapping("/mv") //命名空间
public class ModelandViews  {
	
	@RequestMapping("/mandv.do")
	//需要返回视图和数据使用ModelAndView
	public ModelAndView doMoAndView(String name,int age){
		System.out.println("name:" + name);
		System.out.println("age:" + age);
		ModelAndView mv = new ModelAndView();
		mv.addObject("name",name);
		mv.addObject("age", age);
		mv.setViewName("/WEB-INF/jsp/register.jsp");
		return mv;
	}
	
	@RequestMapping("/myview.do")
	//页面跳转，只需要返回视图，不返回数据使用String
	public String doMyView(){
		return "/index.jsp";
	}
	
	@RequestMapping("/myview2.do")
	//页面跳转，只需要返回视图，不返回数据使用String
	public String doMyView2(){
		//视图对象名称
		return "taobao";
	}
	
	@RequestMapping("/myAjax.do")
	//页面不跳转，只返回model数据不返回视图使用void,可以用于AJAX响应
	public void doMyAjax(String name,int age,HttpServletResponse response) throws IOException{
		System.out.println("name="+name + "age" + age);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pname", name);
		map.put("page", age);
		String myJson = JSON.toJSONString(map);
		PrintWriter out = response.getWriter();
		out.print(myJson);
		out.close();
	}
	
	@RequestMapping(value="/myAjax2.do", produces="text/html;charset=utf-8")//设置结果类型
	@ResponseBody //将返回的数据放入响应体中，返回类型数值型、字符串型、自定义类型对象、Map集合、List集合
	public Object doMyAjax2() {
		//return 123.45;
		//return "我很帅";
		//return new Student("张三",23);
		
		/**
			Map<String,Student> map = new HashMap<String,Student>();
			map.put("stu1", new Student("张三",24));
			map.put("stu2", new Student("李四",22));
			return map;
		**/
		
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("张三",24));
		list.add(new Student("李四",22));
		return list;
	}
	
	
}
