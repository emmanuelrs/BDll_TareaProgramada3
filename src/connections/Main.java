package connections;

import java.sql.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;
 

public class Main {

	public static void main(String[] args){
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/GestorEmpresa","GestorEmpresarial","gestorE");//"GestorEmpresarial","gestorE");
			Statement st = con.createStatement();
			String sql = "select * from address";
			ResultSet rs = st.executeQuery(sql); 
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+ rs.getString(2)); 
				con.close();
			}
		}
		
		catch(Exception e){
			System.out.println(e);
		} 
	}
}
