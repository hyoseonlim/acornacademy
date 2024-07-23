package pack.model;

import java.util.List;

//import org.springframework.data.jdbc.repository.query.Query; 이거 아니야아아아아아
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

public interface SangpumRepository extends JpaRepository<Sangpum, Integer>{ // Id(PK)의 클래스(기본형 int의 wrapper class인 Integer
	
	// 검색 - Method Naming Rule에 따라 생성한 메소드
	public List<Sangpum> findBySangStartingWith(String searchValue); // startingWith 👉 like '%검색어' 역할
	public List<Sangpum> findBySangContaining(String searchValue); // containing 👉 like '%검색어%' 역할
	public List<Sangpum> findBySangEndingWith(String searchValue); // endingWith 👉 like '검색어%' 역할

	// 검색 - JPQL 사용
	@Query(value="SELECT s FROM Sangpum as s WHERE s.sang LIKE %:searchValue%")
	public List<Sangpum> searchLike(@Param("searchValue") String searchValue);
	
}
/*
💞 Method Naming Rule 💞
find/get/read + By[엔티티명]변수명
find/get/read + By[엔티티명]변수명 + And/Or + 변수명
find/get/read + By[엔티티명]변수명 + GreaterThanEqual + 변수명
*/
