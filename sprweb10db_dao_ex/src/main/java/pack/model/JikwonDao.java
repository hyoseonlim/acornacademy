package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonDao extends JdbcDaoSupport {
	
	@Autowired
	public JikwonDao(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	// 해당 직급의 직원 읽기
	public List<JikwonDto> getJikwonList(String jik){
		String sql = "select * from jikwon where jikwon_jik = ?";
		List<JikwonDto> list = getJdbcTemplate().query(sql, new Object[]{jik}, (ResultSet rs, int rowNum) -> {
			JikwonDto dto = new JikwonDto();
			dto.setNo(rs.getString("jikwon_no"));
			dto.setName(rs.getString("jikwon_name"));
			dto.setGen(rs.getString("jikwon_gen"));
			dto.setPay(rs.getString("jikwon_pay"));
			return dto;
		});
		return list;
	}
}
