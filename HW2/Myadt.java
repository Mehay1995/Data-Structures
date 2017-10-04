import java.util.*;
public class Myadt implements MyAdtInterface {
	int x;
	int y; 
	static int[][] myArray; 
	 
	Random rnd = new Random(); 

	public static void main(String[] args) {
		Myadt a = new Myadt(); 
		a.initializeArray(5,5);
		System.out.println(Arrays.deepToString(myArray));
		a.replace(1, 2, 3);
		System.out.println(Arrays.deepToString(myArray));
		a.clear();
		System.out.println(Arrays.deepToString(myArray));
		a.deleteArray(0);
		System.out.println(Arrays.deepToString(myArray));

	}


	public void clear() {
		int[][] value = new int[x][y]; 
		myArray = value; 
		
	}

	
	public void replace(int x, int y, int num) {
		
		myArray[x][y]= num; 
		
		
	}

	
	public void initializeArray(int xs, int ys) {
	    myArray = new int[xs][ys]; 
		 x = xs;
	     y = ys; 	
		
	}


	public void deleteArray(int n) {
		int[][] old = new int[x-1][y]; 
		for (int i = 0; i < n-1; i++)
			if(i < n) {
				old[i] = myArray[i]; }
				else {
					old[i] = myArray[i + 1];
				}
				x -= 1;
				myArray = old;
				
			}
				
			
		
	}
	
	


