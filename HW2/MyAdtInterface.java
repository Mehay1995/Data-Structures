
public interface MyAdtInterface {
	
	void clear(); // sets all indexes in the array to 0 
	
	void replace(int x, int y, int num); // Given an array, you can replace any num at any index

	void initializeArray(int x, int y); // creates an array X*Y specified by the inputs
	
	

	void deleteArray(int x); // deletes a row out of the array, by inserting an int which corresponds to which row you want to delete
	
	
}
