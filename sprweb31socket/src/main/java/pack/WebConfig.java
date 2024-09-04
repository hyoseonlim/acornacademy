package pack;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
	// CORS 설정 관리를 위한 인터페이스
	// 글로벌 CORS 설정은 모든 HTTP 엔드포인트에 대해 적용됨
	// 필요에 따라 특정 경로에 대해서만 CORS 설정도 가능
	// 이러한 설정을 통해 다른 도메인에서의 WebSocket 연결 문제 해결
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
			.addMapping("/**")
			.allowedOrigins("*") // 모든 도메인 허용
			.allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메소드
			.allowedHeaders("*"); // 모든 헤더 적용
				
	}
}
