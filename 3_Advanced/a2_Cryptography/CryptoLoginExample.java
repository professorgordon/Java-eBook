/*
 * CryptoLoginExample.java - Demonstrates the use of using
 * 				encryption in a login process.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedcryptography.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 * 
 */

import java.util.Scanner;
import java.sql.*;

public class CryptoLoginExample
{

	public static void main(String[] args) throws Exception
	{
		Scanner input = new Scanner(System.in);
		String login = "";
		String password = "";
		int attempts = 1;
		boolean authenticated = false;
		do
		{
			printHeader();
			System.out.print("Login: ");
			login = input.nextLine();
			/*
			 * Prompting for a password in plain text here for demo purposes
			 * only. In an actual application we would want to use a technique
			 * for hiding the user's entry of the passwords In a console 
			 * application this could be accomplished using the java.io.Console
			 * library's readPassword() method. Or in GUI applications we could 
			 * use the Swing JPasswordField component. 
			 */
			System.out.print("Password: ");
			password = input.nextLine();
			attempts++;
			if (attempts < 4)
			{
				authenticated = authenticateUser(login, password);
				if (authenticated)
				{
					System.out.println("\nUser authenticated successfully.");
					break;
				}
				else
				{
					System.out.println("\nLogin failed.");
				}
			}
			else
			{
				System.out.println("\nMaximum login attempts exceeded.");
				break;
			}
		} while (true);
		input.close();
	}

	private static boolean authenticateUser(String login, String password) throws Exception
	{
    	/*
    	 * This class is set up to accept a user-entered logina and password, connect
    	 * to a database to try to authenticate the user based on the entered credentials.
    	 * As written, this method only returns a true or false indicating whether the 
    	 * authentication succeeded or failed. A better implementation would be to return
    	 * the user ID so that the calling method could use it for subsequent purposes. 
    	 * 
    	 * 
    	 * Instantiate the Crypto() class for use with our login demonstration.
    	 */
		Crypto crypt = new Crypto();
    	/*
    	 * The database used for this demonstration is a locally installed instance of MySQL. 
    	 */
		String connectionString = "jdbc:mysql://127.0.0.1:3306/demodatabase?serverTimezone=UTC";
		/*
		 * The dbLogin is pre-established in the database engine with access rights set for 
		 * the demodatabase called out in the above connection string.
		 */
        String dbLogin = "javademouser";
        /*
         * The dbPassword is pre-established in the database engine encrypted using the
         * same Crypto() class used here. In a production system, the encrypted password
         * would not be hardcoded as shown here. It is hardcoded her to demonstrate how 
         * this process works.
         */
        String dbPassword = "giZ8m92EvhozC/ma54SzkunZJ3FuNf3N";
        Connection conn = null;
        try 
        {
            conn = DriverManager.getConnection(connectionString, dbLogin, dbPassword);
            if (conn != null) 
            {
            	String sql = "SELECT user_id, first_name, last_name "
            			+ "FROM users WHERE login = '" + login 
            			+ "' AND password = '" 
            			+ crypt.encrypt(password) + "'";
            	//System.out.println(sql);
			    try (Statement stmt = conn.createStatement();
	        		    ResultSet rs = stmt.executeQuery(sql)) 
       		    {
					while (rs.next()) 
         			{
         			   System.out.println("\nUser ID: " + rs.getString("user_id") 
         					   			+ "\nFirst Name: " + rs.getString("first_name")
         					   			+ "\nLast Name: " + rs.getString("last_name"));
         			   return true;
         			}
	         	}
			    catch (SQLException e)
			    {
			    	System.out.println(e.getMessage());
			    	return false;
			    }
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }
		return false;
	}

	private static void printHeader()
	{
		System.out.println();
		printDashedLine(40);
		System.out.println("S y s t e m   L o g i n");
		printDashedLine(40);
	}

	private static void printDashedLine(int n)
	{
		for(int i = 1; i <= n; i++)
		{
			System.out.print("-");
		}
		System.out.println();
	}
}

