/*
 * Bicycle.java - Bicycle driver program example to demonstrate inheritance.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaintermediateinheritance.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 */
 
 public class BikesMain {

	public static void main(String[] args) {

		// First Bicycle instance
		Bicycle bike1 = new Bicycle("Trek", "Madone", "OCLV",
									"Carbon", "Black", 12, 
									5000.00, 12499.99, 2021);
		System.out.println(bike1.toString());

		// Second Bicycle instance
		Bicycle bike2 = new Bicycle("Trek", "Checkpoint", "SLR",
									"Carbon", "Yellow", 11, 
									2000.00, 8299.99, 2021);
		bike2.pedal(20);
		bike2.pedal(10);
		bike2.brake(3);
		System.out.println(bike2.toString());

		
		
        // First MountainBike instance
		MountainBike mtnBike1 = new MountainBike("Specialized", "Stumpjumper", "EVO",
											"Carbon", "Gunmetal", 18, 
											2350.00, 11000.00, 2021, 
											true, true);
		System.out.println(mtnBike1.toString());

		// Second MountainBike instance
		MountainBike mtnBike2 = new MountainBike("Cannondale", "Jekyll", "X2",
												"Carbon", "Green", 12, 
												1200.00, 6100.00, 2021, 
												true, false);
		mtnBike2.pedal(43);
		mtnBike2.brake(5);
		mtnBike2.pedal(13);
		System.out.println(mtnBike2.toString());

	}

}
