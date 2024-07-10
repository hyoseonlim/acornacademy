package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInterface{
	
	@Override
	public List<JikwonDto> selectAllJikwon() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml 속 persistence-unit의 이름
		EntityManager em = emf.createEntityManager(); // entity의 life span(생명주기)를 관리하고 CRUD를 수행. 내부적으로 Thread 생성
		List<JikwonDto> list = em.createQuery("select j from JikwonDto as j", JikwonDto.class).getResultList();
		em.close();
		emf.close();
		return list;
	}

	@Override
	public List<Object>  selectAllBuser() {
		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("hello"); // persistence.xml 속 persistence-unit의 이름
		EntityManager em1 = emf1.createEntityManager(); // entity의 life span(생명주기)를 관리하고 CRUD를 수행. 내부적으로 Thread 생성
		List<Object> result = em1.createQuery("select jj.buser_num, conunt(jj.jikwon_no) FROM JikwonDto as jj group by jj.buser_num", Object.class).getResultList();
		System.out.println("사이즈는" + result.size());
		em1.close();
		emf1.close();
		return result;
	}
}
