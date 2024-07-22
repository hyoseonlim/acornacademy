package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pack.controller.BoardBean;

@Mapper
public interface DataMapInterface {
	// 추상 메소드명은 mapper.xml의 id명과 일치시키기
	
	List<Board> selectAll();  // 전체 자료 조회
	List<Board> selectSearch(BoardBean bean); // 검색 결과 조회
	Board selectOne(String num); // 부분 자료 조회
	int insert(BoardBean bean); // 추가
	int updateReadcnt(String num); // 조회수 + 1
	int update(BoardBean bean); // 수정
	int delete(String num); // 삭제
}
