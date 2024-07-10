package pack.model;

import lombok.Data;

@Data
public class JikwonDto {
	private String jikwon_no, buser_num, jikwon_pay, jikwon_ppl; // DB에서는 int 타입
	private String jikwon_name, buser_name, jikwon_jik, jikwon_ibsail;
}

// buser 테이블과 join하여 얻는 데이터도 포함함