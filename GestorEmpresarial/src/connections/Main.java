package connections;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	

	public static void main(String[] args) {
	
		
		// TODO Auto-generated method stub
		
		
		// Create a variable for the connection string.
	      String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
	         "databaseName=ROSALESE;user=emmanuelrosales;password=rosalese";

	      // Declare the JDBC objects.
	      Connection con = null;
	      Statement stmt = null;
	      ResultSet rs = null;

	      try {
	         // Establish the connection.
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         con = DriverManager.getConnection(connectionUrl);

	         // Create and execute an SQL statement that returns some data.
	         String SQL = "SELECT  * FROM DEPARTAMENTO";
	         stmt = con.createStatement();
	         rs = stmt.executeQuery(SQL);

	         // Iterate through the data in the result set and display it.
	         while (rs.next()) {
	            System.out.println(rs.getString(1) + " " + rs.getString(2));
	         }
	      }

	      // Handle any errors that may have occurred.
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      finally {
	         if (rs != null) try { rs.close(); } catch(Exception e) {}
	         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	         if (con != null) try { con.close(); } catch(Exception e) {}
	      }}}		
		
		/*try {
		oracleConn con = new oracleConn();
		con.getDBConnection();
		}
		catch(Exception e) {
			System.out.println(e);
		}
*/
