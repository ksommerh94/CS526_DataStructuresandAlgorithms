package MyPrograms;
import Car;

public class TestCar {

	public static void main(String[] args) {
		Car c1 = new Car("ABCD", "GM");
		Car c2 = new Car("WXYZ", "Ford");

		System.out.println("Car c1 is: \n" + c1);
		System.out.println("Car c2 is: \n" + c2);

		c1.setVIN("A123");
		c1.setMake("VoklsWagen");

		System.out.println("\nCar c1, after update,  is: \n" + c1);

		Car c3 = new Car();
		c3.setVIN("B123");
		c3.setMake("Honda");

		System.out.println();
		System.out.println("VIN of car c3 is: " + c3.getVIN());
		System.out.println("Make of car c3 is: " + c3.getMake());

		System.out.println();
		System.out.println("Number of cars, with static method, is: " + Car.getNumberOfCars());

		Car c4, c5, c6;
		Car carArray[] = new Car[3];

		c4 = new Car();
		c4.setVIN("1234");
		c4.setMake("Hyundai");
		carArray[0] = c4;

		c5 = new Car();
		c5.setVIN("2345");
		c5.setMake("Kia");
		carArray[1] = c5;

		c6 = new Car();
		c6.setVIN("3456");
		c6.setMake("Chevy");
		carArray[2] = c6;

		int i;

		System.out.println("\n\nCar array  ");
		for (i=0; i<carArray.length; i++) {
			System.out.println(carArray[i] + "\n");
		}

		System.out.println();
		System.out.println("Number of cars, with static method, is: " + Car.getNumberOfCars());

	}


}
