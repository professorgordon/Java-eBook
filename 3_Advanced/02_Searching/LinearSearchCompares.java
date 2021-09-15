/*
 * LinearSearchCompares.java - Example of compares metric.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedsearching.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 */


public class LinearSearchCompares
{
  public static void main(String[] args)
  {
    int searchValue = 61;
    int dataArray[] = {71, 14, 84, 23, 44, 61, 90, 53, 22, 75};
    int result = linearSearch(dataArray, searchValue);
    if (result > -1)
    {
      System.out.printf("The value %d was found at array index %d%n", searchValue, result);
    }
    else
    {
      System.out.printf("The value %d was not found in the array.", searchValue);
    }
  }

  static int linearSearch(int searchArray[], int seekValue)
  {
	  int compares = 0;
	  int indexLocation = -1;
	  for (int i = 0; i < searchArray.length; i++)
      {
          compares++;
          if (searchArray[i] == seekValue)
          {
        	  indexLocation = i;
        	  break;
          }
      }
	  System.out.printf("%nNumber of Compares: %,d%n%n", compares);
      return indexLocation;
  }
}