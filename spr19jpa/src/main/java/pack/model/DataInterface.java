package pack.model;

import java.util.List;

public interface DataInterface {
	// dto 객체가 아닌 entity 객체
	List<MemDto> selectDataAll();
}
