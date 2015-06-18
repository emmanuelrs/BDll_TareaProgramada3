package controlador;
import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;
import java.util.LinkedList;

public class oracleConn {
    static String jdbcUrl = "jdbc:oracle:thin:@localhost:1521/GestorEmpresa";
    static String userid = "GestorEmpresarial";
    static String password = "gestorE"; 
    static Connection conn;
    static Object dataSource;
    
public void oracleConn() throws SQLException{
        OracleDataSource ds;
        ds = new OracleDataSource();
        ds.setURL(jdbcUrl);
        conn=ds.getConnection(userid,password);
        conn.close();
    }

public void insertarProducto(String producto,String descripcion,String precio,String marca,String categoria,String cantidad,String minimo, String NOMBRE_BODEGA) throws SQLException{
    int precio1 = Integer.parseInt(precio);
    int cantidad1 = Integer.parseInt(cantidad);
    int minimo1 = Integer.parseInt(minimo);
    OracleDataSource ds;
    ds = new OracleDataSource();
    ds.setURL("jdbc:oracle:thin:@localhost:1521/GestorEmpresa");
    conn=ds.getConnection("GestorEmpresarial","gestorE");
    CallableStatement cs;
   //conn = dataSource.getConnection();
    
    cs = conn.prepareCall("{ CALL insertarProducto(?,?,?,?,?,?,?,?) }");
    //populate stored proc parameters
    cs.setString(1, producto);
    cs.setString(2, descripcion);
    cs.setInt(3, precio1);
    cs.setString(4, marca);
    cs.setString(5, categoria);
    cs.setInt(6, cantidad1);
    cs.setInt(7, minimo1);
    cs.setString(8, NOMBRE_BODEGA);
    //cs.registerOutParameter(3, Types.NUMERIC); 
    //execute stored procedure
    cs.execute();
    cs.close();
    conn.close();
    
    
}

public void crearBodega(String pNombreB, String pPais, String pProvincia,
        String pCanton, String pDireccion, String pNumero) throws SQLException{
    
    OracleDataSource ds;
    ds = new OracleDataSource();
    ds.setURL("jdbc:oracle:thin:@localhost:1521/GestorEmpresa");
    conn = ds.getConnection("GestorEmpresarial","gestorE");
    CallableStatement cs;
   
    cs = conn.prepareCall("{ CALL insertarBodega(?,?,?,?,?,?) }");
    //populate stored proc parameters
    cs.setString(1, pNombreB);
    cs.setString(2, pPais);
    cs.setString(3, pProvincia);
    cs.setString(4, pCanton);
    cs.setString(5, pDireccion);
    cs.setString(6,pNumero);
   
    
    //cs.registerOutParameter(3, Types.NUMERIC); 
    //execute stored procedure
    cs.execute();
    cs.close();
    conn.close();
    
}
public Connection ejecutarSQL() throws SQLException{
    OracleDataSource ds;
            ds = new OracleDataSource();
            ds.setURL(jdbcUrl);
            conn=ds.getConnection(userid,password);
            return conn;
}

    public static LinkedList<inventario> getInventario(){
        LinkedList<inventario> listaInv =new LinkedList<inventario>();
        try{
            inventario Inv = new inventario();
            OracleDataSource ds;
            ds = new OracleDataSource();
            ds.setURL(jdbcUrl);
            conn=ds.getConnection(userid,password);
            String sql = "select p.id_producto, p.producto, p.descripcion, p.preciounitario, m.marca, ca.categoria, p.cantidad, p.minimo from producto p, marca m, categoria ca" ;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                
                Inv.setId(rs.getNString("ID_PRODUCTO"));
                Inv.setProducto(rs.getNString("PRODUCTO"));
                Inv.setDescripcion(rs.getNString("DESCRIPCION"));
                Inv.setPrecio(rs.getNString("PRECIOUNITARIO"));
                Inv.setMarca(rs.getNString("MARCA"));
                Inv.setCategoria(rs.getNString("CATEGORIA"));
                Inv.setCantidad(rs.getNString("CANTIDAD"));
                Inv.setMinimo(rs.getNString("MINIMO"));
                listaInv.add(Inv);
            }
            rs.close();
            conn.close();
        }
        catch (Exception e)
        {
         e.printStackTrace();
        }
      return listaInv;
    }
    
    public static LinkedList<bodega> getBodega(){
        LinkedList<bodega> listaBodega = new LinkedList<bodega>();
        try{
            OracleDataSource ds;
            ds = new OracleDataSource();
            ds.setURL(jdbcUrl);
            conn=ds.getConnection(userid,password);
            String sql = "select b.id_bodega, b.nombrebodega, d.pais, d.provincia, d.canton, d.direccion_exacta, t.numtelefono from bodega b, direccion d, telefono t where b.id_direccion = d.id_direccion and b.id_telefono = t.id_telefono" ;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                bodega bod = new bodega();
                bod.setId(rs.getNString("ID_BODEGA"));
                bod.setNombre(rs.getNString("NOMBREBODEGA"));
                bod.setPais(rs.getNString("PAIS"));
                bod.setProvincia(rs.getNString("PROVINCIA"));
                bod.setCanton(rs.getNString("CANTON"));
                bod.setDireccion(rs.getNString("DIRECCION_EXACTA"));
                bod.setTelefono(rs.getNString("NUMTELEFONO"));
                listaBodega.add(bod);
            }
            rs.close();
            conn.close();
        }
        catch (Exception e)
        {
         e.printStackTrace();
        }
      return listaBodega;
    }
}