package pack.model;

import lombok.Data;

@Data // JPA에서 사용 시 toString()에 문제발생이 가능한 어노테이션
public class SangpumDto {
	private String code, sang, su, dan;
}