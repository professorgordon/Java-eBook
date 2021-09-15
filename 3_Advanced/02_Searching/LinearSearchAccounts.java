/*
 * LinearSearchAccounts.java - Example of linear search based on accounts data file.
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

public class LinearSearchAccounts 
{

	public static void main(String[] args) throws IOException 
	{
	    int searchValue = 665931;
	
	
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
    				System.out.println("The value " + searchValue + 
    						" was found at array index " + result);
    			}
    			else
    			{
    			  System.out.println("The value " + searchValue + 
    					  " was not found in the array.");
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
	    while ((line = br.readLine()) != null)
	    {
	    	dataArray[i] = Integer.parseInt(line);
	    	i++;
	    }
	    br.close();
	}
  }

  private static int countRows(File dataFile) throws FileNotFoundException, IOException 
  {
	  int rowCount = 0;
	  try (BufferedReader br = new BufferedReader(new FileReader(dataFile)))
	  {
		  while (br.readLine() != null) rowCount++;
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
    for (int i = 0; i < dataArray.length; i++)
    {
      if (dataArray[i] == seekValue)
      {
        return i;
      }
    }
    return -1;
  }

}    
