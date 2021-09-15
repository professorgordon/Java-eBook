/*
 * LinearSearchTime.java - Example of time metric in linear search.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedsearching.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 */

public class LinearSearchTime
{
  public static void main(String[] args)
  {
    int searchValue = 29;
    int dataArray[] = {23, 45, 51, 60, 12, 62, 64, 47, 92, 61,
                      37, 45, 17, 70, 85, 58, 84, 22, 59, 22,
                      62, 23, 21, 14, 94, 41, 70, 22, 58, 59,
                      10, 74, 46, 47, 16, 66, 93, 68, 42, 33,
                      54, 68, 35, 64, 50, 93, 34, 80, 44, 29};
	int nanoDivisor = 1000000000;
	long startTime = System.nanoTime();
	int result = linearSearch(dataArray, searchValue);
	long endTime = System.nanoTime();
	long duration = endTime - startTime;
	double seconds = (double)duration/nanoDivisor;
	System.out.printf("%nDuration: %,d nanoseconds [%.10f seconds]%n%n", duration, seconds);
    if (result > -1)
    {
      System.out.println("The value " + searchValue +
	          " was found at array index " + result);
    }
    else
    {
      System.out.println("The value " + searchValue +
	          " was not found in the array.");
    }
  }

  static int linearSearch(int searchArray[], int seekValue)
  {
	  for (int i = 0; i < searchArray.length; i++)
      {
          if (searchArray[i] == seekValue)
          {
              return i;
          }
      }
      return -1;
  }
}