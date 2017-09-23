package com.ldu.file.FileUploadController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileUploadController {
	@RequestMapping("/upload")
	public String upload(@RequestParam("file") CommonsMultipartFile file,
			HttpServletRequest req,String userName) {
		System.out.println("userName:"+userName);
		long startTime = System.currentTimeMillis();
		// 获取文件上传位置
		String path = req.getRealPath("/upload");
		System.out.println("path:" + path);

		// 获取文件名
		String filename = file.getOriginalFilename();
		try {
			InputStream is = file.getInputStream();
			OutputStream os = new FileOutputStream(new File(path, filename));
			int len = 0;
			byte buffer[] = new byte[400];
			while ((len = is.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}
			os.close();
			is.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		long endTime = System.currentTimeMillis();
		System.out.println("方法一的运行时间：" + String.valueOf(endTime - startTime)
				+ "ms");
		return "index.jsp";
	}
}
