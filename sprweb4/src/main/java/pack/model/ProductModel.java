package pack.model;

import org.springframework.stereotype.Service;

import pack.controller.ProductBean;

@Service // 또는 @Component라고 써도 돼
public class ProductModel {
	public String computePrice(ProductBean bean) {
		String data = "품명: " + bean.getSang() + ", 금액: " + (bean.getSu() * bean.getDan());
		return data;
	}

}
