import java.sql.*;

public class MySQLJavaExample3
{
  public static void main(String[] args)
  {
    String connectionString = "jdbc:mysql://127.0.0.1:3306/game_scores?serverTimezone=UTC";
    String dbLogin = "javauser";
    String dbPassword = "j4v4us3r?";
    Connection conn = null;
    // In this example we have added additional fields (columns) to our
    // SQL query. In the previous examples we only included first_name.
    // Now we are asking the database to return 4 fields from the gamers
    // table. This creates a 2-dimensional object, with rows (the number
    // of gamers) and columns (the attributes gamer_id, first_name,
    // last_name and age). If we want to store the data from the result
    // set object in an array in Java, we'll need a 2-dimensional array
    // as demonstrated in the code below.
    String sql = "SELECT gamer_id, first_name, last_name, age FROM gamers";
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
          // We need to determine the number of rows and columns for
          // our 2-D array so we declare variables for that purpose.
          int numRows;
          int numCols = 4; // Number of attributes in SELECT statement
          rs.last();
          numRows = rs.getRow();
          System.out.printf("Number of Records: %d%n", numRows);
          rs.first();
          // We declare our 2-D array of the size of the number of
          // rows and columns as set above.
          String[][] dbResults = new String[numRows][numCols];;
          // We use a for loop to interate through the rows...
          for (int i = 0; i < numRows; i++)
          {
            // ... and in this example, rather than an inner nested
            // for loop, we use the indexing to set each of the 4
            // columns directly. This example demonstrates this
            // techniques because we often need to validate or
            // convert (cast) values from the result set to the
            // array, so this shows how you could do that.
            dbResults[i][0] = rs.getString("gamer_id");
            dbResults[i][1] = rs.getString("first_name");
            dbResults[i][2] = rs.getString("last_name");
            dbResults[i][3] = rs.getString("age");
            rs.next();
          }
          System.out.printf("Number of Array Rows: %d%n", dbResults.length);
          horizontalLine(100);
          // Now we'll generated a formatted list of the gamers and their ages
          System.out.println(" Gamer [Age]");
          horizontalLine(100);
          for (int i = 0; i < dbResults.length; i++)
          {
            // Again, rather than an inner loop we access each column
            // individually in case we decide to manipulate or format
            // each depending on their data type, values, etc.
            System.out.printf("%s: %s %s [%s]%n",
            dbResults[i][0],
            dbResults[i][1],
            dbResults[i][2],
            dbResults[i][3]);
          }
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