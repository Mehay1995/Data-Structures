import java.util.*;
public class DNADist {
	
	private String sequenceOne;
	private String sequenceTwo;
	

		
	public static int HammingDistance(String sequenceOne, String sequenceTwo){
		int index = 0;
		for(int i = 0; i < sequenceOne.length(); i++)
		{
			if(sequenceOne.charAt(i) != sequenceTwo.charAt(i)) 
			{
				index++;
			}
			
		}
		return index;
		
	}
	
	public static String dnaSequence() {
		Random rnd = new Random();
		String sequence = "";
		String[] dna = {"A","D","G","T"};
		for (int i = 0; i < 20; i++) {
			sequence += dna[rnd.nextInt(dna.length)];
		}
		return sequence;
		
	}
	
	public static void main(String args []){
		String one = dnaSequence();
		String two = dnaSequence();
		int index;
		index = HammingDistance(one,two);
		
		System.out.println("Your first DNA Sequence is " + one);
		System.out.println("Your second DNA Sequence is " + two);
		System.out.println("The Hamming Distance is " + index);
		
		
		
	}
	
	
	
}
	


