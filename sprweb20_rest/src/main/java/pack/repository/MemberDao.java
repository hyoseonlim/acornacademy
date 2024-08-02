package pack.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.dto.MemberDto;

@Repository
public class MemberDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 회원자료 전체 읽기
	public List<MemberDto> getList(){
		return sqlSession.selectList("member.getList"); // namespace값.id값
	}
	
	public MemberDto getData(int num) {
		return sqlSession.selectOne("member.getData", num);
	}
	
	public void insert(MemberDto dto) {
		sqlSession.insert("member.insert", dto);
	}
	
	public void update(MemberDto dto) {
		sqlSession.insert("member.update", dto);
	}
	
	public void delete(int num) {
		sqlSession.insert("member.delete", num);
	}
	
}
