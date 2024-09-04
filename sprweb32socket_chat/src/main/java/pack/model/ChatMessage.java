// 가독성을 위해 메시지 객체(데이터 구조) 정의: 메시지 타입(입장, 채팅, 퇴장), 발신자, 내용 등을 정의
package pack.model;

import lombok.Data;

@Data
public class ChatMessage {
	private String sender; // 채팅명 식별
	private String content; // 메시지 내용
	private MessageType type;
	
	public enum MessageType{ // 열거형(상수값을 그룹화하여 코드의 안정성, 가독성 향상)을 이용한 메시지 유형 정의
		CHAT,
		JOIN,
		LEAVE
	}
}
