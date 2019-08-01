package com.springmvc.handlers;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.beans.People;
import com.springmvc.beans.Student;
import com.springmvc.exceptions.AgeException;
import com.springmvc.exceptions.NameException;
import com.springmvc.exceptions.StudentException;

@Controller  //表示当前类是一个处理器
@RequestMapping("/rg") //命名空间
public class Register  {
	
	@RequestMapping("/register.do")
	//映射参数，矫正请求参数名称
	public ModelAndView doRegister(@RequestParam("pname") String name,int age){
		System.out.println("name:" + name);
		System.out.println("age:" + age);
		ModelAndView mv = new ModelAndView();
		mv.addObject("name",name);
		mv.addObject("age", age);
		mv.setViewName("/WEB-INF/jsp/register.jsp");
		return mv;
	}
	
	@RequestMapping("/register2.do")
	//整体接受时，要求表单参数名与对象属性名相同
	public ModelAndView doRegister2(Student student){
		System.out.println("name:" + student.getName());
		System.out.println("age:" + student.getAge());
		ModelAndView mv = new ModelAndView();
		mv.addObject("student",student);
		mv.setViewName("/WEB-INF/jsp/register.jsp");
		return mv;
	}
	
	//访问路径变量
	@RequestMapping("/{pname}/{age}/register3.do")
	public ModelAndView doRegister3(@PathVariable("pname") String name,@PathVariable int age){
		System.out.println("name:" + name);
		System.out.println("age:" + age);
		ModelAndView mv = new ModelAndView();
		mv.addObject("name",name);
		mv.addObject("age", age);
		mv.setViewName("/WEB-INF/jsp/register.jsp");
		return mv;
	}
	
	//请求重定向（redirect）到页面
	@RequestMapping("/register4.do")
	public ModelAndView doRegister4(String name,int age){
		System.out.println("name:" + name);
		System.out.println("age:" + age);
		ModelAndView mv = new ModelAndView();
		mv.addObject("pname",name);
		mv.addObject("page", age);
		mv.setViewName("redirect:/register.jsp");
		return mv;
	}
	
	//请求重定向到controller
		@RequestMapping("/register5.do")
		public String doRegister5(String name,int age,Model model){
			model.addAttribute("name", name);
			model.addAttribute("age", age);
			return "redirect:register4.do";
		}
		
		
		@RequestMapping("/register6.do")
		//异常处理
		public ModelAndView doRegister6(@RequestParam("pname") String name,int age) throws StudentException{
			//异常信息
			//int i = 3/0;
			if(!"beijing".equals(name)){
				throw new NameException("用户名不正确");
			}
			if(age > 60){
				throw new AgeException("太老了");	
			}
			
			System.out.println("name:" + name);
			System.out.println("age:" + age);
			ModelAndView mv = new ModelAndView();
			mv.addObject("name",name);
			mv.addObject("age", age);
			mv.setViewName("/WEB-INF/jsp/register.jsp");
			return mv;
		}
		
		//注解式异常处理,可以指定处理的异常,处理NameException异常
		@ExceptionHandler(NameException.class)
		public ModelAndView handlerNameException(Exception ex){
			ModelAndView mv = new ModelAndView();
			mv.addObject("ex", ex);
			mv.setViewName("/errors/nameError.jsp");								
			return mv;
		}
		
		//注解式异常处理,可以指定处理的异常，,处理AgeException异常
		@ExceptionHandler(AgeException.class)
		public ModelAndView handlerAgeException(Exception ex){
			ModelAndView mv = new ModelAndView();
			mv.addObject("ex", ex);					
	/*		if(ex instanceof AgeException){
				mv.setViewName("/errors/ageError.jsp");
			}*/
			mv.setViewName("/errors/ageError.jsp");
			return mv;
		}
		
		//处理其它异常
		@ExceptionHandler
		public ModelAndView handlerException(Exception ex){
			ModelAndView mv = new ModelAndView();
			mv.addObject("ex", ex);
			mv.setViewName("/errors/error.jsp");
			return mv;
		}
		
		//自定义日期类型转换器
		@RequestMapping("/register7.do")
		public ModelAndView doRegister7(int age,Date birthday){
			System.out.println("age:" + age);
			System.out.println("birthday:" + birthday);
			ModelAndView mv = new ModelAndView();		
			mv.addObject("age", age);
			mv.addObject("birthday", birthday);
			mv.setViewName("redirect:/register.jsp");
			return mv;
		}
		//类型转换异常处理器
		@ExceptionHandler(TypeMismatchException.class)
		public ModelAndView exceptionResolver(HttpServletRequest request,Exception ex){
			ModelAndView mv = new ModelAndView();
			String age = request.getParameter("age");
			String birthday = request.getParameter("birthday");
			String errorMSG = ex.getMessage();
			if(errorMSG.contains(age)){
				mv.addObject("ageErrors", "年龄输入有误");
			}
			if(errorMSG.contains(birthday)){
				mv.addObject("birthdayErrors", "日期输入有误");
			}

			mv.addObject("age", age);
			mv.addObject("birthday", birthday);
			mv.setViewName("/index.jsp");
			return mv;
		}
		
		//初始化参数绑定
		@InitBinder
		public void initBinder(WebDataBinder binder){
			DateFormat df = new SimpleDateFormat("yyyy-MM-hh");
			binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
		}
		
		//数据验证
		@RequestMapping("/register8.do")
		public ModelAndView doRegister8(@Validated People people,BindingResult br ){
			ModelAndView mv = new ModelAndView();		
			mv.addObject("people", people);
			mv.setViewName("/register.jsp");
			
			int errorCount = br.getErrorCount();
			if(errorCount > 0 ){
				FieldError nameError = br.getFieldError("name");
				FieldError scoreError = br.getFieldError("score");
				FieldError mobileError = br.getFieldError("mobile");
				
				if(nameError != null){
					String nameErrorMSG = nameError.getDefaultMessage();
					mv.addObject("nameErrorMSG", nameErrorMSG);
				}
				if(scoreError != null){
					String scoreErrorMSG = scoreError.getDefaultMessage();
					mv.addObject("scoreErrorMSG", scoreErrorMSG);
				}
				if(mobileError != null){
					String mobileErrorMSG = mobileError.getDefaultMessage();
					mv.addObject("mobileErrorMSG", mobileErrorMSG);
				}
				mv.setViewName("/index.jsp");
			}
			return mv;
		}
}
