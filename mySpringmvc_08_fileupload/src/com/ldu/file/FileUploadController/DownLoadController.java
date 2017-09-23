package com.ldu.file.FileUploadController;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DownLoadController {
	@RequestMapping("/download")
	public ResponseEntity<byte[]> download() throws IOException {
		String path="F:\\spring-mvc\\.metadata\\.me_tcat\\webapps\\mySpringmvc_08_fileupload\\upload\\p2.jpg";
		//String path = "D:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\springMVC\\WEB-INF\\upload\\图片10（定价后）.xlsx";
		File file = new File(path);
		HttpHeaders headers = new HttpHeaders();
		String fileName = new String("你好.jpg".getBytes("UTF-8"), "iso-8859-1");// 为了解决中文名称乱码问题
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
				headers, HttpStatus.CREATED);
	}
}
