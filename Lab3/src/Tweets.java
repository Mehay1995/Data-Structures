import java.util.*;
public class Tweets {
	
	String author; 
	String content;
	
	Tweets(String a, String c) {
		this.author = a;
		this.content = c;

		
	}
	
String report() {
	return
			("The Author of this tweet is " + author + " Tweet: " + content);
}

	public static void main(String[] args) {
		Tweets uno = new Tweets("Tyler", "This is my first tweet");
		System.out.println(uno.report());

	}

}
