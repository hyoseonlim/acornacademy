// Spring Websocket 애플리케이션에서 클라이언트가 특정 목적지로 전송하는 메시지를 처리하는 메서드를 정의하는 데 사용됨
package pack;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
   @MessageMapping("/message") // '/app/message'로 수신된 메시지를 처리. 라우팅할 때 /app은 적지 않음
   @SendTo("/topic/messages") // 처리된 메시지는 "/topic/message"로 브로드캐스팅된다.
   public String sendMessage(String message) {
      return message; // 받은 메시지 그대로 반환. 자동으로 /topic/messages 경로를 구독하고 있는 모든 클라이언트에 전송
   } 
}
