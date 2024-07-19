package pack;

public class Gugudan {
    public int[] guguCalc(int dan) {
    	int[] gugu = new int[9];
    	for(int i=0; i<9; i++) {
    		gugu[i] = dan * i;
    	}
    	return gugu;
    } 
}