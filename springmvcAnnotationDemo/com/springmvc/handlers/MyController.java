package com.springmvc.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller  //表示当前类是一个处理器
@RequestMapping("/test") //命名空间
public class MyController  {
	
	@RequestMapping(value="/first.do" , method=RequestMethod.POST , params={"name","!age"})
	public ModelAndView doFirst(HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView mv = new ModelAndView();
		//其底层执行的是request.setAttribute()方法
		mv.addObject("message","执行doFirst()方法");
		mv.setViewName("/WEB-INF/jsp/welcom.jsp");
		return mv;
	}
	
	//多个请求对应同一个方法
	@RequestMapping({"/mysecond.do","second.do"})
	public ModelAndView doSecond(HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView mv = new ModelAndView();
		//其底层执行的是request.setAttribute()方法
		mv.addObject("message","执行doSecond()方法");
		mv.setViewName("/WEB-INF/jsp/welcom.jsp");
		return mv;
	}
	
	//通配符，资源名称必须以third开头
	@RequestMapping("/third*.do")
	public ModelAndView doThird(HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView mv = new ModelAndView();
		//其底层执行的是request.setAttribute()方法
		mv.addObject("message","执行doThird()方法");
		mv.setViewName("/WEB-INF/jsp/welcom.jsp");
		return mv;
	}
	
	//通配符，资源名称必须以fourth结尾
	@RequestMapping("/*fourth.do")
	public ModelAndView doFourth(HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView mv = new ModelAndView();
		//其底层执行的是request.setAttribute()方法
		mv.addObject("message","执行doFourth()方法");
		mv.setViewName("/WEB-INF/jsp/welcom.jsp");
		return mv;
	}
	
	//通配符，路径级数的绝对匹配，即要在test与fifth之间必须要有一级路径
	@RequestMapping("/*/fifth.do")
	public ModelAndView doFifth(HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView mv = new ModelAndView();
		//其底层执行的是request.setAttribute()方法
		mv.addObject("message","执行doFifth()方法");
		mv.setViewName("/WEB-INF/jsp/welcom.jsp");
		return mv;
	}
	
	//通配符，路径级数的绝对匹配，即要在test与sixth之间可以包含多级路径，也可以没有其它路径
	@RequestMapping("/**/sixth.do")
	public ModelAndView doSixth(HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView mv = new ModelAndView();
		//其底层执行的是request.setAttribute()方法
		mv.addObject("message","执行doSixth()方法");
		mv.setViewName("/WEB-INF/jsp/welcom.jsp");
		return mv;
	}
	
	//权限拦截
	@RequestMapping("/permission.do")
	public String doPermission(HttpSession session){
		
		return "/WEB-INF/jsp/welcom.jsp";
	}
}
