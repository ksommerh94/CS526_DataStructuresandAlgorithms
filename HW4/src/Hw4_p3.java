
import java.util.Arrays;

public class Hw4_p3 {
	

	
	public static  void reverseLastN(int[] a, int n) {
		//Method: Calls the reverse function
		//input: a --> array of integers  n --> integer position 
		//output: does not return anything , it changes directly the array
		 reverse(a,(a.length-n) , a.length -1);

	}
	
	public static void reverse(int[] a, int i, int j){
		//Method: reverse the last n numbers of the array
		//input: a --> array of integers  i --> index initial (goes left to right) j--> final index ( goes right to left)
		//output: does not return anything , it changes directly the array
		
	    if(i<j){//check that the indexes do not over pass each other
	    	//making the swap, between the indexes, j( goes right to left) , i (goes left to right)
	       int tmp = a[i]; 
	       a[i] = a[j];
	       a[j] = tmp;
	       reverse(a, ++i, --j); //Recursive call, pass the array , the incremented i and the decremented j
	    }
	}
	
	
	public static void rearrange(int[] a, int n) {
		//Method: reverse the last n numbers of the array
		//input: a --> array of integers  n --> guide number to the arrange
		//output: does not return anything is a void method, it changes calls the method rearragenArray

		rearragenArray(a,0 , a.length -1,n);
		
		
	}
	
	public static void rearragenArray(int[] a, int left, int right, int n){
		//Method: rearranges the integers in a in such a way that all integers smaller than x come before  those that are greater than or equal to x
		//input: a --> array of integers , left --> left index , right--> right index , n--> guide number to the arrange
		//output: does not return anything is a void method , it changes directly the array
		
		 int temp; // temporal variable for a future swap
		 if(left<=right) { // check that the indexes does not overlap each other
 	     if( a[left]>=n && a[right]<n){//if I can create the swap between the elements directly
            temp=a[left];
            a[left]=a[right];
            a[right]=temp;   
             rearragenArray(a, left+1, right-1,n); // if the swap was made, then I call the method but with bigger or smaller indexes to advance in the array
	        }
	        else{
	            if(a[right]>=n){ // check if the position (the most right one) is greater or equal than n
	                 rearragenArray(a, left, right-1,n);// Then I call the method but I move only one position to the from the left to star over and validate.
	            }
	            if(a[left]<n){ // Then I call the method but I move only one position to the from the right to star over and validate.
	                 rearragenArray(a, left+1, right,n);
	            }
	        } 
	    }
	}
	
	
	
	public static void main(String[] args) {
		int[] a = new int[10];
		
		// test reverseLastN method
		System.out.println("\nTest reverseLastN method");
		for (int i=0; i<a.length; i++) {
			a[i]= (i+1) * 10;
		}
		
		System.out.println("\nInitial array: ");
		System.out.println(Arrays.toString(a));
		
		// make a copy and use it for testing
		int[] intArrayCopy;
		intArrayCopy = a.clone();
		
		int N = 4;
		reverseLastN(intArrayCopy, N);
		System.out.println("\nAfter reversing last " + N + " elements: ");
		System.out.println(Arrays.toString(intArrayCopy));
		System.out.println();
		
		
		// test rearrange method
		System.out.println("\nTest rearrange method");
		int[] b = {31, 8, 23, 29, 12, 48, 36, 5, 39};
		//int[] b = {31, 60, 23, 29, 12, 48, 36, 5, 39};
		System.out.println("\nBefore rearrange: ");
		System.out.println(Arrays.toString(b));
		
		// make a copy and use it for testing
		intArrayCopy = b.clone();
		
		int x = 30;
		rearrange(intArrayCopy, x);
		System.out.println("\nAfter rearrange, with x = " + x);
		System.out.println(Arrays.toString(intArrayCopy));
		System.out.println();
	}

}