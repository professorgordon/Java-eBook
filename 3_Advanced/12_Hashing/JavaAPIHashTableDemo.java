/*
 * JavaAPIHashTableDemo.java - Class to demonstrate hash 
 * 								tables using the Java API.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedHashing.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 */

import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

public class JavaAPIHashTableDemo
{

	public static void main(String[] args)
	{
        Hashtable<Integer, String> ht1 = new Hashtable<>();
  
        ht1.put(1111, "Yates");
        ht1.put(2222, "Andrews");
        ht1.put(3333, "Barnes");
        ht1.put(4444, "Mathison");
        ht1.put(5555, "Jones");
        ht1.put(6666, "Carlson");
  
        System.out.println("Mappings of ht1 : " + ht1);
	
        System.out.println("\nEntry List:\n-------------");
        for (Entry<Integer, String> e : ht1.entrySet())
        {
            System.out.println(e.getKey() + " "
                    		+ e.getValue());
        }
	
	}

}
