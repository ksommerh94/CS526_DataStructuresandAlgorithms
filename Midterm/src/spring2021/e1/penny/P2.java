package spring2021.e1.penny;

public class P2 {

	public static void main(String[] args) {
		P2LinkedList intList = new P2LinkedList();
		Integer[] a = {10, 20, 30, 40, 50};
		for (int i=0; i<a.length; i++) {
			intList.addLast(a[i]);
		}
		intList.printList();
		
		intList.methodP2(10);
		intList.printList();
		
		System.out.println("caca");		
		intList.methodP2(30);
		intList.printList();	
		
		intList.methodP2(50);
		intList.printList();
		
		intList.methodP2(100);
		intList.printList();
		
	}

}
