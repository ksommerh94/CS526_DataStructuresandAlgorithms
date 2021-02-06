
import java.io.IOException;
import java.io.*;
import java.io.BufferedReader;


public class Hw2_p1 {

	public static void findByMake(Car[] cars, String make) {
		// input: cars= array of cars make= String of manufacturer that is going to be found
		// output: print all cars that have the same manufacturer
		// Method: Search the manufacturer (make) and shows the car who has the same manufacturer as the one is looking
		boolean flag=false;
		for (Car c : cars) {
			if(c.getMake().equalsIgnoreCase(make)) {
				System.out.println(c.toString());
				flag=true;
			}
		}
		if(flag==false) {
			System.out.println("No cars with the manufacterer:" + make);
		}
	}
	
	public static void newerThan(Car[] cars, int year) {
		// input: cars= array of cars year= year to search
		// output: print all cars that have a newer year than the year in input
		// Method: Search the cars how have a newer year that the one entered
		boolean flag=false;
		for (Car c : cars) {
			if(c.getYear()>year) {
				System.out.println(c.toString());
				flag=true;
			}
		} 
		if(flag==false) {
			System.out.println("No cars with a newer year:" + year);
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		// complete this method
		Car [] carArray = null; 
		//Car myCar = new Car();
		BufferedReader br = null;
		  try {
			   String strCurrentLine;
			
			   br = new BufferedReader(new FileReader("car_input1.txt"));
			// read the first line from the input file
			// create an array of car Objects, carArray
			   carArray=new Car[Integer.parseInt(br.readLine())];
			   int i =0;
			   while ((strCurrentLine = br.readLine()) != null) {
				// read subsequent lines, create Car objects, and add them to carArray one at a time
					String[] parts = strCurrentLine.split(",");
					Car myCar = new Car();
					myCar.setMake(parts[0]);
					myCar.setPrice(Integer.parseInt(parts[1].replaceAll("\\s", "")));
					myCar.setYear(Integer.parseInt(parts[2].replaceAll("\\s", "")));
					carArray[i]=myCar;
					i+=1;
			   }
			   //Print all array of Cars
			   System.out.println("\nAll cars:");
				for (Car c : carArray) {
					System.out.println(c.toString());
				}
				
				String make = "Honda";
				int year = 2016;
				
				System.out.println("\nAll cars made by " + make);
				findByMake(carArray, make);
				System.out.println("\nAll cars made after " + year);
				newerThan(carArray, year);

				
			   
		  } catch (IOException e) {

			  System.out.println("No such file or directory");

			  }
	}
}