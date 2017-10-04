
public class binarySearch{

	
	//return the position of an element (with value k) in sorted array 
	//if k is not in A, return A.length
  public int binary(Object[] A, Object key) {
	  Comparable val =(Comparable)key;
		int l = -1;
		int r = A.length; // l and r are beyond array bounds
		
		while (l+1 != r) { // Stop when l and r meet
			
			int i = (l+r)/2; // Check middle of remaining subarray
			Comparable element = (Comparable)A[i];
			if (element.compareTo(val) == 0) return i; // Found it
			else if (element.compareTo(key) == 1) r = i; // In left half
			else l = i; // In right half
		}
		return A.length; // Search value not in A
	}
	
	
	

public static void main(String args[]){
	Object a[] = {15,23,44,55,67,88,90,67};
	Object b[] = {'a', 'b', 'c', 'd', 'e'};
	binarySearch sort = new binarySearch();
	System.out.println(sort.binary(a, a[4]));
	System.out.println(sort.binary(b, 'e'));
