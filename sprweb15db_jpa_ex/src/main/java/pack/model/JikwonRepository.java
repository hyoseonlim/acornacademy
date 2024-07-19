package pack.model;

import java.util.List;

//import org.springframework.data.jdbc.repository.query.Query; 이거 아니야아아아아아
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// 💞 Method Naming Rule 💞
// find/get/read + By[엔티티명]변수명
// find/get/read + By[엔티티명]변수명 + And/Or + 변수명
// find/get/read + By[엔티티명]변수명 + GreaterThanEqual + 변수명
// ...
import org.springframework.data.repository.query.Param;

public interface JikwonRepository extends JpaRepository<Jikwon, Integer>{ // Id(PK)의 클래스(기본형 int의 wrapper class인 Integer
	// 검색 - Method Naming Rule에 따라 생성한 메소드
	public List<Jikwon> findByJik(String jik); // containing 👉 like '%검색어%' 역할	
}
