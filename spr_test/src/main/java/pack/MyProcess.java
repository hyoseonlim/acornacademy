package pack;

public class MyProcess {
	private int dan;
    private Gugudan gugudan;

    public void displayGugudan() {
    	int[] gugu = gugudan.guguCalc(dan);
    	for(int i=0; i<9; i++) {    		
    		System.out.println(gugu[i]);
    	}
    }
    
    public int getDan() {
		return dan;
	}



	public void setDan(int dan) {
		this.dan = dan;
	}



	public Gugudan getGugudan() {
		return gugudan;
	}



	public void setGugudan(Gugudan gugudan) {
		this.gugudan = gugudan;
	}


}
