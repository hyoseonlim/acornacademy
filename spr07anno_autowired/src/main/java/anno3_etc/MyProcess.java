package anno3_etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("my")
public class MyProcess {
	// @Value: 변수에 값을 초기화하기 위해 사용할 수도 있다. Spring EL: #{표현식}. 속성값 참고 시에는 $ 사용 
	@Value("#{dataInfo.name}") // 필드에서 name에 값 치환
	private String name;
	
	private String part;
	
	@Value("20") //@Value(20)으로 쓰면 에러. 기본이 String type이기 때문. 알아서 int로 convert될 것
	private int age;
	
	@Value("1,2,3,4")
	private int arr[];
	
	
	/*
	@Autowired
	public MyProcess(@Value("영업부") String part) { // 생성자에서 part에 값 치환
		this.part = part;
	}
	*/
	
	@Autowired
	public MyProcess(@Value("#{dataInfo.part}") String part) { // 생성자에서 part에 값 치환
		this.part = part;
	}
	
	
	public void showData() {
		System.out.println("name: " + name);
		System.out.println("part: " + part);
		System.out.println("age: " + age);
		System.out.println("arr[0]: " + arr[0]);
		System.out.println("arr[3]: " + arr[3]);
	}
}
