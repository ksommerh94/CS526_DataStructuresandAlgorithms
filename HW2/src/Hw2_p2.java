
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class Hw2_p2 extends MyLinkedList<Car> {

	public static void findByMake(MyLinkedList<Car> carList, String make) {
		// input: cars= array of cars make= String of manufacturer that is going to be found
		// output: print all cars that have the same manufacturer
		// Method: Search the manufacturer (make) and shows the car who has the same manufacturer as the one is looking
		
		//initialize the node with the first node
		Node<Car> myCarList = carList.head;
		//flag if there is any cars with the manufacturer name equals to make
		boolean flag=false;
		for (int i = 0; i < carList.size(); i++) {
			//check if make of the current node is equal to make
			if(myCarList.getElement().getMake().equalsIgnoreCase(make)) {
				flag=true;
				System.out.println(myCarList.getElement().toString());	
			}
			//update myCarList to the next node
			myCarList=myCarList.getNext();
		
		}
		if(flag==false) {
			System.out.println("No cars with the manufacterer:" + make);
		}
	}
	
	public static void newerThan(MyLinkedList<Car> carList, int year) {
		// input: cars= myArrayList of cars year= year to search
		// output: print all cars that have a newer year than the year in input
		// Method: Search the cars how have a newer year that the one entered
		
		//initialize the node with the first node
		Node<Car> myCarList = carList.head;
		//flag if there is any newer than year
		boolean flag=false;
		//loop until the size of the linked list
		for (int i = 0; i < carList.size(); i++) {
			//check if the year of the current node is bigger than year
			if(myCarList.getElement().getYear()>year) {
				flag=true;
				System.out.println(myCarList.getElement().toString());	
			}
			//update myCarList to the next node
			myCarList=myCarList.getNext();
		
		}
		if(flag==false) {
			System.out.println("No cars with a newer year:" + year);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		// complete this method
		MyLinkedList<Car> carList = new MyLinkedList<Car>();
		//Car myCar = new Car();
		BufferedReader br = null;
		  try {
			   String strCurrentLine;
			// read the first line from the input file
			   br = new BufferedReader(new FileReader("car_input2.txt"));
			// create an array of car Objects, carArray
			   while ((strCurrentLine = br.readLine()) != null) {
				// read subsequent lines, create Car objects, and add them to carArray one at a time
					String[] parts = strCurrentLine.split(",");
					Car myCar = new Car();
					myCar.setMake(parts[0]);
					myCar.setPrice(Integer.parseInt(parts[1].replaceAll("\\s", "")));
					myCar.setYear(Integer.parseInt(parts[2].replaceAll("\\s", "")));
					carList.addLast(myCar);

			   }
			   //Print all array of Cars
			   System.out.println("\nAll cars:");
			   //creates new node
			   Node<Car> myCarList = null;
			   for (int i = 0; i < carList.size(); i++) {
				   if(i==0) {
					   //print first node
					   System.out.println(carList.head.getElement().toString()); 
					   //gets first node, the HEAD, and save that to continue with the sequence of nodes
					   myCarList=carList.head.getNext();
				   }
				   else {
					   //print node
					   System.out.println(myCarList.getElement().toString());
					   //assign aux node to the next node
					   myCarList=myCarList.getNext();
				   } 
				}
				
				String make = "GM";
				int year = 2016;
				
				System.out.println("\nAll cars made by " + make);
				findByMake(carList, make);
				System.out.println("\nAll cars made after " + year);
				newerThan(carList, year);

				
			   
		  } catch (IOException e) {

			  System.out.println("No such file or directory");

			  }
	}
}