package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemRepository extends JpaRepository<Mem, Integer>{
	
	// num 자동 증가용
	@Query(value="select max(m.num) from Mem m") // @Query(value="select max(num) from mem", nativeQuery = true)
	int findByMaxNum();
	
	/*
	@Query("select m from Mem as m where m.num=?1") // plSql. 매핑방법은 두가지(순서/이름)
	Mem findByNum(String num);
	*/
	
}
