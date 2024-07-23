package pack;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@SpringBootApplication
public class Sprweb19jpaJoinApplication {
	// 1️⃣ application에서 SQL 처리용 메소드 연습하기
	// 2️⃣ @MVC로 회원자료 처리
	// 3️⃣ @MVC로 직원자료 처리 (Join)
	// 4️⃣ JPQL 연습용 화면 작성: Ajax
	
	@Autowired
	private EntityManagerFactory emf;
	
	@PostConstruct // 생성자 이후 자동 실행
	public void initMembers() {
		// Hibernate 객체 사용: dept, emp 샘플 데이터를 JPQL을 이용해 저장
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction(); // @Transaction 어노테이션과 같음
		tx.begin();
		
		try {
			List<String> queries = new ArrayList<String>();
			queries.add("INSERT INTO DEPT VALUES (10, 'ACCOUNTING', 'NEW YORK');");
			queries.add("INSERT INTO DEPT VALUES (20, 'RESEARCH', 'DALLAS');");
			queries.add("INSERT INTO DEPT VALUES (30, 'SALES', 'CHICAGO');");
			queries.add("INSERT INTO DEPT VALUES (40, 'OPERATIONS', 'BOSTON');");
			queries.add("INSERT INTO EMP VALUES (7839,'KING','PRESIDENT',NULL,TO_DATE('1981-11-17','YYYY-MM-DD'),5000,NULL,10);");
			queries.add("INSERT INTO EMP VALUES (7698,'BLAKE','MANAGER',7839,TO_DATE('1981-05-01','YYYY-MM-DD'),2850,NULL,30);");
			queries.add("INSERT INTO EMP VALUES (7782,'CLARK','MANAGER',7839,TO_DATE('1981-05-09','YYYY-MM-DD'),2450,NULL,10);");
			queries.add("INSERT INTO EMP VALUES (7566,'JONES','MANAGER',7839,TO_DATE('1981-04-01','YYYY-MM-DD'),2975,NULL,20);");
			queries.add("INSERT INTO EMP VALUES (7654,'MARTIN','SALESMAN',7698,TO_DATE('1981-09-10','YYYY-MM-DD'),1250,1400,30);");
			queries.add("INSERT INTO EMP VALUES (7499,'ALLEN','SALESMAN',7698,TO_DATE('1981-02-11','YYYY-MM-DD'),1600,300,30);");
			queries.add("INSERT INTO EMP VALUES (7844,'TURNER','SALESMAN',7698,TO_DATE('1981-08-21','YYYY-MM-DD'),1500,0,30);");
			queries.add("INSERT INTO EMP VALUES (7900,'JAMES','CLERK',7698,TO_DATE('1981-12-11','YYYY-MM-DD'),950,NULL,30);");
			queries.add("INSERT INTO EMP VALUES (7521,'WARD','SALESMAN',7698,TO_DATE('1981-02-23','YYYY-MM-DD'),1250,500,30);");
			queries.add("INSERT INTO EMP VALUES (7902,'FORD','ANALYST',7566,TO_DATE('1981-12-11','YYYY-MM-DD'),3000,NULL,20);");
			queries.add("INSERT INTO EMP VALUES (7369,'SMITH','CLERK',7902,TO_DATE('1980-12-09','YYYY-MM-DD'),800,NULL,20);");
			queries.add("INSERT INTO EMP VALUES (7788,'SCOTT','ANALYST',7566,TO_DATE('1982-12-22','YYYY-MM-DD'),3000,NULL,20);");
			queries.add("INSERT INTO EMP VALUES (7876,'ADAMS','CLERK',7788,TO_DATE('1983-01-15','YYYY-MM-DD'),1100,NULL,20);");
			queries.add("INSERT INTO EMP VALUES (7934,'MILLER','CLERK',7782,TO_DATE('1982-01-11','YYYY-MM-DD'),1300,NULL,10);");
			tx.commit();
		} catch (Exception e) {
			System.out.println("err: " + e);
			tx.rollback();
		} finally {
			em.close();
		}
	}


	public static void main(String[] args) {
		SpringApplication.run(Sprweb19jpaJoinApplication.class, args);
	}
}