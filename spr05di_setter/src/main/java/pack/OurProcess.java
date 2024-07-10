package pack;

public class OurProcess {
	private String name;
	private int num;
	private Gugudan gugu;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public void setGugu(Gugudan gugu) {
		this.gugu = gugu;
	}
	
	// 모든 클래스의 super class인 Object의 메소드 overriding
	@Override
	public String toString() {
		int[] results = gugu.numberCalc(num);
		String str = "";
		for (int i = 0; i < results.length; i++) {
			str += num + " * " + (i+1) + " = " + results[i] + "\n";
		}
		return "작성자: " + name + "\n" + num + "단 결과:  \n" + str;
	}
}
