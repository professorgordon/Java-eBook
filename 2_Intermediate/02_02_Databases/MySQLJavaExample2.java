import java.sql.*;

public class MySQLJavaExample2
{
  public static void main(String[] args)
  {
    String connectionString = "jdbc:mysql://127.0.0.1:3306/game_scores?serverTimezone=UTC";
    String dbLogin = "javauser";
    String dbPassword = "j4v4us3r?";
    Connection conn = null;
    // This is the same SQL statement as we used in TestDB2.java.
    String sql = "SELECT first_name FROM gamers";
    try
    {
      conn = DriverManager.getConnection(connectionString, dbLogin, dbPassword);
      if (conn != null)
      {
      // Note that, compared to TestDB2.java, we've added two parameters
      // to the createStatement() method call. These parameters are used
      // to allow us to read the result set both forward and backward,
      // which we do inside the try section as you will see.
      try (Statement stmt = conn.createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
                            ResultSet rs = stmt.executeQuery(sql))
      {
        // In this example we'll be loading a simple Java array with the
        // values in the result set object. Since it's the simple array,
        // we need to set the size of the array up front. To do this,
        // we need to know how many records are in the result set. One
        // way to do this is to move to the end of the result set, capture
        // the the number of the last element and use that to size our
        // array (in this example we use a variable called numRows).
        int numRows;
        rs.last();
        numRows = rs.getRow();
        System.out.printf("Number of Records: %d%n", numRows);
        rs.first();	// reset the result set pointer
        // We declare our array here, with numRows as the size.
        String[] dbResults = new String[numRows];;
        // Now we can use a for loop to loop through the result set object
        // and populate our array with the values in the result set.
        for (int i = 0; i < numRows; i++)
        {
          dbResults[i] = rs.getString("first_name");
          rs.next();	// Moves the result set object pointer to the next record
        }
        System.out.printf("Number of Array Rows: %d%n", dbResults.length);
        // And now we can work with the array as usual, access the records,
        // print them, do calculations, etc.
        for (int j = 0; j < dbResults.length; j++)
        {
          System.out.printf("Gamer %d: %s%n", j + 1, dbResults[j]);
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
}

