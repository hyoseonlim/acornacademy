package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pack.controller.FormBean;

@Mapper
public interface DataMapInterface {
	List<Jikwon> selectAll(String chosenBuser);
	List<Jikwon> selectByRating(FormBean bean);
}
