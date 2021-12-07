import java.sql.*;

public class MySQLJavaExample1
{
  public static void main(String[] args)
  {
    String connectionString = "jdbc:mysql://127.0.0.1:3306/game_scores?serverTimezone=UTC";
    String dbLogin = "javauser";
    String dbPassword = "j4v4us3r?";
    Connection conn = null;
    // The sql variable has been added to store the SQL statement
    // that we will send to MySQL. This SQL statement asks MySQL
    // for all first names from the gamers table. By default, it
    // will return them in the order in which they are stored in
    // the table (not ordered, in other words).
    String sql = "SELECT first_name FROM gamers";
    // Here are a couple of variations you can try that sorts
    // our list of names ascending and descending
    //String sql = "SELECT first_name FROM gamers ORDER BY first_name";
    //String sql = "SELECT first_name FROM gamers ORDER BY first_name DESC";
    try
    {
      conn = DriverManager.getConnection(connectionString, dbLogin, dbPassword);
      if (conn != null)
      {
        // This nested try-catch structure was added which uses two
        // interfaces from the java.sql package: Statement, which
        // creates a statement object and a ResultSet object which
        // contains the results of the sql statement declared above,
        // and is executed in MySQL using the executeQuery method.
        try (Statement stmt = conn.createStatement();
       		ResultSet rs = stmt.executeQuery(sql))
        {
          // If the try is successful, then we should have a
          // result set (rs) and we can use a while look to
          // loop through the result set and print the
          // first names of the gamers. The next() method of
          // the rs object will return each row in the result
          // set until there are no more rows left.
          while (rs.next())
          {
            System.out.println(rs.getString("first_name"));
          }
        }
        // If the try fails then the catch will run, which in
        // this example it captures any exceptions thrown by
        // SQL and prints those exceptions.
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


