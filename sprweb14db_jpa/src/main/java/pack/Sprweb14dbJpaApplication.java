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
		selectData();
		saveData();
	}
	
	List<ProductVo> list;
	ProductVo vo;
	
	private void selectData() {
		System.out.println("🐧🐧🐧 JPA의 특징인 DBMS에 독립적인 방법을 사용해보자. 🐧🐧🐧");	
		System.out.println("1️⃣ 전체 자료 읽기");
		System.out.println("✏️ JPARepository가 제공하는 기본 메소드");
		list = repository.findAll();
		for(ProductVo p : list) {
			System.out.println(p.getCode() + " " + p.getSang() + " " + p.getSu() + " " + p.getDan());
		}
		
		System.out.println("✏️ JPQL 사용하여 정의한 메소드");
		list = repository.findAllData();
		for(ProductVo p : list) {
			System.out.println(p.getCode() + " " + p.getSang() + " " + p.getSu() + " " + p.getDan());
		}
		
		System.out.println("2️⃣ 부분 자료 읽기");
		System.out.println("✏️ JPARepository가 제공하는 기본 메소드");
		vo = repository.findById(1).get();
		System.out.println(vo.getCode() + " " + vo.getSang() + " " + vo.getSu() + " " + vo.getDan());
		
		System.out.println("✏️ Method Naming Rule을 따라 정의한 메소드");
		vo = repository.findByCode(2);
		System.out.println(vo.getCode() + " " + vo.getSang() + " " + vo.getSu() + " " + vo.getDan());
	
		System.out.println("✏️ 메소드 이름 임의 생성 💟이름 기반💟");
		ProductVo vo = repository.findByCode_1(1); // 내가 만든 메소드
		System.out.println(vo.getCode() + " " + vo.getSang() + " " + vo.getSu() + " " + vo.getDan());
		
		System.out.println("메소드 이름 임의 생성 💟순서 기반💟");
		List<ProductVo> list = repository.findByCode_2(1, "우비"); // 내가 만든 메소드
		for(ProductVo p : list) {
			System.out.println(p.getCode() + " " + p.getSang() + " " + p.getSu() + " " + p.getDan());
		}	
		
		System.out.println("🐧🐧🐧 최후의 수단으로만 사용하는 DBMS에 의존적인 방법을 사용해보자 🐧🐧🐧");
		System.out.println("✏️ native Query 사용하여 정의한 메소드");
		list = repository.findAllData2();
		for(ProductVo p : list) {
			System.out.println(p.getCode() + " " + p.getSang() + " " + p.getSu() + " " + p.getDan());
		}
	}
	
	private void saveData() { // PK 존재여부로 알아서 update/insert 처리
		ProductVo productVo1 = new ProductVo(null,"볼펜",3,3000);
		repository.save(productVo1);
		
		ProductVo productVo2 = new ProductVo(1,"지우개",3,500);
		repository.save(productVo2);
	}
}
