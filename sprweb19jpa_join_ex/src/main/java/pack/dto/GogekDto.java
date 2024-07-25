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
		String jumin = entity.getJumin();
		String gen = (Integer.parseInt(jumin.substring(7, 8)) % 2 != 0) ? "남" : "여"; 
		int age = LocalDate.now().getYear() - 1900 - Integer.parseInt(jumin.substring(0, 2));
		return GogekDto.builder()
				.no(entity.getNo())
				.name(entity.getName())
				.tel(entity.getTel())
				.gen(gen)
				.age(age)
				.build();
	}
}
