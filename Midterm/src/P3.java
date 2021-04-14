
import java.util.Arrays;

public class P3 {

	
	//Base on https://stackoverflow.com/questions/26112131/segregate-even-and-odd-numbers-in-an-integer-array-using-recursion
	// Modified by me
	
public static int[] rearragenArray(int[] a,int right) {
		int rightIndex = right;
	
	    if(right == 0) {
	        return a;
	    }
	    for(int i = rightIndex -1; i > 0; i--) {
	        if(a[rightIndex] % 2 == 1) {
	            if(a[i] % 2 == 0) {
	                int temp = a[rightIndex];
	                a[rightIndex] = a[i];
	                a[i] = temp;
	            }
	        }
	    }
	
	    return rearragenArray(a, rightIndex -1);
	}

	public static void methodP3(int[] a) {
		
		rearragenArray(a,a.length-1 );
	}
	
	public static void main(String[] args) {

		int[] a = {11, 18, 27, 40, 51, 60, 70};
		System.out.println("Before: " + Arrays.toString(a));
		methodP3(a);
		System.out.println("After: " + Arrays.toString(a));

	}

}
