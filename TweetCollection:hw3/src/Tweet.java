import java.util.*;
public class Tweet {
	String author;
	String content;
	Tweet(String author,String content){
		this.author = author;
		this.content = content;
	}
	
	
	void display(){
		System.out.println("Tweets Information: ");
		System.out.println("Author: " + author);
		System.out.println("Content: " + content);
	}
	
	static String getAuthor(String n){
		 int author = n.indexOf(" "); 
		 
		 for(int i=author; i < 0; i++){
			n.charAt(i);
		 }
		return n; 
	}
	

	
	
	
	
	
	
	public static void main(String[] args){
		Tweet ty = new Tweet("Tyler","My First Tweet");
		ty.display();
		
		
	}
}
	
