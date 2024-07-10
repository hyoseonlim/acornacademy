package anno2_resource;

// 스프링의 어노테이션 @Autowired와 자바 어노테이션 @Resource 비교
import org.springframework.stereotype.Component;

@Component("aaa")
public class Abc2 { // POJO (Plain Old Java Object. 포함/상속 등의 관계 없이 순수하게 멤버필드와 메소드만을 갖는 클래스)
	private int nai;
	
	public void setNai(int nai) {
		this.nai = nai;
	}
	
	public int getNai() {
		return nai;
	}
}
