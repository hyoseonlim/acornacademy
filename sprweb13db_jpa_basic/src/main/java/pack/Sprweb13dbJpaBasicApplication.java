package pack;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import other.OtherClass;
import pack.model.ProductCRUDRepository;
import pack.model.ProductVo;

@SpringBootApplication
@ComponentScan(basePackages = {"other"})
public class Sprweb13dbJpaBasicApplication {
	@Autowired
	ProductCRUDRepository crudRepository; // CrudRepository의 메소드를 통해 sql문 자동 생성 및 실행
	
	@Autowired
	OtherClass class1; // @Autowired 때문에 생성자 호출될거야

	public static void main(String[] args) {
		SpringApplication.run(Sprweb13dbJpaBasicApplication.class, args)
			.getBean(Sprweb13dbJpaBasicApplication.class).myExecute();
	}
	
	private void myExecute() {
		System.out.println("독립적인 프로그램으로 실행");
		//insData();
		//delData();
		selectData();
		class1.abc();
	}
	
	private void selectData() {
		// 전체 레코드 읽기
		List<ProductVo> list = (List)crudRepository.findAll(); // findAll(): select * from product을 처리
		for(ProductVo p : list) {			
			System.out.println(p.getCode() + " " + p.getSang() + " " + p.getSu() + " " + p.getDan());
		}
		
		// 1개 레코드 읽기
		System.out.println("\n1번 상품만 읽어볼겡");
		ProductVo p = crudRepository.findById(2).get(); // findById(2).get(): select * from product where code=2를 처리 (Id는 PK를 의미)
		System.out.println(p.getCode() + " " + p.getSang() + " " + p.getSu() + " " + p.getDan());
	}

	private void insData() {
		Scanner sc = new Scanner(System.in);
		System.out.print("상품명: ");
		String sang = sc.next();
		System.out.print("수량: ");
		int su = sc.nextInt();
		System.out.print("단가: ");
		int dan = sc.nextInt();
		ProductVo productVo = new ProductVo(null, sang, su, dan);
		crudRepository.save(productVo); // save: PK 여부 판단 -> 있으면 update/ 없으면 auto_increment로 insert
		// 질문!!!!!!!!!그럼 auto_increment 조건 필수?
	}
	
	private void delData() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 상품코드: ");
		int code = sc.nextInt();
		crudRepository.deleteById(code);
	}

}
