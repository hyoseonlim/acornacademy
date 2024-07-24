package pack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Member;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
	private long num;
	private String name;
	private String addr;
	
	// Entity ➡️ DTO
	public static MemberDto toDto(Member entity) {
		return MemberDto.builder()
				.num(entity.getNum())
				.name(entity.getName())
				.addr(entity.getAddr())
				.build();
	}
}
