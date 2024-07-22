package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.BoardBean;

@Repository
public class BoardDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DataMapInterface mapper;
	
	public List<Board> all(){
		List<Board> list = null;
		try {
			list = mapper.selectAll();
		} catch (Exception e) {
			logger.info("all() err" + e);
		}
		return list;
	}
	
	public Board detail(String num){
		// 조회수 증가 후 상세보기 처리
		mapper.updateReadcnt(num);
		Board board = null;
		try {
			board = mapper.selectOne(num);
		} catch (Exception e) {
			logger.info("all() err" + e);
		}
		return board;
	}
	
	public boolean insert(BoardBean bean) {
		int re = mapper.insert(bean);
		return (re > 0) ? true : false;
	}
	
	public boolean update(BoardBean bean) {
		System.out.println(bean.getAuthor() + "/ " + bean.getTitle() + "/ " + bean.getContent());
		int re = mapper.update(bean);
		return (re > 0) ? true : false;
	}
	
	public boolean delete(BoardBean bean) {
		int re = mapper.delete(Integer.toString(bean.getNum()));
		return (re > 0) ? true : false;
	}
	
	public List<Board> search(BoardBean bean){
		List<Board> list = null;
		try {
			list = mapper.selectSearch(bean);
		} catch (Exception e) {
			logger.info("all() err" + e);
		}
		return list;
	}
}
