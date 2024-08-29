package pack.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
	private int id;
	private String userName;
	private String password;
	private String role; // Authority 정보를 저장할 칼럼 (ROLE_XXX 형식)
}
