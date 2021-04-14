

import java.util.Arrays;

public class P1 {

	public static void methodP1(int[] a) {
	
		for (int i =0 ; i<a.length/3 ; i++) {
			int temp=a[i];
			int numb_swap=a.length-((a.length/3)-i);		
			a[i]=a[numb_swap];
			a[numb_swap]=temp;
		}
		
		for(int j =a.length/3; j<=(a.length/3)+(a.length/3)/2; j++) {
			int temp=a[j];
			int swap_pos=(a.length-1)-j;
			a[j]=a[swap_pos];
			a[swap_pos]	=	temp;
					
		}
		
	}
	
	public static void main(String[] args) {

		int[] a = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120};
		System.out.println("Before: " + Arrays.toString(a));
		methodP1(a);
		System.out.println("After: " + Arrays.toString(a));

	}

}
