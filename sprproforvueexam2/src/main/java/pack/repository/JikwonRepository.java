package pack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pack.model.Jikwon;

public interface JikwonRepository extends JpaRepository<Jikwon, Integer>{
	List<Jikwon> findByJik(String keyword);
}
