package pack.gogek;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import pack.bank.Bank;
import pack.bank.HanaBank;
import pack.bank.ShinhanBank;

@Service
@ComponentScan("pack.bank")
@Scope("prototype") // 디폴트였던 싱글톤 설정에서 바꿔줘야 새로운 객체가 생성되어 하나의 객체 재사용하여 발생하는 논리적인 문제를 방지
public class Gogek {
	private Bank bank;
	private String msg;
	
	@Autowired(required = true) // type으로 연결. 있으면 사용, 없으면 에러
	private ShinhanBank shinhanBank;
	
	@Resource(name="hanaBank") // name으로 연결
	private HanaBank hanaBank;
	
	public void selectBank(String sel) {
		if(sel.equals("shinhan")) {
			bank = shinhanBank;
		} else if(sel.equals("hana")) {
			bank = hanaBank;
		}
	}
	
	public void playInMoney(int money) {
		bank.inMoney(money); // 이때의 bank는 고객 선택에 따라 shinhanBank나 hanaBank일 것
	}
	
	public void playOutMoney(int money) {
		bank.outMoney(money);
	}
	
	@PostConstruct // 생성자 처리 후 자동 호출 -> 초기화 작업 가능
	public void setMessage() {
		msg = "계좌 잔고: ";
	}
	
	@PreDestroy // 웹서비스 종료 직전 자동 호출 -> 마무리 작업 가능
	public void ending() {
		if(shinhanBank != null) shinhanBank = null;
		if(hanaBank != null) hanaBank = null;
	}
	
	public void showMoney() {
		System.out.println(msg + bank.checkMoney());
	}
}
