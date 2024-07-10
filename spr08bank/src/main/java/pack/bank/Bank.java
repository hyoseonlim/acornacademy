package pack.bank;

// interface는 인스턴스할 수 없으므로 annotation 사용 불가
public interface Bank {
	void inMoney(int money); // 입금
	void outMoney(int money); // 출금
	int checkMoney(); // 잔고 확인
}
