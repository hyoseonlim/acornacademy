package pack.bank;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // 디폴트였던 싱글톤 설정에서 바꿔줘야 새로운 객체가 생성되어 하나의 객체 재사용하여 발생하는 논리적인 문제를 방지
public class HanaBank implements Bank{
	private int money = 9000;
	
	@Override
	public void inMoney(int money) {
		this.money += money;
	}
	
	@Override
	public void outMoney(int money) {
		this.money -= money;	
	}
	
	@Override
	public int checkMoney() {
		return money;
	}
}
