/*
 * Bicycle.java - MountainBike child class example to demonstrate inheritance.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaintermediateinheritance.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 */
 
public class MountainBike extends Bicycle
{

	boolean frontShocks;
	boolean rearShocks;

	public MountainBike(String manufacturer, String model, String frame, 
						String material, String color, int gears,
						double mfgCost, double retail, int year, 
						boolean frontShocks, boolean rearShocks) {
		super(manufacturer, model, frame, material, color, gears, mfgCost, retail, year);
		this.frontShocks = frontShocks;
		this.rearShocks = rearShocks;
	}

	public boolean isFrontShocks() {
		return frontShocks;
	}

	public void setFrontShocks(boolean frontShocks) {
		this.frontShocks = frontShocks;
	}

	public boolean isRearShocks() {
		return rearShocks;
	}

	public void setRearShocks(boolean rearShocks) {
		this.rearShocks = rearShocks;
	}

	@Override
	public String toString() {
		return super.toString() + 
				"\tfrontShocks = " + (this.frontShocks ? "Yes" : "No") + 
				"\n\trearShocks = " + (this.rearShocks ? "Yes" : "No") + "\n";
	}

	
}
