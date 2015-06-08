/**
 * 
 */
package connections;

import java.sql.Connection;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

/**
 * @author Emmanuel
 *
 */
public class Conex {

	/**
	 * 
	 */
	
	
	public static Connection con(){
		Connection con = null;
		try {
			SQLServerDataSource ds = new SQLServerDataSource();
			ds.setUser("Emmanuel-PC\\Emmanuel");
			ds.setPassword(null);
			ds.setServerName("localhost");
			ds.setPortNumber(1433);
			ds.setDatabaseName("ROSALESE");
			con = ds.getConnection();
		}
		catch(Exception e) {
			System.out.println("Error");
			
		}
		return con;
		
	}
	
	public Conex() {
		// TODO Auto-generated constructor stub
	}

}
