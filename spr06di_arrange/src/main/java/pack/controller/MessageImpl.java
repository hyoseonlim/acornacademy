package pack.controller;

import pack.model.MyInfoInter;
import pack.other.OutFileInter;

// MessageInter 타입의 파생 클래스(= subclass = child class) 중 하나
public class MessageImpl implements MessageInter{

	// Constructor Injection 을 통해 값 저장 예정
	private String msg1, msg2;
	private int year;
	private MyInfoInter myInfoInter;

	// Setter Injection 용
	private String spec;
	private OutFileInter outFileInter;
	
	public MessageImpl(String m1, String m2, int y, MyInfoInter mii) {
		this.msg1 = m1;
		this.msg2 = m2;
		this.year = y;
		this.myInfoInter = mii;
	}
	
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	public void setOutFileInter(OutFileInter outFileInter) {
		this.outFileInter = outFileInter;
	}
	
	@Override
	public void sayHi() {
		String msg = "MessageImpl 클래스에서 sayHi 내용:";
		msg += "\n" + msg1 + " " + msg2;
		msg += "\n지금은 " + (year+2000) + "년";
		msg += "\n" + spec;
		msg += "\n" + myInfoInter.myData(); // polymorphism. 동일한 statement로 다양한 결과를 받을 수 있음
		System.out.println(msg); // console로 출력
		
		// 위 메시지를 파일로 출력하기!
		outFileInter.outFile(msg);
	}
}
