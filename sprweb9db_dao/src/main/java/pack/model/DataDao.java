package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao extends JdbcDaoSupport{ // JdbcDaoSupport: dataSource(DB연결정보제공)와 jdbcTemplate(sql문처리)와 getter/setter 가짐
	
	@Autowired
	public DataDao(DataSource dataSource) { // 상속 받을 때는 field injection가 아닌 constructor injection를 해야 함
		super.setDataSource(dataSource); // DB 연동 정보 갖도록
	}
	
	public List<SangpumDto> selectAll(){
		String sql = "select * from sangdata";
		return (List)getJdbcTemplate().query(sql, new ItemRowMapper()); // JdbcDaoSupport의 메소드
	}
	
	class ItemRowMapper implements RowMapper<Object>{
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			SangpumDto dto = new SangpumDto();
			dto.setCode(rs.getString(1)); // DB에서 읽은 자료
			dto.setSang(rs.getString(2));
			dto.setSu(rs.getString(3));
			dto.setDan(rs.getString(4));
			return dto;
		}
	}
	
}
