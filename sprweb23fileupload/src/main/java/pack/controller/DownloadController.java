package pack.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DownloadController {

	@PostMapping("download")
	@ResponseBody
	public byte[] downProcess(HttpServletResponse res, @RequestParam("filename") String filename) throws Exception{
		System.out.println(filename);
		File file = new File("C:\\work2\\sprsou\\sprweb23fileupload\\src"
				+ "\\main\\resources\\static\\upload\\" + filename);
		byte[] bytes = FileCopyUtils.copyToByteArray(file);
	      String fn = new String(file.getName().getBytes(), "iso_8859_1");
	      
	      // 브라우저에 다운로드 지시
	      res.setHeader("Content-Disposition", "attachment;filename= \"" + fn + "\"");
	      // attachment : 열지 않고 바로 다운로드
	      res.setContentLength(bytes.length);
	      
	      return bytes;

	}
}
