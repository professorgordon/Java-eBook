import java.sql.*;

public class MySQLJavaExample4
{
    public static void main(String[] args)
    {
        String connectionString = "jdbc:mysql://127.0.0.1:3306/game_scores?serverTimezone=UTC";
        String dbLogin = "javauser";
        String dbPassword = "j4v4us3r?";
        Connection conn = null;
        // In this example we have expanded our SQL query to be more complicated
        // in terms of the query itself, however for our purposes in Java, we
        // just need to recognize what the result set will look like. In this
        // example, the result set will be 2-dimensional, like the previous
        // example so our approach to processing the result set data will be
        // similar. In this example our column count will be 13 because we are
        // asking for 13 attriutes from the database.
        String sql = "SELECT g.gamer_id, g.first_name, g.age, s.game1, "
	 	    + "s.game2, s.game3, s.game4, s.game5, s.game6, s.game7, "
		    + "s.game8, s.game9, s.game10 FROM gamers g LEFT JOIN "
		    + "scores s ON g.gamer_id = s.gamer_id";
        try
        {
	    conn = DriverManager.getConnection(connectionString, dbLogin, dbPassword);
  	    if (conn != null)
	    {
		try (Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
	        		ResultSet rs = stmt.executeQuery(sql))
         	{
		    // Like the previous example, we need to determine the number
		    // rows. We set the number of columns manually because we
		    // already know how many there will be because of our SQL
		    // statement above.
		    int numRows;
		    int numCols = 13;  // Number of attributes in SELECT statement
		    rs.last();
		    numRows = rs.getRow();
		    System.out.printf("Number of Records: %d%n", numRows);
		    rs.first();
		    String[][] dbResults = new String[numRows][numCols];;
		    // This example is a database version of our previous assignment
	            // where we read gamer scores from a .csv file. The data that
		    // we are working with is the same data as we found in that .csv
		    // file. So, we can create a report like we did in the previous
		    // assignment. We need variables to store gamer totals and top
		    // gamer values to determine the summary footer indicator as to
		    // who is the top gamer in the data.
		    int gamerTotal = 0;
		    int topGamer = 0;
		    String topName = "";
		    // Like the previous example, we use a for loop to interate
		    // through the rows...
		    for (int i = 0; i < numRows; i++)
		    {
		        // ... and in this example also, rather than an inner nested
		        // for loop, we use the indexing to set each of the 4
		        // columns directly. This example demonstrates this
		        // techniques because we often need to validate or
		        // convert (cast) values from the result set to the
		        // array, so this shows how you could do that.
		        dbResults[i][0] = rs.getString("gamer_id");
		        dbResults[i][1] = rs.getString("first_name");
	                dbResults[i][2] = rs.getString("age");
		        dbResults[i][3] = rs.getString("game1");
		        dbResults[i][4] = rs.getString("game2");
		        dbResults[i][5] = rs.getString("game3");
		        dbResults[i][6] = rs.getString("game4");
		        dbResults[i][7] = rs.getString("game5");
		        dbResults[i][8] = rs.getString("game6");
		        dbResults[i][9] = rs.getString("game7");
		        dbResults[i][10] = rs.getString("game8");
		        dbResults[i][11] = rs.getString("game9");
		        dbResults[i][12] = rs.getString("game10");
		        rs.next();
		    }
		    System.out.printf("Number of Array Rows: %d%n", dbResults.length);
		    horizontalLine(102);
		    // We print a header here
		    System.out.println("   Gamer [Age]\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\tTotal");
		    horizontalLine(102);
		    // In this loop we print the columns for each row (gamer) and format
		    // the output for our report. Notice the use of printf to aid in the
		    // formatting of the output line.
		    for (int i = 0; i < dbResults.length; i++)
		    {
		        System.out.printf("%s: %s [%s]\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",
		        dbResults[i][0],
		        dbResults[i][1],
		        dbResults[i][2],
		        dbResults[i][3],
		        dbResults[i][4],
		        dbResults[i][5],
		        dbResults[i][6],
		        dbResults[i][7],
		        dbResults[i][8],
		        dbResults[i][9],
		        dbResults[i][10],
		        dbResults[i][11],
		        dbResults[i][12]);
		        // Here we calculate the gamer total ...
		        gamerTotal = Integer.parseInt(dbResults[i][3]) +
		                     Integer.parseInt(dbResults[i][4]) +
		                     Integer.parseInt(dbResults[i][5]) +
		                     Integer.parseInt(dbResults[i][6]) +
		                     Integer.parseInt(dbResults[i][7]) +
		                     Integer.parseInt(dbResults[i][8]) +
		                     Integer.parseInt(dbResults[i][9]) +
		                     Integer.parseInt(dbResults[i][10]) +
		                     Integer.parseInt(dbResults[i][11]) +
		                     Integer.parseInt(dbResults[i][12]);
		        // ... and print it to the aggregated column ...
		        System.out.printf("\t%d%n", gamerTotal);
		        // ... and then compare the current gamer total
		        // to our topGamer so far and store it if the
		        // current gamer's total is larger.
		        if (gamerTotal > topGamer)
		        {
				topGamer = gamerTotal;
				topName = dbResults[i][1];
			}
			gamerTotal = 0;
		    }
		    horizontalLine(102);
		    // Lastly, we print the top gamer's name
		    System.out.printf("Top Gamer:\t%s%n", topName);
		    horizontalLine(102);
        	}
		catch (SQLException ex)
        	{
        	    System.out.println(ex.getMessage());
        	}
            }
	}
	catch (Exception e)
	{
	    System.out.println("Database connection failed.");
	    e.printStackTrace();
	}
    }

    private static void horizontalLine(int dashes)
    {
        for (int i = 1; i <= dashes; i++)
        {
	    System.out.print("-");
        }
        System.out.println();
    }
}