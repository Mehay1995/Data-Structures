import java.util.Arrays;

public class countingSort {

	
int findmax(int[] a){
	int max = a[0];
	for (int i = 0; i < a.length; i++){
		if(a[i] > max){
			max = a[i];
		}
	}
	return max;
}



	
public int[] countSort(int[] A) {
	int m = findmax(A);
	

	//#first, count the number of records with each key value, save to c
	int[] c = new int[m+1];
	for (int i = 0; i < A.length; i++)
	     c[A[i]]++;
	//#c: array of accumulated counts
	for (int i = 1; i <= m; i++)
	     c[i] += c[i-1];
	//#then, use the count information to place the items in order, saved to a new array
	int[] sorted = new int[A.length];
	for (int i = A.length-1; i >= 0; i--)
	     sorted[--c[A[i]]] = A[i];
	return sorted;
	
	/*
	 *  Counting sort is effective when the range of key values in the array are
	 *  close to the the number of records in the array
	 *  
	 *  If m < n the running time of the counting sort algorithm is theta(n);
	 * 
	 */
	
}

public static void main(String args[]){
	countingSort c = new countingSort();
	int[] a = {35,420,39,19,16,28,39,69,666,333,6969};
	
	System.out.println(Arrays.toString(c.countSort(a)));
	
	
	
}

}
