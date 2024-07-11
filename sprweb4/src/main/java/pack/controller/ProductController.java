package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.ProductModel;

@Controller
public class ProductController {
	
	@Autowired // field injection
	private ProductModel productModel;
	
	@GetMapping("insdata")
	public String method1() {
		return "redirect:input.html";
	}
	
	@PostMapping("insdata")
	public String method2(ProductBean bean, Model model) { // ProductBean에 바로 데이터 저장됨
		model.addAttribute("data", productModel.computePrice(bean));
		return "result";
	}
}
