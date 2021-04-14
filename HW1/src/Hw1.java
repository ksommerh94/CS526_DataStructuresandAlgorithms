import java.util.Arrays;


public class Hw1 {
	
	public static void find(int[] a, int x) {
		// input: a= array of integers x= integer to be found
		// output: print index of the array where x is stored , if x is not, print "x does not exist"
		// Method: Linear search if x is in a array

		
		boolean flag=false;
		for(int i=0;i<a.length;i++) {
			if(a[i]==x){
				System.out.println(x+ " is in a["+i+"]");
				flag=true;
			}
		}
		if (flag==false){
			System.out.println(x+" does not exist");
		}		
	}
	
	public static int[] subarray(int[] a, int low, int high) {
		// input: a= array of integers low= integer lower bound high= integer upper bound
		// output: subarrary from index low to index high
		// Method: Creates and return a subarray from index low to index high

		int[] returnsubarray = new int[high-low+1];
		int x=0;
		for (int i=low;i<=high;i++) {
			returnsubarray[x]=a[i];
			x++;
		}
		
		return(returnsubarray);

		
	}
	
	public static boolean isPrefix(String s1, String s2) {
		// input: s1= string 1 s2= string 2
		// output: return true if s1 is a prefix of s2 else return false
		// Method: Check if s1 is a prefix of s2
		//Assumptions: length of s1 <= length of s2
		char[] ss1 = s1.toCharArray();
		char[] ss2 = s2.toCharArray();
		for (int i=0;i<ss1.length;i++) {
			if(ss1[i]!=ss2[i]) {
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		
		int[] a = {5, 3, 0, 6, 1, 2, 12, -1, 6, 5};
		
		find(a, 5);
		find(a, 10);
		System.out.println();
		
		int low = 1;
		int high = 6;
		
		int[] subarray = new int[high-low+1];
		subarray = subarray(a, low, high);
		System.out.println("a[" + low + ".." + high +"] = " + Arrays.toString(subarray));
		System.out.println();
		
		String s1 = "abc";
		String s2 = "abcde";
		String s3 = "abdef";
		
		if (isPrefix(s1,s2)) {
			System.out.println(s1 + " is a prefix of " + s2);
		}
		else {
			System.out.println(s1 + " is not a prefix of " + s2);
		}
		
		if (isPrefix(s1,s3)) {
			System.out.println(s1 + " is a prefix of " + s3);
		}
		else {
			System.out.println(s1 + " is not a prefix of " + s3);
		}
		
	}

}