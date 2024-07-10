package anno1_auto;

import org.springframework.stereotype.Component;

// @Component: singleton pattern으로 객체 생성. 객체변수명은 자동으로 클래스명 첫글자 소문자로 바꾸고 그대로
// @Component("sender") @Scope("singleton") 이렇게 두 줄을 @Component가 한꺼번에 처리
// 기본이름 안 쓰고 싶으면 @Component("senderbabo") 이렇게 꼭 이름 명시해주기
// 객체 매번 생성하고 싶으면 @Scope("prototype") 이렇게 디폴트 설정 바꿔주기
@Component
public class Sender implements SenderInter { // "SenderInter 타입의 Sender 클래스"
	@Override
	public void show() {
		System.out.println("Sender의 show 메소드 수행");
	}
}
