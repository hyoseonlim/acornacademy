package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.mybatis.SqlMapConfig;

@Repository
public class JikwonImpl implements JikwonInter{
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	@Override
	public List<JikwonDto> selectAllJ() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list = null;
		
		try {
			SqlMapperInter mapperInter = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
			list = mapperInter.selectAllJikwon();
		} catch (Exception e) {
			System.out.println("selectAllJ err: " + e);
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return list;
	}
	
	@Override
	public List<JikwonDto> selectJByBuser() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list = null;
		
		try {
			SqlMapperInter mapperInter = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
			list = mapperInter.selectJikwonByBuser();
		} catch (Exception e) {
			System.out.println("selectJByBuser: " + e);
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return list;
	}
	
	@Override
	public List<JikwonDto> selectRichJ() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list = null;
		
		try {
			SqlMapperInter mapperInter = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
			list = mapperInter.selectRichJikwon();
		} catch (Exception e) {
			System.out.println("selectRichJ: " + e);
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return list;
	}

}
