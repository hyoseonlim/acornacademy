package pack;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // STOMP 웹소켓 메시징 활성화
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{ // 일반 메소드를 가진 인터페이스이므로 선택적으로 Override 가능
   
   @Override
   public void configureMessageBroker(MessageBrokerRegistry registry) {
      registry.enableSimpleBroker("/topic"); // '/topic'으로 시작하는 메시지는 메시지 브로커로 라우팅됨
      registry.setApplicationDestinationPrefixes("/app"); // '/app'으로 시작하는 메시지를 현재 서버로 보냄
   }
   
   @Override // STOMP 엔드포인트 등록
   public void registerStompEndpoints(StompEndpointRegistry registry) {
      registry.addEndpoint("/ws")
      .setAllowedOriginPatterns("*") // 모든 도메인을 허용하면서 allowCredentials(자격, 증명)을 사용 가능 ("http://localhost:3000", "https://korea.com" 등 허용할 특정 도메인 명시 가능)
      .withSockJS(); // '/ws' 엔드포인트는 SockJS 옵션을 통해 웹소켓을 사용 가능하도록 설정
   }
   
}
