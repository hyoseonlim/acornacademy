package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pack.controller.MemberBean;

@Repository
public class MemberDao extends JdbcDaoSupport{
	
	@Autowired // DB 연결정보 설정. field injection이 아닌 constructor injection으로 해야 함
	public MemberDao(DataSource dataSource) {
		setDataSource(dataSource); // super.setDataSource(dataSource);
	}
	
	// 전체 자료 읽기
	public List<MemberDto> getMemberList(){
		String sql = "select * from membertab";
		/*
		List<MemberDto> list = getJdbcTemplate().query(sql, new RowMapper() {
			@Override // RowMapper의 추상메소드 mapRow 오버라이드
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberDto dto = new MemberDto();
				dto.setId(rs.getString(1)); // DB에서 읽은 자료
				dto.setName(rs.getString(2));
				dto.setPasswd(rs.getString(3));
				dto.setReg_date(rs.getString(4));
				return dto;
			}
		});
		*/
		
		// RowMapper는 추상 메소드가 1개 (mapRow)이므로 람다식으로 표현 가능
		List<MemberDto> list = getJdbcTemplate().query(sql, (ResultSet rs, int rowNum) -> {
			MemberDto dto = new MemberDto();
			dto.setId(rs.getString(1)); // DB에서 읽은 자료
			dto.setName(rs.getString(2));
			dto.setPasswd(rs.getString(3));
			dto.setReg_date(rs.getString(4));
			return dto;
		});
		return list;
	}
	
	// 추가
	public void insData(MemberBean bean) {
		String sql = "insert into membertab values(?,?,?,now())";
		Object[] params = {bean.getId(), bean.getName(), bean.getPasswd()}; // Object 배열로
		getJdbcTemplate().update(sql, params);
		// ?는 배열로 채우며, select 외에는 모두 update 메소드가 처리
	}
	
	// 특정 레코드 읽기
	public MemberDto getMember(String id) {
		String sql = "select * from membertab where id = ?";
		MemberDto dto = (MemberDto)getJdbcTemplate().queryForObject(sql, new Object[] {id}, new RowMapper() { // 한 개 선택 시 queryForObject()
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberDto dto = new MemberDto();
				dto.setId(rs.getString(1)); // DB에서 읽은 자료
				dto.setName(rs.getString(2));
				dto.setPasswd(rs.getString(3));
				dto.setReg_date(rs.getString(4));
				return dto;
			}
		});
		return dto;
	}
	
	// 수정
	public void upData(MemberBean bean) {
		String sql = "update membertab set name=?, passwd=? where id=?";
		getJdbcTemplate().update(sql, new Object[] {bean.getName(), bean.getPasswd(), bean.getId()});
	}
	
	// 삭제
	public void delData(String id) {
		String sql = "delete from membertab where id=?";
		getJdbcTemplate().update(sql, new Object[] {id});
	}
}
