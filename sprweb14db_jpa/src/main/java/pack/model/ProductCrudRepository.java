package pack.model;
// 13번 프로젝트와 달리 CrudRepository 말고 JpaRepository 상속
// CrudRepository > PagingAndSortingRepository > JpaRepository
// QueryByExampleExecutor > JpaRepository

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductCrudRepository extends JpaRepository<ProductVo, Integer>{
	
	// JPQL
	@Query(value="select p from ProductVo as p") // 물리적인 테이블명이 아닌 클래스명 써야 프록시 내에서 수행됨
	List<ProductVo> findAllData();
	
	// 메소드 이름을 💟find + (엔티티 이름) + By + 변수명💟 형태로 설정하면 자동으로 쿼리 생성됨. 엔티티의 이름은 생략 가능
	ProductVo findByCode(Integer code);
	
	// where 조건
	@Query(value="select p from ProductVo as p where p.code=:code") // :으로 argument 받기. 이름기반!
	ProductVo findByCode_1(@Param("code") int code); 
	
	@Query(value="select p from ProductVo as p where p.code=?1 or p.sang=?2") // ?로 매개변수 받기. 순서기반!
	List<ProductVo> findByCode_2(int code, String sang);
}
