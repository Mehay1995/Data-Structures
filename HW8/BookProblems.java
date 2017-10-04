
public class BookProblems {
/*
 * 9.10)
 * int m = size;
 * int[] array = new int[m];
 *  Transpose(E x) {
 *  int i = 0;
 *  while (int i < array.length()) {
 *  if(array[0] == x) { } // if the item is equal to the first item
 *  else if(array[i] == x) {
 *  array[i-1] = x; // if found, replace the first item with input 
 *  }
 *  i++;
 * }
 * else 
 * array = Arrays.copyOf(array, array.length + 1); //  creating a new array with size + 1 to accomodate adding the new input to the end
 * array[array.length -1] = x;
 * }
 * 9.13)
 * 
 * A) This function is not good because array does not have indices of decimal
 * places. Some inputs will not yield a decimal however there is a chance that 
 * a decimal index could be produced.
 * 
 * B) This function would work correctly for insertions however all the keys will
 * be in the same index which defeats the purpose of the hash table search time 
 * complexity of O(1) in this case it will have a time complexity of O(n)
 * 
 * C) This function would work for insertions however, it alters the key value 
 * randomly which will make searching for the actual key value nearly impossible. 
 * 
 * 
 * D) This function works for both insertions and searches. Key lookup would be fairly easy
 * because first you would just solve for k%n. Results in a  collision of <2 for all possible hashes.
 * 
 * 9.14)
 * 
 * 
 * 			0 Probability of 1/7
 * 			1 Probability of 1/7
 * 			2 --> 9 
 * 			3 --> 3
 * 			4 --> 2
 * 			5 --> 12 
 * 			6  probability of 5/7
 * 
 * 
 * 
 * 
 * 
 * 
 */

}
