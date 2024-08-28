// 시큐리티 설정 활성화 (기본적인 웹 보안 구성을 설정)
package pack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception{
		// HttpSecurity 객체를 사용하여 보안설정 정의
		security
			.authorizeHttpRequests(authorizeRequest ->  // http 요청에 대한 보안 권한 설정 부분
				authorizeRequest
					.requestMatchers("/login") // 👨🏻💬 (👨🏻‍💻 https://cafe.daum.net/flowlife/HrhB/81)의 인가API에서 antMatcher와 같은 거얌
					.permitAll() // 경로 "/login"에 대한 모든 요청 누구든 접근 허용 (GET 요청: /login 페이지에 대한 접근이 허용되므로 인증 없이 페이지를 볼 수 있음 / POST 요청: 사용자가 로그인 폼을 제출하여 자격 증명을 보내는 과정 허용)
					.anyRequest().authenticated() // 그 외에 나머지 요청은 인증된 경우에만 접근 허용
			)
			.formLogin(formLogin -> 
				formLogin
					.loginPage("/login") // login 페이지 경로 지정
					.defaultSuccessUrl("/", true) // 로그인 성공 시 Context Root로 이동
					.permitAll() // login 페이지는 인증없이 누구든 접근 허용 (실제 로그인 폼 페이지를 사용자에게 제공하기 위한 접근을 허용. 사용자가 로그인 폼을 볼 수 있도록)
			)
			.logout(logout -> 
				logout
					.logoutUrl("/logout") // 👨🏻💬 Spring Security의 기본값이므로 이건 안해도 돼
					.logoutSuccessUrl("/login?logout") // login.html에서 param.logout이 존재할 때 메시지 표시하기 위해 파라미터 추가함
					.permitAll() // logout은 인증없이 누구든 접근 허용
			)
			.sessionManagement(sessionManagement ->
				sessionManagement
					.maximumSessions(1) // 최대 동시 세션 수 제한
					.expiredUrl("/login?expired") // 세션 만료 시 login으로 이동. login.html에서 param.expired이 존재할 때 메시지 표시하기 위해 파라미터 추가함
			);
		
		return security.build();
	}
	
	@Bean
	public UserDetailsService userDetailService() {
		UserDetails user = User.builder()
								.username("hyo")
								.password(passwordEncoder().encode("0729"))
								.roles("USER") // 그룹 형성(유저 역할)
								.build(); // 사용자명, 비밀번호 역할 설정
		return new InMemoryUserDetailsManager(user); 
		// InMemoryUserDetailsManager란
		// - 사용자 정보를 메모리(LAM)에 저장하고 관리하는 클래스
		// - 주로 어플리케이션, 테스트 환경에서 사용. 영구 저장소 X
		// - 어플리케이션 재시작 시 사라짐
		
		// Local Addressable Memory (LAM)
		// 시스템 내에서 로컬 메모리의 주소 지정 가능한 영역을 의미. 특정 하드웨어나 소프트웨어 시스템에서 직접적으로 접근하고 사용할 수 있는 메모리의 영역을 정의하는 개념
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() { // 단방향 해시함수를 이용하여 암호화 수행
		return new BCryptPasswordEncoder(); // 비밀번호 암호화를 BCypt 알고리즘 사용
	}

}
