package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.MemBean;

@Repository
public class DataProcess {

	@Autowired
	MemRepository repository;
	
	public List<Mem> getAllData(){
		return repository.findAll();
	}
	
	public Mem getOneData(int num) {
		return repository.findById(num).get();
	}
	
	public boolean insert(MemBean bean) {
		// PK 자동 증가
		// int newNum = repository.findByMaxNum() + 1;
		
		// PK 중복 확인
		try {
			Mem mem = repository.findById(bean.getNum()).get();
			// 성공적으로 읽어왔다면 이미 등록된 번호임을 의미
			return false;
		} catch (Exception e) {
			// 에러 발생은 해당 값을 가져오지 못함을 의미 = 추가 가능
			try {
				Mem mem = new Mem();
				mem.setNum(bean.getNum());
				mem.setName(bean.getName());
				mem.setAddr(bean.getAddr());
				repository.save(mem);
				return true;
			} catch (Exception e2) {
				//System.out.println("err: " + e2);
				return false;
			}
		}
	}
	
	public boolean update(MemBean bean) {
		try {
			Mem mem = new Mem();
			mem.setNum(bean.getNum());
			mem.setName(bean.getName());
			mem.setAddr(bean.getAddr());
			repository.save(mem);
			return true;
		} catch (Exception e2) {
			return false;
		}
	}

	public boolean delete(int num) {
		try {
			repository.deleteById(num);
			return true;
		} catch (Exception e2) {
			return false;
		}
	}
	
	
	
}
