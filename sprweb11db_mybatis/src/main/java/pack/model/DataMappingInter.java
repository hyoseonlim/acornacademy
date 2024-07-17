package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import pack.controller.FormBean;

@Mapper // interface는 Spring 어노테이션 달 거 없고, 이건 MyBatis 어노테이션
public interface DataMappingInter {
	
	@Select("select * from jikwon")
	List<SangpumDto> selectAllJikwon();
	
	@Select("select * from gogek")
	List<SangpumDto> selectAllGogek();
	
	@Select("select * from sangdata")
	List<SangpumDto> selectAllSang();
	
	//@Select("select code, sang, su, dan from sangdata where sang like '%'||#{searchValue}||'%'")
	@Select("select code, sang, su, dan from sangdata where sang like concat('%', #{searchValue}, '%')")
	List<SangpumDto> selectSearch(FormBean bean);
	
}
