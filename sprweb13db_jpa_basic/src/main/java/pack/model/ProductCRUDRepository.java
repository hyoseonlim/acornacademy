package pack.model;

import org.springframework.data.repository.CrudRepository;

public interface ProductCRUDRepository extends CrudRepository<ProductVo, Integer>{ // interface를 상속받는 interface :)
	// save(), findById(), count() 등을 지원받음 https://cafe.daum.net/flowlife/HrhB/87
	
	
	
}
