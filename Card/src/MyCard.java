import java.util.ArrayList;
import java.util.Random;
public class MyCard implements Card {
	

	public String[] deck = new String[52];
	
	
	public void initialize() {
		
	
		
		String[] suits ={"S","C","H","D"};
		String [] number = {"2","3","4","5","6","7","8","9","10","A","K","Q","J"};
		int index=0;
		for(String s: suits){
			for(String n: number){
				//deck.add(s) + deck.add(n);
				deck[index] = s+" "+n;
				index++;
				
				
			}}}
	
	


	
	
	
	public String drawcard(){
	Random rnd = new Random();
	String card =deck[rnd.nextInt(deck.length-1)];
	return card;
		
	}
	
	
	


	
	

public static void main(String args []){
	MyCard n = new MyCard(); 
	n.initialize();
	String card = n.drawcard();
	System.out.println(card);
	
	
}




}
