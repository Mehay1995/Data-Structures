import java.io.*
import java.net.URL;
import java.util.*;


public class searchWord {
	
	public void search(String word){
		int count = 0;
		String line = "";
		
		HashMap<String, LinkedList<Integer>> hash = new HashMap<String, LinkedList<Integer>>();
		
		try {
			File file = new File("C:\\Documents\\wikipedia.txt");
			FileReader reader = new FileReader(file);
			BufferedReader buff = new BufferedReader(reader);
			
			
			
			while((line = buff.readLine()) != null){
				count++;
				String words[] = line.split("");
				
				for (int i = 0; i < words.length; i++){
					String k = words[i];
					if(!hash.containsKey(k)) {
						hash.put(k,new LinkedList<Integer>());
					}
					LinkedList<Integer> value = hash.get(k);
					if(!value.contains(count)){
						hash.get(k).add(count);
					}
				}
			}
		if (hash.containsKey(word)){
			System.out.println("Word" + word + "is found on lines" + hash.get(word).toString());
		}
		else {
			System.out.println("Word" + word + "is not found in this document");
		}
	
		buff.close();
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
		searchWord map = new searchWord();
		map.search("algorithm");
		map.search("data");
		
	}
	
}
