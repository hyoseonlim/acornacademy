package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.MemBean;

@Repository
public class DataProcess { // DataMappingInter를 읽어오는 클래스
	
	private Logger logger = LoggerFactory.getLogger(this.getClass()); // 확인하고 싶은 내용 출력을 위함
	
	@Autowired
	private DataMapperInter dataMapperInter; // Spring에 의해 hikari pool이 자동 지원됨
	
	// 전체 자료 읽기
	public List<MemDto> getAllData(){
		List<MemDto> list = dataMapperInter.selectAll();
		logger.info("전체 자료 크기: " + list.size());
		return list;
	}
	
	// 부분 자료 읽기
	public MemDto getOneData(String num) {
		MemDto dto = dataMapperInter.selectOne(num);
		return dto;
	}
	
	// 추가
	public boolean insert(MemBean bean) {
		// 번호 중복 방지 또는 번호 자동 증가 작업이 필요하나 생략..
		int result = dataMapperInter.insertData(bean);		
		return (result > 0) ? true : false;
	}
	
	// 수정
	public boolean update(MemBean bean) {
		int result = dataMapperInter.updateData(bean);
		return (result > 0) ? true : false;
	}
	
	// 삭제
	public boolean delete(String num) {
		int result = dataMapperInter.deleteData(num);
		return (result > 0) ? true : false;
	}
}
