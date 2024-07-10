package pack.model;

// MyInfoInter 타입의 파생 클래스(= subclass = child class) 중 하나
public class MyInfoImpl implements MyInfoInter{
	@Override
	public String myData() {
		return "취미는 운동";
	}
}
