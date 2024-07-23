package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Board, Integer>{ // <Entity, ID type>
	// JPQL
	
	// ✏️ 제목 검색용
	@Query("select b from Board b where b.title like %?1%") // 위치 접근자 (?로)
	List<Board> selectLikeTitle(String searchValue);
	
	// ✏️ 작성자 검색용
	@Query("select b from Board b where b.author like %:searchValue%") // 이름 접근자 (:로. @Param 어노테이션 사용)
	List<Board> searchLikeAuthor(@Param("searchValue") String searchValue);
	
	// ✏️ 추가 시 가장 큰 번호 얻기
	@Query("select max(b.num) from Board b")
	int maxNum();
	
	// ✏️ 상세보기 접근 시 조회수 증가
	// JPA는 update, delete, (insert)에서 대량의 데이터를 처리하는 <벌크 연산>을 내부적으로 수행: 영속성 컨텍스트에 있는 값과 DB에 있는 값이 다를 수 있다. https://dev-gorany.tistory.com/327
	// 벌크 연산 수행 후 영속성 컨텍스트에 있는 쿼리 refresh(clear)를 처리가 필수적 👉 @Modifying 어노테이션을 사용
	@Modifying(clearAutomatically = true) // 1차 캐시를 비워주는 설정. 영속성 컨텍스트의 쿼리를 초기화
	@Query(value = "update Board b set b.readcnt = b.readcnt + 1 where b.num = ?1")
	void updateReadCnt(int num);
}
