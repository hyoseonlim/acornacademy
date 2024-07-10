package pack;

import java.util.Scanner;

public class MyProcess{ 
	private int re;
	private String sang;
	SangpumProcess sangProc;
	
	public void setSangProc(SangpumProcess sangProc) {
		this.sangProc = sangProc;
	}
	
	public void inputData() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("상품명 입력: ");
			sang = sc.next();
			System.out.println("수량 입력: ");
			int su = sc.nextInt();
			System.out.println("단가 입력: ");
			int dan = sc.nextInt();
			re= sangProc.calcMoney(sang, su, dan);
		} catch (Exception e) {
			System.out.println("inputData err: "+ e.getMessage());
		}
		
	}
	
	public void showData() {
		System.out.println("상품명은 "+sang+ " -> 금액은 "+ re);
	}
	
}
