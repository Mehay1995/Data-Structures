
public class BookSolutions {
/*
A) To find the minimum value of the list, It is best to sort the list, the minumum value would be at 
the index of 1 in a sorted array array[0]. it would be constant time

B) To find the maximum value of the list, it is best to sort the list, the maximum value would be the last index of the sorted
array. array[array.length -1] it would be constant time

C) To compute arithmetic mean it is not necessary to sort the list. The only thing 
you need to compute the arithmetic mean is the number of items in the list, and the 
sum of all the items. The time complexity of computing the arithmetic mean will
also be N.

D) To find the median, the middle value, you must first sort the list in a sorted array
. The cost of the algorithm will not be affected whether the list is even or odd, if the list was
even you would have two add up the two middle values and divide by two. QuickSort
would be the best way to sort the list, with the time complexity of nLogn

E) You would first sort the list, using quicksort. which has a time complexity of 
nlogn. First you would compare the current element with the next element and if they are
equal you would increase the counter for that variable. You would have to store that information
until you come across a variable with a higher count. You would need a total of 5 variables. 
With comparisons become constant, and setting values being constant, the time complexity would 
nlogn + n which would just become n. 


*/
}
