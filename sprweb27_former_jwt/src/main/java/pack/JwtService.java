package pack;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Service
public class JwtService {
	private Key key; // JWT (JSON Web Token)을 서명, 검증하는 데 사용할 비밀 키 저장 변수
	
	@PostConstruct // 객체 생성 후 의존성 주입 완료 시 자동 호출
	public void init() {
		key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // HS256 알고리즘을 사용해 비밀 키 생성
	}
	
	public String createToken(String id) { // JWT 문자열 생성 후 반환
		return Jwts.builder()
				.setSubject(id) // 토큰 주제를 사용자 Id로 설정
				.setIssuedAt(new Date()) // 토큰 발행시간
				.setExpiration(new Date(System.currentTimeMillis() + 360000)) // 토큰 유효시간 (1시간)
				.signWith(key) // 비밀키로 토큰에 서명
				.compact();
	}
	
	// JWT에서 사용자 Id 추출
	public String getUserFromToken(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(key) // 토큰 검증 시 사용할 비밀 키 설정
				.build() // Parser Builder를 완성
				.parseClaimsJws(token) // 주어진 JWT 토큰 파싱 및 검증
				.getBody() // 토큰 클레임을 가져옴
				.getSubject(); // 토큰 주제를 반환 (토큰 생성 시 사용자 id로 설정한 값, setSubject(id))
	}
	
}