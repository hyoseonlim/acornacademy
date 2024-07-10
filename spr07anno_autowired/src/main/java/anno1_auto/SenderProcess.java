package anno1_auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/*
[참고] 
계층(Layer)별 어노테이션 구분 (모두 @Component의 자식)
- Application Layer: client와 data 입출력을 제어 (@Controller, ..)
- Domain Layer: application 중심. 업무처리 담당 (@Service, ..)
- Infrastructure Layer: DB에 대한 영속성(persistence). 지속성 담당 (@Repository, ..)
*/

// @Component 보다는, @Service 어노테이션으로 비즈니스 로직을 운영하는 클래스임을 구체화하여 가독성을 높임
// @Servie("senderProcess") 와 @Scope("singleton")을 합친 것이 @Service
@Service
public class SenderProcess {
	// @Autowired: Bean의 자동 삽입을 위해 사용하는 어노테이션. 이름이 아닌 🌟type🌟으로 매핑! 
	
	/*
	@Autowired // 1. Field Injection: (권장) 주로 사용됨. 간단함. 테스트 불편
	private Sender sender;
	*/
	
	/*
	@Autowired // 2. Setter Injection: 코드가 장황해짐(긴 코드 길이)
	public void setSender(Sender sender) {
		this.sender = sender;
	}
	
	@Autowired // 3. Constructor Injection: 불변성. 테스트 편리. 생성자가 너무 많아짐
	public SenderProcess(Sender sender) {
		this.sender = sender;
	}
	*/
	
	@Autowired
	@Qualifier("sender") // @Qualifier("sender1")
	private SenderInter senderInter;
	// Sender 클래스의 주소를 매핑. 인터페이스니까 자동으로 파생클래스를 찾음
	// 이름이 아니라 타입만 찾는 어노테이션
	// 파생클래스가 2개 이상(SenderInter 타입이 2개 이상)이면 못 찾는다..! (expect single matching)
	// 따라서 이때 @Autowired와 함께 이의 보조 어노테이션인 @Qualifier를 쓴다

	
	public void dispData() {
		senderInter.show();
	}
	
}
