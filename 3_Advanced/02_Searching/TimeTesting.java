/*
 * TimeTesting.java - Example of using nanoTime().
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedsearching.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 */

public class TimeTesting 
{
	public static void main(String[] args) 
	{
		int numIterations = 1000;
		int nanoDivisor = 1000000000;
		long total = 0;
		long start = System.nanoTime();
		for(int i = 0; i < numIterations; i++)
		{
		  total = total + i;
		}
		long end = System.nanoTime();
		long duration = end - start;
		double seconds = (double)duration/nanoDivisor;
		System.out.printf("Iterations: %,d%n", numIterations);
		System.out.printf("  Duration: %,d nanoseconds [%.10f seconds]%n", duration, seconds);
		System.out.printf("     Total: %,d%n", total);
	}
}
