import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Hw7_p4 {
	
	public static long insertmyMap (HashMap<Integer, Integer> myMap,int[] insertKeys) {
		//initialize time variables
		long endTime=0;
		long elapsedTime=0;
		long startTime = System.currentTimeMillis();
		
		// loop over the array and insert into map
		for (int i=0; i<insertKeys.length;i++) {
			myMap.put(insertKeys[i], i);
		}
		//capture final time of process and calculates delta with start
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		
		//return delta value
		return elapsedTime;
	}
	public static long insertmyArrayList (ArrayList<Integer> myArrayList,int[] insertKeys) {
		//initialize time variables
		long endTime=0;
		long elapsedTime=0;
		long startTime = System.currentTimeMillis();
		
		// loop over the array and insert into array list
		for (int i=0; i<insertKeys.length;i++) {
			myArrayList.add(insertKeys[i]);
		}
		
		//capture final time of process and calculates delta with start
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		
		//return delta value
		return elapsedTime;

	}
	public static long insertmyLinkedList (LinkedList<Integer> myLinkedList,int[] insertKeys) {
		//initialize time variables
		long endTime=0;
		long elapsedTime=0;
		long startTime = System.currentTimeMillis();
		
		// loop over the array and insert into linkedlist
		for (int i=0; i<insertKeys.length;i++) {
			myLinkedList.add(insertKeys[i]);
		}

		//capture final time of process and calculates delta with start
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		
		//return delta value
		return elapsedTime;
	}
	
	public static long searchmyMap (HashMap<Integer, Integer> myMap,int[] searchKeys) {
		//initialize time variables
		long endTime=0;
		long elapsedTime=0;
		long startTime = System.currentTimeMillis();
		
		// loop over the array and search value into map
		for (int i=0; i<searchKeys.length;i++) {
			myMap.containsKey(searchKeys[i]); 
		}

		//capture final time of process and calculates delta with start
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		
		//return delta value
		return elapsedTime;
	}
	public static long searchmyArrayList (ArrayList<Integer> myArrayList,int[] searchKeys) {
		//initialize time variables
		long endTime=0;
		long elapsedTime=0;
		long startTime = System.currentTimeMillis();
		
		// loop over the array and search value into arraylist
		for (int i=0; i<searchKeys.length;i++) {
			myArrayList.contains(searchKeys[i]);
		}

		//capture final time of process and calculates delta with start
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		
		//return delta value
		return elapsedTime;

	}
	public static long searchmyLinkedList (LinkedList<Integer> myLinkedList,int[] searchKeys) {
		//initialize time variables
		long endTime=0;
		long elapsedTime=0;
		long startTime = System.currentTimeMillis();
		
		// loop over the array and search value into linkedlist
		for (int i=0; i<searchKeys.length;i++) {
			myLinkedList.contains(searchKeys[i]);
		}

		//capture final time of process and calculates delta with start
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		
		//return delta value
		return elapsedTime;
	}

	
	
	public static void main(String[] args) {
		//Loop 10 times
		for (int j = 0; j<10; j++) {
			//creation of empty collections
			HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
			ArrayList<Integer> myArrayList = new ArrayList<Integer>();
			LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
			//random number for insertion
			Random r = new Random(System.currentTimeMillis() );
			int[] insertKeys = new int[1000000];
			int N1=1000000;
			for (int i = 0; i<1000000; i++) {
				insertKeys[i] = r.nextInt(N1) + 1;
			}
			//call insert functions for each type of collection
			long insertmyMap=insertmyMap(myMap,insertKeys);
			long insertmyArrayList=insertmyArrayList(myArrayList,insertKeys);
			long insertmyLinkedList=insertmyLinkedList(myLinkedList,insertKeys);
			//print information
			System.out.println("Number of keys = "+insertKeys.length);
			System.out.println("HashMap average insert time = " + insertmyMap);
			System.out.println("ArrayList average insert time = " + insertmyArrayList);
			System.out.println("LinkedList average insert time = " + insertmyLinkedList);
			
			//random number for search
			r.setSeed(System.currentTimeMillis());
			int[] searchKeys = new int[1000000];
			int N2=2000000;
			for (int i = 0; i<1000000; i++) {
				insertKeys[i] = r.nextInt(N2) + 1;
			}
			//call search functions for each type of collection
			long searchmyMap=searchmyMap(myMap,searchKeys);
			long searchmyArrayList=searchmyArrayList(myArrayList,searchKeys);
			long searchmyLinkedList=insertmyLinkedList(myLinkedList,searchKeys);
			//print information
			System.out.println("HashMap average search time = " + searchmyMap);
			System.out.println("ArrayList average search time = " + searchmyArrayList);
			System.out.println("LinkedList average search time = " + searchmyLinkedList);
			
			System.out.println(" ----- ");
		
		}
		
	}

}