package pack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product") // 안하면 테이블명 PRODUCT_VO로 만듦
public class ProductVo { // VO (Value Object)
	
	@Id 
	private Integer code;
	
	private String sang;
	private Integer su;
	private Integer dan;
	
}
