package pack.gogek;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GogekMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bankinit.xml");
		
		Gogek max = context.getBean("gogek", Gogek.class);
		System.out.println("--- Max ---");
		System.out.println("객체 주소: " + max);
		max.selectBank("shinhan");
		max.showMoney();
		max.playOutMoney(5000);
		max.showMoney();
		
		Gogek hanah = context.getBean("gogek", Gogek.class);
		System.out.println("--- Hanah ---");
		System.out.println("객체 주소: " + hanah);
		hanah.selectBank("shinhan");
		hanah.showMoney();
		hanah.playInMoney(1000);
		hanah.showMoney();
		
		Gogek raye = context.getBean("gogek", Gogek.class);
		System.out.println("--- Raye ---");
		System.out.println("객체 주소: " + raye);
		raye.selectBank("hana");
		raye.showMoney();
		raye.playInMoney(7000);
		raye.showMoney();

	}

}
