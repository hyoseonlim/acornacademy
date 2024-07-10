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
	public List<MemDto> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml 속 persistence-unit의 이름
		EntityManager em = emf.createEntityManager(); // entity의 life span(생명주기)를 관리하고 CRUD를 수행. 내부적으로 Thread 생성
		EntityTransaction tx = em.getTransaction(); // transaction을 관리하는 Interface
			
		List<MemDto> list = null;
		try {
//			레코드 추가
			/*
			tx.begin();
			MemDto dto1 = new MemDto();
			dto1.setNum(4);
			dto1.setName("워추워");
			dto1.setAddr("서초구 방배동");
			em.persist(dto1); // insert
			// Hibernate: insert pack.model.MemDto 
			//실제 SQL 처리: insert into mem (addr, name, num) values (?, ?, ?)
			tx.commit();
			*/
			
//			레코드 수정
			/*
			tx.begin();
			MemDto dto2 = em.find(MemDto.class, 4);
			dto2.setName("추워요");
			tx.commit();
			// Hibernate: update pack.model.MemDto 
			// 실제 SQL 처리: update mem set addr=?, name=? where num=?
			*/
			
//			레코드 삭제
			/*
			tx.begin();
			MemDto dto3 = em.find(MemDto.class, 4);
			em.remove(dto3);
			// Hibernate: delete pack.model.MemDto 
			// 실제 SQL 처리: delete from mem where num=?
			*/
			
//			부분 자료 읽기
			System.out.println("부분 자료 읽기 (단일 엔티티) find() 메소드 사용");
			MemDto mdto = em.find(MemDto.class, 1); // find(Class<T> entityClass, Object primaryKey)
			System.out.println(mdto.getNum() + " " + mdto.getName() + " " + mdto.getAddr());
			
//			전체 자료 읽기
			System.out.println("전체 자료 읽기 (JPQL 사용)");
			/*
			list = findAll(em, MemDto.class); // entity class를 줌
			for(MemDto m : list) {
				System.out.println(m.getNum() + " " + m.getName() + " " + m.getAddr());
			}
			*/
			list = em.createQuery("select e from MemDto as e", MemDto.class).getResultList();
			// RDBMS 종류에 관계없이 공통적으로 사용하는 "select e from MemDto as e" 을 Hibernate가 DBDialect를 보고 실제 SQL문으로 변환해줌
			// ==> select memdto0_.num as num1_0_, memdto0_.addr as addr2_0_, memdto0_.name as name3_0_ from mem memdto0_
			
		} catch (Exception e) {
			tx.rollback();
		} finally {
			// close()를 해줘야 작업 후 프로그램이 종료됨
			em.close();
			emf.close();
		}
		return list;	
	}

	public<T> List<T> findAll(EntityManager em, Class<T> cla){
		// JPQL
		return em.createQuery("select e from " + cla.getSimpleName() + "as e", cla).getResultList(); // table의 별명이 e임	
	}
}
