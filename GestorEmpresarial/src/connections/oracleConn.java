/**
 * 
 */
package connections;

/**
 * @author Emmanuel Rosales Salas
 *
 */
import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class oracleConn {
	
	String jdbcUrl = "jdbc:oracle:thin:@localhost:1521/GestorEmpresa";
    String userid = "GestorEmpresarial";
    String password = "gestorE"; 
    Connection conn;
    
public void getDBConnection() throws SQLException{
        OracleDataSource ds;
        ds = new OracleDataSource();
        ds.setURL(jdbcUrl);
        conn=ds.getConnection(userid,password);
        String sql = "select * from address" ;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next())
            System.out.println("results: " + rs.getString(1) +" " + rs.getString(2)+" " + rs.getString(3) );
        conn.close();
    }

}
