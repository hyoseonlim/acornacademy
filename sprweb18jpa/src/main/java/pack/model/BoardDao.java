package pack.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pack.controller.BoardBean;

@Repository
public class BoardDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DataRepository repository;
	
	// 전체 자료 읽기
	public List<Board> all(){
		/*
		List<Board> list = repository.findAll();
		logger.info("list size: " + list.size());
		*/
		return repository.findAll(); // 기본 제공 메소드
	}
	
	// Proxy 객체는 해당 메소드가 처리될 때 Commit or Rollback을 수행
	// CheckedException 또는 예외가 없는 경우 Commit 수행
	// UncheckedException이 발생하면 Rollback 수행
	// select 제외하고 모두 이걸 걸어주자 🐻‍❄️🐧
	@Transactional
	public String insertData(BoardBean bean) {
		try {
			Board dto = new Board(); // Entity지만 여기선 DTO로 사용 중
			dto.setNum(repository.maxNum() + 1); // 번호 부여
			dto.setAuthor(bean.getAuthor());
			dto.setTitle(bean.getTitle());
			dto.setContent(bean.getContent());
			dto.setBwrite(Timestamp.valueOf(LocalDateTime.now()));
			dto.setReadcnt(0);
			repository.save(dto);
			return "success";
		} catch (Exception e) {
			return "입력 오류: " + e.getMessage();
		}
	}
	
	@Transactional
	public Board detail(int num) {
		// 조회수 증가
		repository.updateReadCnt(num);
		// Board board = repository.findById(num).get(); 
		// 👉 Java의 영원한 숙적인 NullPointerException 발생 가능하여 처리가 필요
		// 👉 Repository에서 findById()의 반환값을 Optional 타입으로 설정하여 해결
		// null 이어도 에러 발생하지 않음
		Optional<Board> board = repository.findById(num);
		logger.info("board::{}", board.get()); // {} 안에 들어감
		if(board.isPresent()) {
			return board.get();
		} else {
			return new Board();
		}
	}
	
	@Transactional
	public String updateData(BoardBean bean) {
		try {
			Optional<Board> boardOptional = repository.findById(bean.getNum());
			Board board = boardOptional.get();
			board.setAuthor(bean.getAuthor());
			board.setTitle(bean.getTitle());
			board.setContent(bean.getContent());
			
			// repository.save(board)할 필요 없이 수정됨. 엔티티니까
			return "success";
		} catch (Exception e) {
			return "수정 오류: " + e.getMessage();
		}
	}
	
	@Transactional
	public String deleteData(int num) {
		try {
			repository.deleteById(num);
			return "success";
		} catch (Exception e) {
			return "삭제 오류: " + e.getMessage();
		}
	}
	
	public List<Board> getByTitle(String searchValue){
		return repository.selectLikeTitle(searchValue);
	}
	
	public List<Board> getByAuthor(String searchValue){
		return repository.searchLikeAuthor(searchValue);
	}
	
	public void updateReadCnt(int num){
		repository.updateReadCnt(num);
	}
	
}
