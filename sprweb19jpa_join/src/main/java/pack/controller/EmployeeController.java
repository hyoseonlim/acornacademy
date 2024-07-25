package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import pack.dto.DeptDto;
import pack.dto.EmpListDto;
import pack.entity.Dept;
import pack.entity.Emp;
import pack.repository.DeptRepository;
import pack.repository.EmpRepository;

@Controller
public class EmployeeController {
	
	@Autowired
	private EntityManagerFactory factory; // JPQL 연습용
	
	@Autowired
	private EmpRepository empRepo;
	
	@Autowired
	private DeptRepository deptRepo;
	
	@GetMapping("/employee/list")
	public String emplist(Model model) {
		// 모든 직원 정보 출력
		// List<Emp> elist = empRepo.findAll(); // 기본 메소드
		List<Emp> elist = empRepo.findAllByOrderByEmpnoAsc(); // 네이밍룰따라 만든 메소드
		model.addAttribute("list",elist);
		return "/employee/elist";
	}
	
	@GetMapping("/employee/dept")
	public String dept(@RequestParam("deptno") int deptno, Model model) {
		// 부서 정보 출력
		Dept d =  deptRepo.findById(deptno).get();
		DeptDto dto = DeptDto.toDto(d);
		model.addAttribute("dto",dto);
		return "/employee/dept";
	}
	
	// <JPQL 연습장 관련>
	@GetMapping("/jpql")
	public String jpql() {
		return "jpql";
	}
	
	@ResponseBody
	@PostMapping("/jpql/test")
	public List<EmpListDto> test(@RequestParam("query") String query){
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<EmpListDto> list = null;
		try {
			// 전달받은 query(JPQL)문 실행
			TypedQuery<Emp> tQuery = em.createQuery(query, Emp.class);
			list = tQuery.getResultStream().map(EmpListDto::toDto).toList(); // map은 함수를 실행하는 함수!
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return list;
	}
}