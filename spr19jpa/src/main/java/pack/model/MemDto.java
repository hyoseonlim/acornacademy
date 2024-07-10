package pack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name="mem") // DB의 특정 table과 mapping
public class MemDto { // Camel Case로 작성 시 JPA가 자동으로 Underscore Naming Convention을 따름 (MemDto -> mem_dto)

	@Id // Primary Key column에 부여
	private int num;
	
	/*
	 @Id
	 @Column(name="num") // 원본 테이블의 컬럼명과 다를 때 필요
	 private int number;
	 */
	
	@Column(nullable = true) // null 허용
	private String name;
	
	private String addr;
	
}
