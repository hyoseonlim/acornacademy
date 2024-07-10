package pack;

public class MyProcess { // setter injection 사용
	private int age;
	private String name;
	private ShowData showData; // class의 포함관계
	
	public MyProcess() {
		// 여기 생성자 내에서보다, setter에서 값을 설정하는 것이 유연성이 높음
		// 이유는 생성자는 최초 1회만 호출되기 때문
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setShowData(ShowData showData) {
		this.showData = showData;
	}
	
	public void displayData() {
		System.out.println("이름은 " + name + ", 나이는 " + age + ", 별명은 " + showData.processNickName() + ", 취미는 " + showData.processHobby());
	}
}
