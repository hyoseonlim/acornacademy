package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/insert")
public class UploadController {
	
	@Autowired
	private FriendService friendService;
	
	@GetMapping
	public String showInsertForm() {
		return "insert";
	}
	
	@PostMapping("/upload")
	public String handleFileUpload(@RequestParam("bunho") int bunho, @RequestParam("irum") String irum, 
			@RequestParam("junhwa") String junhwa, @RequestParam("jikup") String jikup, @RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {
		
		// 파일 크기 2MB로 제한
		if(!file.isEmpty() && file.getSize() > 2097152){
			// Flash 속성 추가 메소드. 일회성. 주로 리다이렉트 후 사용자에게 메시지 전달에 사용
			redirectAttributes.addFlashAttribute("message", "파일 크기가 넘 커! 미얀~ 다시 추가 시도해줘 (˘･_･˘)");
			return "redirect:/insert";
		}
		
		// Image Mime Type 예) image/jpeg, ...
		if(!file.getContentType().startsWith("image/")) { // 이미지 파일인지 확인
			redirectAttributes.addFlashAttribute("message", "이미지 파일만 업로드 가능! (；′⌒`)");
			return "redirect:/insert";
		}
		
		try {
			Friend friend = new Friend();
			friend.setBunho(bunho);
			friend.setIrum(irum);
			friend.setJikup(jikup);
			friend.setJunhwa(junhwa);
			friend.setSajin(file.getBytes());
			friend.setImagetype(file.getContentType());
			
			friendService.saveFriend(friend);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "이미지 파일 저장 중 오류 발생: " + e);
			return "redirect:/insert";
		}
		return "redirect:/list";
	}
	
}
