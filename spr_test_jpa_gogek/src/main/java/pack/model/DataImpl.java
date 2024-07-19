package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInterface{
	@Override
	public List<GogekDto> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml 속 persistence-unit의 이름
		EntityManager em = emf.createEntityManager(); // entity의 life span(생명주기)를 관리하고 CRUD를 수행. 내부적으로 Thread 생성	
		List<GogekDto> list = null;
		try{
			list = em.createQuery("select g from GogekDto as g", GogekDto.class).getResultList();
		} catch (Exception e) {
			System.out.println("error: " + e);
		} finally { // close()를 해줘야 작업 후 프로그램이 종료됨
			em.close();
			emf.close();
		}
		return list;	
	}
}
