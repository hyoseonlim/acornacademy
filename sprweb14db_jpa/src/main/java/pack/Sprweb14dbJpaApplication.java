package pack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pack.model.ProductCrudRepository;
import pack.model.ProductVo;

@SpringBootApplication
public class Sprweb14dbJpaApplication {
	@Autowired
	ProductCrudRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Sprweb14dbJpaApplication.class, args)
			.getBean(Sprweb14dbJpaApplication.class).execute();
	}
	
	private void execute() {
		System.out.println("💞💞💞 execute 💞💞💞");
		//insertData();
		selectData();
	}
	
	private void insertData() {
		/*
		ProductVo productVo = new ProductVo();
		productVo.setSang("볼펜");
		productVo.setSu(3);
		productVo.setDan(3000);
		productVo = repository.save(productVo);
		
		ProductVo productVo = new ProductVo();
		productVo.setCode(1);
		productVo.setSang("지우개");
		productVo.setSu(3);
		productVo.setDan(2500);
		productVo = repository.save(productVo);
		*/
	}
	
	private void selectData() {
		System.out.println("전체 자료 읽기: DBMS에 독립적이다.");
		List<ProductVo> list = repository.findAll();
		for(ProductVo p : list) {
			System.out.println(p.getCode() + " " + p.getSang() + " " + p.getSu() + " " + p.getDan());
		}
		
		System.out.println("부분 자료 읽기: DBMS에 독립적이다.");
		ProductVo p = repository.findById(1).get(); // 제공되는 메소드
		System.out.println(p.getCode() + " " + p.getSang() + " " + p.getSu() + " " + p.getDan());
		
		System.out.println("⭐⭐⭐⭐규칙대로 주면 알아서 찾아⭐⭐⭐⭐");
		ProductVo p3 = repository.findByCode(2); // 규칙에 의해 내가 만든 메소드
		System.out.println(p3.getCode() + " " + p3.getSang() + " " + p3.getSu() + " " + p3.getDan());
	
		System.out.println("⭐⭐⭐⭐JPQL 사용⭐⭐⭐⭐");
		List<ProductVo> list2 = repository.findAllData(); // 내부메소드가 아닌 JPQL을 사용하여 정의한 추상메소드임
		for(ProductVo p2 : list2) {
			System.out.println(p2.getCode() + " " + p2.getSang() + " " + p2.getSu() + " " + p2.getDan());
		}
		
		System.out.println("⭐⭐⭐⭐ 메소드 이름 임의 생성 <💟이름 기반💟> ⭐⭐⭐⭐");
		ProductVo p4 = repository.findByCode_1(1); // 내가 만든 메소드
		System.out.println(p4.getCode() + " " + p4.getSang() + " " + p4.getSu() + " " + p4.getDan());
		
		System.out.println("⭐⭐⭐⭐ 메소드 이름 임의 생성 <💟순서 기반💟> ⭐⭐⭐⭐");
		List<ProductVo> list3 = repository.findByCode_2(1, "우비"); // 내가 만든 메소드
		for(ProductVo vo : list3) {
			System.out.println(vo.getCode() + " " + vo.getSang() + " " + vo.getSu() + " " + vo.getDan());
		}
		
	}
}
