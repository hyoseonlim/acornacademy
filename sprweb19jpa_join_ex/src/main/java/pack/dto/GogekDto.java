package pack.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Gogek;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GogekDto {
	private String name, gen, tel;
	private int no, age;
	
	// Entity ➡️ DTO
	public static GogekDto toDto(Gogek entity) {
		// 1. 성별과 나이 판단을 위한 주민번호
		String jumin = entity.getJumin();
		
		// 2. 성별: 주민번호 뒷자리 첫 숫자의 홀수 여부를 통해 판단
		String gen = (Integer.parseInt(jumin.substring(7, 8)) % 2 != 0) ? "남" : "여"; 
		
		// 3. 나이: 주민번호 맨 앞 2개의 숫자에 1900을 더하며 현재 연도에서 빼기
		// 		   주민번호 뒷자리 첫 숫자가 3 이상이면 2000년도 이후 출생자이므로 100 더 빼기
		int age = LocalDate.now().getYear() - 1900 - Integer.parseInt(jumin.substring(0, 2));
		if(Integer.parseInt(jumin.substring(7, 8)) >= 3) age -= 100;
		
		return GogekDto.builder()
				.no(entity.getNo())
				.name(entity.getName())
				.tel(entity.getTel())
				.gen(gen)
				.age(age)
				.build();
	}
}
