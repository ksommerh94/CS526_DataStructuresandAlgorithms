import java.util.Random;

public class SortingComparison {

	public static void printArray(int arr[]){
		// input: array
		// output: none
		// Method: prints all elements of the input array
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
 
        System.out.println();
    }
	
	// Taken from https://www.geeksforgeeks.org/insertion-sort/
	public static void insertionsort(int arr[]){
		// input: array with unsorted elements
		// output: none
		// Method: sort the array with the insertion method
       
		//get the element key 
		int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
 
        //Move elements of that are greater than key
        //to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
	
	// Taken from https://www.geeksforgeeks.org/merge-sort/
	public static void merge(int arr[], int l, int m, int r){
		// input: array, position from left in array, middle point and position to right in array
		// output: void none
		// Method: merge the sorted halves 
		
		// Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        //Create temp arrays, the left one and the right one
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        //Copy data to temps(L and R) arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        //Merge the temp arrays
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
       //Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
       //Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
	public static void mergesort(int arr[],int left, int right){
		// input: array, position from left in array and position to right in array
		// output: sorted elements 
		// Method: sort the array with the merge sort algorithm
		
		if (left < right) {
            // Find the middle point
            int m =left+ (right-left)/2;
 
            // Sort first and second halves
            mergesort(arr, left, m);
            mergesort(arr, m + 1, right);
 
            // Merge the sorted halves
            merge(arr, left, m, right);
        }
    }
	
	// Taken from https://www.geeksforgeeks.org/quick-sort/
	public static void swap(int[] arr, int i, int j){
		// input: array, index i and index j
		// output: none
		// Method: swap two elements
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
	public static int partition(int[] arr, int low, int high){
		// input: array, low is the starting index,  high the ending index 
		// output: partitioning index
		// Method: places the pivot element at its correct position and puts all smaller (smaller than pivot)
		// to left of pivot and all greater elements to right of pivot
		
	    // This function takes last element as pivot
	    int pivot = arr[high];
	     
	    // Index of smaller element and indicates the right position of pivot found so far
	    int i = (low - 1);
	 
	    for(int j = low; j <= high - 1; j++)
	    {
	         
	        // If current element is smaller than the pivot
	        if (arr[j] < pivot)
	        {
	             
	            // Increment index of smaller element
	            i++;
	            swap(arr, i, j);
	        }
	    }
	    swap(arr, i + 1, high);
	    return (i + 1);
	}
	public static void quicksort(int[] arr, int low, int high){
		// input: array, low is the starting index,  high the ending index 
		// output: void
		// Method: sort the array with the quick sort algorithm
		
	   
		if (low < high) {      
	        // pi is partitioning index, arr[p] is now at right place
	    	int pi = partition(arr, low, high);
	 
	        // Separately sort elements before
	        // partition and after partition
	        quicksort(arr, low, pi - 1);
	        quicksort(arr, pi + 1, high);
	    }
	}

	// Taken from https://www.geeksforgeeks.org/heap-sort/
	public void heapsort(int arr[]){
		// input: array with integer elements
		// output: none
		// Method: sort the array with the heap sort algorithm
		
        int n = arr.length;
 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
	public void heapify(int arr[], int n, int i){
		// input: array,  n = node,  i = root
		// output: void
		// method: To heapify a subtree rooted with node i which is an index in arr[]. n is size of heap
       
		// Initialize largest as root
		int largest = i; 
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
	
	//------------------------------------------------
	public static void sorting(int value) {
		Random r = new Random(System.currentTimeMillis() );
		int[] insertKeys = new int[value];
		int N1=1000000;
		for (int i = 0; i<value; i++) {
			insertKeys[i] = r.nextInt(N1) + 1;
		}
		
		//INSERT
		int[] insertionArray = insertKeys.clone();
		long endTime_insertion=0;
		long elapsedTime_insertion=0;
		long startTime_insertion = System.currentTimeMillis();
		insertionsort(insertionArray);
		endTime_insertion = System.currentTimeMillis();
		elapsedTime_insertion = endTime_insertion - startTime_insertion;
		System.out.println("Insertion sort of array size: "+ insertionArray.length +" was "+elapsedTime_insertion);
		//printArray(insertionArray);
		
		//MERGE
		int[] mergeArray = insertKeys.clone();
		long endTime_merge=0;
		long elapsedTime_merge=0;
		long startTime_merge = System.currentTimeMillis();
		mergesort(mergeArray,0,mergeArray.length-1);
		endTime_merge = System.currentTimeMillis();
		elapsedTime_merge = endTime_merge - startTime_merge;
		System.out.println("Merge sort of array size: "+ mergeArray.length +" was "+elapsedTime_merge);
		//printArray(mergeArray);
		
		//QUICK
		int[] quickArray = insertKeys.clone();
		long endTime_quick=0;
		long elapsedTime_quick=0;
		long startTime_quick = System.currentTimeMillis();
		quicksort(quickArray,0,quickArray.length-1);
		endTime_quick = System.currentTimeMillis();
		elapsedTime_quick = endTime_quick - startTime_quick;
		System.out.println("Quick sort of array size: "+ quickArray.length +" was "+elapsedTime_quick);
		//printArray(quickArray);
		
		//HEAP
		int[] heapArray = insertKeys.clone();
		long endTime_heap=0;
		long elapsedTime_heap=0;
		long startTime_heap = System.currentTimeMillis();
		quicksort(heapArray,0,heapArray.length-1);
		endTime_heap = System.currentTimeMillis();
		elapsedTime_heap = endTime_heap - startTime_heap;
		System.out.println("Heap sort of array size: "+ heapArray.length +" was "+elapsedTime_heap);
		//printArray(heapArray);
	
	
	
	
	
	}
	
	
	
	public static void main(String[] args) {
		//random number for insertion
		
		//sorting(20);
		sorting(10000);
		sorting(20000);
		sorting(30000);
		sorting(40000);
		sorting(50000);
		sorting(60000);
		sorting(70000);
		sorting(80000);
		sorting(90000);
		sorting(100000);
		//10000
		
			
		
	}

}