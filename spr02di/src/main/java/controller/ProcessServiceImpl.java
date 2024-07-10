package controller;

import model.DataDao;

public class ProcessServiceImpl implements ProcessService{
	private DataDao dataDao; // <클래스의 포함관계> interface를 포함관계로	
	// DataDao의 파생클래스가 DataDaoImpl1,2,3,, 으로 여러 개일 수 있으니까
	// DataDao를 new할 순 없음(인터페이스는 인스턴스 불가) 그 역할을 Impl이 해
	
	public ProcessServiceImpl() {
		// init.xml에서 <bean id="serviceImpl" class="controller.ProcessServiceImpl"></bean>는 argument없는 여기로 넘어오게 돼
		// constructor-arg 설정 안해주면 그래
	}
	
	public ProcessServiceImpl(DataDao dataDao) {
		this.dataDao = dataDao;
	}

	@Override
	public void selectProcess() {
		System.out.println("selectProcess 처리 시작");
		dataDao.selectData(); // model 영역의 클래스가 수행
		System.out.println("selectProcess 처리 끝");
	}
}
