package pack;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Main {

	public static void main(String[] args) {
		// JOIN
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		
		try {
			// JPQL 사용
			String jpql = "select j.jikwonNo, j.jikwonName, b.buserName, j.jikwonIbsail from Jikwon j join j.buser b";
			TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
			List<Object[]> results = query.getResultList();
			
			for(Object[] result : results) {
				int year = getYearByHyo((Date)result[3]);
				System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + year);
			}
			
			// Native SQL 사용 (최후의 방법으로 쓴다 ....)
			String sql = "select jikwon_no, jikwon_name, buser_name, year(jikwon_ibsail) from jikwon join buser on buser_num = buser_no";
			Query query2 = em.createNativeQuery(sql); 
			List<Object[]> results2 = query2.getResultList();
			for(Object[] result : results2) {
				System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3]);
			}
		} catch (Exception e) {
			System.out.println("err : " + e);
		} finally {
			em.close();
			emf.close();
		}
	}
	
	private static int getYearByHyo(Date date) { // static인 main에서 부르려고 static
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}
}
