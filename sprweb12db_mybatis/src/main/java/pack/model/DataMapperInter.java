package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import pack.controller.MemBean;

@Mapper
public interface DataMapperInter { // < 마커 인터페이스 >
	@Select("select num, name, addr from mem") // MyBatis의 어노테이션
	List<MemDto> selectAll();
	
	@Select("select num, name, addr from mem where num=#{num}")
	MemDto selectOne(String num);
	
	@Insert("insert into mem values(#{num},#{name},#{addr})")
	int insertData(MemBean bean);
	
	@Update("update mem set name=#{name}, addr=#{addr} where num=#{num}")
	int updateData(MemBean bean);
	
	@Delete("delete from mem where num=#{num}")
	int deleteData(String num);
	
	// 추상메소드와 MyBatis annotation을 하나로 묶음
}
