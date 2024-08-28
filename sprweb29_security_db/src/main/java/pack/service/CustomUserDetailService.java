// 사용자 인증 시 사용자 정보 로드 역할
package pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pack.model.Jikwon;
import pack.repository.JikwonRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private JikwonRepository jikwonRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String sabun) throws UsernameNotFoundException { // 여기선 username으로 sabun, password로 irum을 사용
		// 사원번호로 사용자 정보 조회하여 해당 결과로 UserDetails 객체를 생성하여 반환
		Long jikwonNo = Long.parseLong(sabun);
		Jikwon jikwon = jikwonRepository.findById(jikwonNo)
								.orElseThrow(() -> new UsernameNotFoundException(sabun + "번은 존재하지 않는 사번입니다."));
		return User.builder()
					.username(String.valueOf(jikwon.getNo()))
					.password(passwordEncoder.encode(jikwon.getName())) // 암호화하여 사용
					.roles("USER")
					.build();
	}
}
