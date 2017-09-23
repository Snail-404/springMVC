package com.ldu.file.FileUploadController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileUploadController2 {
	@RequestMapping("/batch.do")
	public String batch(@RequestParam("file") CommonsMultipartFile file[],
			HttpServletRequest req) {
		// 获取上传位置
		String path = req.getRealPath("/upload");
		for (int i = 0; i < file.length; i++) {
			// 获取文件名
			String filename = file[i].getOriginalFilename();
			try {
				InputStream is = file[i].getInputStream();
				OutputStream os = new FileOutputStream(new File(path, filename));
				int len = 0;
				byte[] buffer = new byte[400];
				while ((len = is.read(buffer)) != -1) {
					os.write(buffer, 0, len);
				}
				os.close();
				is.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "index.jsp";
	}
}
