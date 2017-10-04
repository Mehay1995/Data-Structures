
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;




public class TweetCollection extends ArrayList<Tweet>{
  
  


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


public void StoreTweets(int n) throws IOException {  

        URL url = new URL("http://homes.soic.indiana.edu/classes/spring2016/csci/c343-yye/tweet-data-Jan16.txt");

        Scanner in = new Scanner(url.openStream());

        int i = 0;
        while (in.hasNext() && (i < n)) {
            String wholeTweet = in.nextLine();
            String a[] = wholeTweet.split(" ", 2);
            String author = a[0];
            String content = a[1];
            Tweet newTweet = new Tweet(author, content);
            this.add(newTweet);
            i++;
            
        }
        in.close();
    }


  
public void removeTweet(int i) { //Deletes the tweet at index i from the list
    this.remove(i);
  }

public String getMessage(int i) { //Returns the content of a given Tweet, given an index
    Tweet newTweet = this.get(i);
    return newTweet.content;
  }

public String AuthorFindTweet(String n) { //Given an author as an input, will print out first tweet by this author
    for (int j = 0; j < this.size(); j ++) {
      if (FindAuthor(j).equals(n)) {
        return getMessage(j);
      
      }
      else {
        
      }
    }
    return "The Author you selected "+ n + " does not exist, try a new author!";
  }
 
  public String FindAuthor(int i) { // returns author of that Tweet at a given index
    Tweet newtweet = this.get(i);
    return newtweet.author;
  }

  
  
  public static void main(String[] args) throws IOException {
    TweetCollection tweetcollection = new TweetCollection();
    tweetcollection.StoreTweets(20);
    tweetcollection.removeTweet(2);
    // System.out.println(a.AuthorFindTweet(2)); will fail, checking if delete tweet worked
    System.out.println(tweetcollection.FindAuthor(2));
    System.out.println(tweetcollection.AuthorFindTweet("mitsmr"));
    System.out.println(tweetcollection.AuthorFindTweet("SuperMan"));
    System.out.println(tweetcollection.FindAuthor(5));
    System.out.println(tweetcollection.getMessage(6));
  }
}
