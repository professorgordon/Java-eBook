/*
 * LinearSearchAccountsTime.java - Example of linear search based on 
 * 								accounts data file with time metrics.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedsearching.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LinearSearchAccountsTime 
{

	public static void main(String[] args) throws IOException 
	{
	    int searchValue = 735040;
	
	
		File csvFile = new File("AccountNumbers.csv"); 
		
		if (csvFile.exists()) 
		{

        	// Get number of rows in the file
        	int numAccounts = countRows(csvFile);
        	if (numAccounts > 0)
        	{
        		// Declare & initialize array 
        		int dataArray[] = new int[numAccounts];
        		// Load the array from the file
        		loadArray(dataArray, csvFile);
        		// Search array for search value
    			int result = linearSearch(dataArray, searchValue);
    			// Display search result
    			if (result > -1)
    			{
    				System.out.printf("%nThe value %d was found at index %d.%n", 
    						searchValue, result);
    			}
    			else
    			{
    			  System.out.printf("%nThe value %d was not found in the array.%n",
    					  searchValue);
    			}
        	
        	}
		}
	}
    
	
  private static void loadArray(int[] dataArray, File dataFile) throws IOException 
  {
    String line = "";
    int i = 0;
    try (BufferedReader br = new BufferedReader(new FileReader(dataFile)))
	{
    	int nanoDivisor = 1000000000;
    	long startTime = System.nanoTime();
	    while ((line = br.readLine()) != null)
	    {
	    	dataArray[i] = Integer.parseInt(line);
	    	i++;
	    }
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		double seconds = (double)duration/nanoDivisor;
		System.out.printf("loadArray() Duration: %,d nanoseconds [%.10f seconds]%n", duration, seconds);
	    br.close();
	}
  }

  private static int countRows(File dataFile) throws FileNotFoundException, IOException 
  {
	  int rowCount = 0;
	  try (BufferedReader br = new BufferedReader(new FileReader(dataFile)))
	  {
    	  int nanoDivisor = 1000000000;
	      long startTime = System.nanoTime();
		  while (br.readLine() != null) rowCount++;
		  long endTime = System.nanoTime();
		  long duration = endTime - startTime;
		  double seconds = (double)duration/nanoDivisor;
		  System.out.printf("countRows() Duration: %,d nanoseconds [%.10f seconds]%n", duration, seconds);
		  br.close();
	  }
	  catch (IOException e)
	  {
		  e.printStackTrace();
	  }
	  return rowCount;
  }

  static int linearSearch(int[] dataArray, int seekValue)
  {
	int nanoDivisor = 1000000000;
	int indexValue = -1;
    long startTime = System.nanoTime();
    for (int i = 0; i < dataArray.length; i++)
    {
      if (dataArray[i] == seekValue)
      {
        indexValue = i;
      }
    }
	long endTime = System.nanoTime();
	long duration = endTime - startTime;
	double seconds = (double)duration/nanoDivisor;
	System.out.printf("linearSearch() Duration: %,d nanoseconds [%.10f seconds]%n", duration, seconds);
    return indexValue;
  }

}    
