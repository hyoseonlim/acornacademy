package pack.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult; // 에러를 자동으로 잡아주는 클래스
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@GetMapping("/upload")
	public String abc(UploadFile uf) {
		return "uploadform";
	}
	
	@PostMapping("/upload")
	public String submit(UploadFile uploadFile, Model model, BindingResult result) {
		InputStream is = null;
		OutputStream os = null;
		
		// 업로드된 파일 검사
		MultipartFile file = uploadFile.getFile();
		String fileName = file.getOriginalFilename();
		if(result.hasErrors()) return "err";
		
		try {
			is = file.getInputStream();
			File newFile = new File("C:\\work2\\sprsou\\sprweb23fileupload\\src"
					+ "\\main\\resources\\static\\upload\\" + fileName); // 절대경로
			if(!newFile.exists()) {
				newFile.createNewFile();
			}
			os = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024]; // 1KB
			while((read = is.read(bytes)) != -1) { // 자료가 존재하는 동안
				os.write(bytes, 0, read);
			}
		} catch (Exception e) {
			System.out.println("File Submit Error: " + e);
			return "err";
		} finally {
			try {
				is.close();
				os.close();
			} catch (Exception e2) {
				System.out.println("Cannot Close Error: " + e2);
			}
		}
		model.addAttribute("filename", fileName);
		return "uploadfile";
	}
	
}
