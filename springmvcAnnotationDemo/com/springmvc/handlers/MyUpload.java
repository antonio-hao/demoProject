package com.springmvc.handlers;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller  //表示当前类是一个处理器
@RequestMapping("/up") //命名空间
public class MyUpload  {
	
	@RequestMapping("/upload.do")
	public String doFileUpload(MultipartFile img,HttpSession session) throws Exception{
		//String path = "F:/java/JavaProject/springmvc-annotation/WebContent/image";
		String path=session.getServletContext().getRealPath("/image");
		
		if (img.getSize() > 0 ) {
			//获取到上传文件的原始名称
			String fileName = img.getOriginalFilename();
			if (fileName.endsWith("jpg") || fileName.endsWith("png")) {
				File file = new File(path, fileName);
				img.transferTo(file);
				return "/index.jsp";
			}
			
		}
		return "/upload.jsp";
	}
	
	@RequestMapping("/upload2.do")
	public String doFileUploads(@RequestParam MultipartFile[] imgs,HttpSession session) throws Exception{
		//String path = "F:/java/JavaProject/springmvc-annotation/WebContent/image";
		String path=session.getServletContext().getRealPath("/image");
		
		for (MultipartFile img : imgs) {
			if (img.getSize() > 0) {
				//获取到上传文件的原始名称
				String fileName = img.getOriginalFilename();
				if (fileName.endsWith("jpg") || fileName.endsWith("png")) {
					File file = new File(path, fileName);
					img.transferTo(file);					
				}

			} 
		}
		return "/index.jsp";
	}
	
}
