package pack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pack.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer>{
	
	// 사원번호에 대해 오름차순 정렬된 목록 반환 메소드 (Method Naming Rule 사용)
	List<Emp> findAllByOrderByEmpnoAsc();
	
	// JPQL로 위의 동일한 기능을 하는 메소드 생성 가능
	@Query(value="select e from Emp e order by e.empno asc")
	public List<Emp> getListAll();
	
	// 인자 전달
	// 입력한 salary 초과 자료 오름차순 정렬
	@Query(value="select e from Emp e where e.sal > :salary order by e.sal asc")
	List<Emp> getList(@Param("salary") double salary);
	
	//@Query(value="select e from Emp e where e.sal between :salary1 and :salary2 order by e.sal asc")
	@Query(value="select e from Emp e where e.sal > :salary1 and e.sal < :salary2 order by e.sal asc")
	List<Emp> getListBetween(@Param("salary1") int salary1, @Param("salary2") int salary2);
	
	@Query(value="select e from Emp e where e.sal > ?1 and e.sal < ?2 order by e.sal asc")
	List<Emp> getListBetween2(int salary1, int salary2);
}
