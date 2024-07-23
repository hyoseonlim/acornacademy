package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Jikwon, Integer>{
	
	List<Jikwon> findByBuser(int buser);
	List<Jikwon> findByBuserAndRating(int buser, String rating);
	
	@Query(value = "select buser_name from buser where buser_no = ?1", nativeQuery = true)
	String findBuserName(int buser);
}
