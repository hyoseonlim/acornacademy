package anno2_resource;

// 스프링의 어노테이션 @Autowired와 자바 어노테이션 @Resource 비교
import org.springframework.stereotype.Component;

@Component
public class Abc1 { // POJO (Plain Old Java Object. 포함/상속 등의 관계 없이 순수하게 멤버필드와 메소드만을 갖는 클래스)
	private String irum;
	
	public void setIrum(String irum) {
		this.irum = irum;
	}
	
	public String getIrum() {
		return irum;
	}
}
