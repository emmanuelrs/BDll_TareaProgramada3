package connections;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SQLServerConn con = new SQLServerConn();
		con.SQLConnect();
		
		
		/*try {
		oracleConn con = new oracleConn();
		con.getDBConnection();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		 */
		
		
	}
}
	