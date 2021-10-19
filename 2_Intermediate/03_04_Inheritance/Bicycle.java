/*
 * Bicycle.java - Bicycle parent class example to demonstrate inheritance.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaintermediateinheritance.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 */
 
public class Bicycle 
{
	String manufacturer = "";
	String model = "";
	String frame = "";
	String material = "";
	String color = "";
	int gears = 0;
	double mfgCost = 0;
	double retail = 0;
	int year = 0;
	int speed = 0;

	public Bicycle(String manufacturer, String model, 
				String frame, String material, 
				String color, int gears,
				double mfgCost, double retail, 
				int year) {
		super();
		this.manufacturer = manufacturer;
		this.model = model;
		this.frame = frame;
		this.material = material;
		this.color = color;
		this.gears = gears;
		this.mfgCost = mfgCost;
		this.retail = retail;
		this.year = year;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getFrame() {
		return frame;
	}

	public void setFrame(String frame) {
		this.frame = frame;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getGears() {
		return gears;
	}

	public void setGears(int gears) {
		this.gears = gears;
	}

	public double getMfgCost() {
		return mfgCost;
	}

	public void setMfgCost(float mfgCost) {
		this.mfgCost = mfgCost;
	}

	public double getRetail() {
		return retail;
	}

	public void setRetail(float retail) {
		this.retail = retail;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void pedal(int speed) {
		this.speed = this.speed + speed;
	}
	
	public void brake(int force) {
		if (this.speed - force < 0) {
			this.speed = 0;
		}
		else {
			this.speed = speed - force;
		}
	}
	
	@Override
	public String toString() {
		return "Bicycle: \n\tmanufacturer = " + manufacturer + 
				",\n\tmodel = " + model + ",\n\tframe = " + frame + 
				",\n\tmaterial = " + material + ",\n\tcolor = " + color + 
				",\n\tgears = " + gears + ",\n\tmfgCost = " + mfgCost + 
				",\n\tretail = " + retail +
				",\n\tyear = " + year + ",\n\tspeed = " + speed + "\n";
	}
}
