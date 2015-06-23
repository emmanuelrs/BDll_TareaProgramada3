/*
Elaborado por: Emmanuel Rosales Salas, Luis Serrano y Cristiam Flores Nuñez
Bases de Datos 2.
*/

//Imports necerios para la clase
package controlador;
import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;
import java.util.LinkedList;
//En esta clase se encuentran todos los métodos/funciones de la aplicación
//desde aquí se hace las consultas a la base de datos realizando procesos o
//obteniendo información de funciones que posteriormente son utilizadas 
//en las diferentes secciónes de la aplicación.

public class oracleConn {
        
    //Define los atributos que tienen la información correspondiente
    //para la conexión con la base de datos Oracle 12c.
    static String jdbcUrl = "jdbc:oracle:thin:@localhost:1521/GestorEmpresa";
    static String userid = "GestorEmpresarial";
    static String password = "gestorE"; 
    static Connection conn;
    static Object dataSource;
    
public void oracleConn() throws SQLException{
            //Utiliza los atributos definidos anteriormente y realiza la conexión
        OracleDataSource ds;
        ds = new OracleDataSource();
        ds.setURL(jdbcUrl);
        conn=ds.getConnection(userid,password);
        conn.close();
    }

public void agregarPivot(Integer IdProduct,Integer cantidad) throws SQLException{
        /*Este método realiza inserts a la tabla pivot, la cual guarda los productos
    que son comprados por un usuario, es decir, va insertnado uno a uno cada 
    producto que es elegido por un usuario, una vez que finalice su compra, esta
    información se utiliza para crear la factura correspondiente a la compra
    */
    OracleDataSource ds;
    ds = new OracleDataSource();
    ds.setURL(jdbcUrl);
    conn=ds.getConnection(userid,password);
    CallableStatement cs;
    cs = conn.prepareCall("{ CALL insertarPivot(?,?)}");
    //populate stored proc parameters
    cs.setInt(1, IdProduct);
    cs.setInt(2, cantidad);
    //execute stored procedure
    cs.execute();
    cs.close();
    conn.close(); 
}

    public void resetPivot(){
                //Una vez que la compra es realizada y la factura se crea, se utiliza
        //este método para limpiar esta tabla y este lista para la siguiente compra
        try{
            OracleDataSource ds;
            ds = new OracleDataSource();
            ds.setURL(jdbcUrl);
            conn=ds.getConnection(userid,password);
            String sql = "delete from pivot" ;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            conn.close();
        }
        catch (Exception e)
        {
         e.printStackTrace();
        }

    }
    
    public String Login(String userName){
                /*
        Este método realiza una consulta a la base de datos para saber si el
        usuario está o no registrado, va a retorar un String con TRUE o FALSE
        determinando si está o no en la base.
        */
        String tipo = "";
        try{
            OracleDataSource ds;
            ds = new OracleDataSource();
            ds.setURL(jdbcUrl);
            conn=ds.getConnection(userid,password);
            String sql = "select tipo from Usuario where username = '" + userName+"'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                tipo = rs.getString("tipo");
            }
            rs.close();
            conn.close();
        }
        catch (Exception e)
        {
         e.printStackTrace();
        }
        return tipo;
    }

    public void getPivot(Integer IdFactura, String puntoVenta){
                //Este método trea la información de la tabla pivot 
        try{
            Integer tot = 0;
            PuntoDeVenta PV = new PuntoDeVenta();
            OracleDataSource ds;
            ds = new OracleDataSource();
            ds.setURL(jdbcUrl);
            conn=ds.getConnection(userid,password);
            String sql = "select id_producto, cantidad from pivot" ;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Integer producto;
                Integer cant;
                producto = rs.getInt("id_producto");
                cant = rs.getInt("cantidad");
                tot = tot + (Precio(producto)*cant); 
                agregarProducto(IdFactura, producto, cant);
            }
            rs.close();
            conn.close();
            resetPivot();
            ActualizarFactura(IdFactura,tot);
            insertarControl(puntoVenta, tot, IdFactura);
            control(tot);
        }
        catch (Exception e)
        {
         e.printStackTrace();
        }
    }
    
private void insertarControl(String PuntoDeVenta, Integer tota, Integer idFac) throws SQLException{
        //Este procedimiento inserta la información correspondiente a las compras
    // de las ventas que se realizan por punto de venta.
OracleDataSource ds;
    ds = new OracleDataSource();
    ds.setURL("jdbc:oracle:thin:@localhost:1521/GestorEmpresa");
    conn=ds.getConnection("GestorEmpresarial","gestorE");
    CallableStatement cs;
   //conn = dataSource.getConnection(); 
    cs = conn.prepareCall("{ CALL insertarVenta(?,?,?) }");
    //populate stored proc parameters
    cs.setString(1, PuntoDeVenta);
    cs.setInt(2, tota);
    cs.setInt(3, idFac);
    //cs.registerOutParameter(3, Types.NUMERIC); 
    //execute stored procedure
    cs.execute();
    cs.close();
    conn.close(); 
}
    
private void ActualizarFactura(Integer idFactura,Integer total) throws SQLException{
        //Esta función se le envían los parámetros que son el id de la factura
    // y su total para actualizar la misma 
    
    OracleDataSource ds;
    ds = new OracleDataSource();
    ds.setURL(jdbcUrl);
    conn=ds.getConnection(userid,password);
    CallableStatement cs;
    cs = conn.prepareCall("{ CALL actualizarFactura(?,?)}");
    //populate stored proc parameters
    cs.setInt(1, idFactura);
    cs.setInt(2, total);
    //execute stored procedure
    cs.execute();
    cs.close();
    conn.close(); 
}

private void control (Integer total) throws SQLException{
       //Esta función ejecuta el procedimiento de totalXdía que actualiza el valor
    // de el total de ventas que se realizan por día
    // es decir la cantidad de dinero que se realizo.
    
    OracleDataSource ds;
    ds = new OracleDataSource();
    ds.setURL(jdbcUrl);
    conn=ds.getConnection(userid,password);
    CallableStatement cs;
    cs = conn.prepareCall("{ CALL TotalXdia(?)}");
    //populate stored proc parameters
    cs.setInt(1, total);
    //execute stored procedure
    cs.execute();
    cs.close();
    conn.close(); 
}
    
private void agregarProducto(Integer idFactura,Integer IdProducto,Integer cantidad) throws SQLException{
        //Está función recibe los parámetros enviados por el usuario mediante
    //la aplicación web y agregan el producto a la factura.
    
    OracleDataSource ds;
    ds = new OracleDataSource();
    ds.setURL(jdbcUrl);
    conn=ds.getConnection(userid,password);
    CallableStatement cs;
    cs = conn.prepareCall("{ CALL insertarProductoXFactura(?,?,?)}");
    //populate stored proc parameters
    cs.setInt(1, idFactura);
    cs.setInt(2, IdProducto);
    cs.setInt(3, cantidad);
    //execute stored procedure
    cs.execute();
    cs.close();
    conn.close(); 
}

private Integer Precio(Integer idProducto) throws SQLException{
        //Este método ejecuta una función dentro de la base de datos que 
    //retorna el precio de cada producto en específico utilizando su id respectivo.
    OracleDataSource ds;
    ds = new OracleDataSource();
    ds.setURL(jdbcUrl);
    conn=ds.getConnection(userid,password);
    CallableStatement cs;
    cs = conn.prepareCall("{CALL ? := retornarPrecio(?)}");
    cs.registerOutParameter(1, Types.INTEGER);
    cs.setInt(2, idProducto);
    cs.execute();
    int precio = cs.getInt(1);
    cs.close();
    conn.close(); 
    return precio;
}
public Integer IdFactura() throws SQLException{
    //Este método retorna el id de la factura que se realizó por última vez
    //es decir, la factura de la última compra que se realizó en el sistema.
    OracleDataSource ds;
    ds = new OracleDataSource();
    ds.setURL(jdbcUrl);
    conn = ds.getConnection(userid,password);
    CallableStatement cs;
    cs = conn.prepareCall("{CALL ? := ULTIMO_ID_FACTURA}");
    cs.registerOutParameter(1, Types.INTEGER);
    cs.execute();
    int idfactura = cs.getInt(1);
    cs.close();
    conn.close(); 
    return idfactura;
    
}
public Integer crearFactura(String PuntoDeVenta,String descuento, String cedula) throws SQLException{
    
    //Este método llama un procedimiento en la base de datos que inserta la 
    //información de la factura en su respectiva tabla para poder guardar
    //dicha información que va hacer utilizada en diferentes momentos de la 
    //aplicación.
    
    int desc = Integer.parseInt(descuento);
    int ced = Integer.parseInt(cedula);
    OracleDataSource ds;
    ds = new OracleDataSource();
    ds.setURL(jdbcUrl);
    conn=ds.getConnection(userid,password);
    CallableStatement cs;
    cs = conn.prepareCall("{CALL ? := insertarFactura(?,?,?)}");
    cs.registerOutParameter(1, Types.INTEGER);
    cs.setString(2, PuntoDeVenta);
    cs.setInt(3, desc);
    cs.setInt(4, ced);
    cs.execute();
    int id = cs.getInt(1);
    cs.close();
    conn.close(); 
    return id;
}

public void insertarProducto(String producto,String descripcion,String precio,String marca,String categoria,String cantidad,String minimo, String NOMBRE_BODEGA, Integer cedu) throws SQLException{
       
    //Método que llama a un procedimiento que inserta un nuevo producto a la base
    //de datos, recibe la información respectiva para agregarlo correctamente.
    int precio1 = Integer.parseInt(precio);
    int cantidad1 = Integer.parseInt(cantidad);
    int minimo1 = Integer.parseInt(minimo);
    OracleDataSource ds;
    ds = new OracleDataSource();
    ds.setURL("jdbc:oracle:thin:@localhost:1521/GestorEmpresa");
    conn=ds.getConnection("GestorEmpresarial","gestorE");
    CallableStatement cs;
   //conn = dataSource.getConnection(); 
    cs = conn.prepareCall("{ CALL insertarProducto(?,?,?,?,?,?,?,?,?) }");
    //populate stored proc parameters
    cs.setString(1, producto);
    cs.setString(2, descripcion);
    cs.setInt(3, precio1);
    cs.setString(4, marca);
    cs.setString(5, categoria);
    cs.setInt(6, cantidad1);
    cs.setInt(7, minimo1);
    cs.setString(8, NOMBRE_BODEGA);
    cs.setInt(9, cedu);
    //cs.registerOutParameter(3, Types.NUMERIC); 
    //execute stored procedure
    cs.execute();
    cs.close();
    conn.close(); 
}
public void ActualizarInventario(String IdProducto, String Cantidad) throws SQLException{ 
        //Este método actualiza el inventario actual de productos en la base de datos
    //ya sea si se agrega un producto o si se compran, realiza las respectivas
    //sumas o restas.
    
    int id = Integer.parseInt(IdProducto);
    int Cant = Integer.parseInt(Cantidad);
    OracleDataSource ds;
    ds = new OracleDataSource();
    ds.setURL("jdbc:oracle:thin:@localhost:1521/GestorEmpresa");
    conn = ds.getConnection("GestorEmpresarial","gestorE");
    CallableStatement cs;
   
    cs = conn.prepareCall("{ CALL actualizarInventario(?,?)}");
    cs.setInt(1, id);
    cs.setInt(2, Cant);
    cs.execute();
    cs.close();
    conn.close();  
}

public void crearBodega(String pNombreB, String pPais, String pProvincia,
        String pCanton, String pDireccion, String pNumero) throws SQLException{ 
        
    //Este método recibe la información necesaria y ejecuta un procedimiento
    //escrito en la base de datos que inserta nuevas bodegas
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


public void crearUsuario(String pNombre, String pCedula,String pApellido,
        String pPais, String pProvincia,String pCanton, String pDireccion, String pEmail,
        String pNumero,String pTipo) throws SQLException{
        
    //Este método recibe los datos de una persona y la crea como usuario en la
    //base de datos
    
    //Revisa que el número de cédula no sea mayor a 10 dígitos.
    
    if(pCedula.length() > 10){
        System.out.println("Numeromuylargo");
    }
    else{
    int nCedula = -1;
    nCedula= Integer.parseInt(pCedula);
    OracleDataSource ds;
    ds = new OracleDataSource();
    ds.setURL("jdbc:oracle:thin:@localhost:1521/GestorEmpresa");
    conn = ds.getConnection("GestorEmpresarial","gestorE");
    CallableStatement cs;
   
    cs = conn.prepareCall("{ CALL insertarPERSONA(?,?,?,?,?,?,?,?,?,?) }");
    //populate stored proc parameters
    cs.setString(1, pNombre);
    cs.setInt(2, nCedula);
    cs.setString(3, pApellido);
    cs.setString(4, pPais);
    cs.setString(5, pProvincia);
    cs.setString(6,pCanton);
    cs.setString(7,pDireccion);
    cs.setString(8, pEmail);
    cs.setString(9,pNumero);
    cs.setString(10,pTipo);
  
    cs.execute();
    cs.close();
    conn.close();
    }
}

public void crearUsuario2(Integer cedula, String contra, String tipo, String usrName) throws SQLException{
        //Crea usuario2 realiza el insert para crear un usuario y la contraseña
    // para que una persona previamente agregada pueda utilizar la aplicación
    OracleDataSource ds;
    ds = new OracleDataSource();
    ds.setURL("jdbc:oracle:thin:@localhost:1521/GestorEmpresa");
    conn = ds.getConnection("GestorEmpresarial","gestorE");
    CallableStatement cs;
   
    cs = conn.prepareCall("{ CALL insertarUsuario(?,?,?,?) }");
    //populate stored proc parameters
    cs.setInt(1, cedula);
    cs.setString(2, contra);
    cs.setString(3, tipo);
    cs.setString(4, usrName);
    cs.execute();
    cs.close();
    conn.close();
    
}

public void crearPuntoVenta(String NombrePV, String Pais, String Provincia,
        String Canton, String Direccion, String Numero) throws SQLException{  
        //Este método recibe la información necesaria y ejecuta un procedimiento
    //en la base de datos que agrega un nuevo punto de venta.
    OracleDataSource ds;
    ds = new OracleDataSource();
    ds.setURL(jdbcUrl);
    conn = ds.getConnection(userid,password);
    CallableStatement cs;
    cs = conn.prepareCall("{CALL insertarPuntoDeVenta(?,?,?,?,?,?)}");
    //populate stored proc parameters
    cs.setString(1, NombrePV);
    cs.setString(2, Pais);
    cs.setString(3, Provincia);
    cs.setString(4, Canton);
    cs.setString(5, Direccion);
    cs.setString(6, Numero);
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
public LinkedList<contenidoFactura> getProductosFactura(){
        //Este método retorna una LinkedList con todos los productos que tiene
    //una factura en especifico, se utiliza en la clase iFacture para poder
    //imprimir en pantalla los productos que tiene esa respectiva factura.
        LinkedList<contenidoFactura> listaProd = new LinkedList<contenidoFactura>();
        try{
            oracleConn ora1 = new oracleConn();
            int idFactura = ora1.IdFactura();
            OracleDataSource ds;
            ds = new OracleDataSource();
            ds.setURL(jdbcUrl);
            conn=ds.getConnection(userid,password);
            String idFacturaS = Integer.toString(idFactura);
            String sql = "SELECT P.PRODUCTO, C.CANTIDADPRODUCTOS ,P.PRECIOUNITARIO, P.DESCRIPCION FROM PRODUCTO P, PRODUCTOXFACTURA C WHERE P.ID_PRODUCTO = C.ID_PRODUCTO AND C.ID_FACTURA = " + idFacturaS; 
            Statement ejec = conn.createStatement();     
            ResultSet rs = ejec.executeQuery(sql);
            
            while (rs.next()){
                contenidoFactura factura = new contenidoFactura();
                factura.setNombreP(rs.getNString("PRODUCTO"));
                factura.setDescripcion(rs.getNString("DESCRIPCION"));
                factura.setCantidad(rs.getNString("CANTIDADPRODUCTOS"));
                factura.setPrecio(rs.getNString("PRECIOUNITARIO"));
                factura.setTotalC();
                listaProd.add(factura);
                System.out.println(rs.getNString("PRODUCTO"));
                System.out.println(rs.getNString("DESCRIPCION"));
                System.out.println(rs.getNString("CANTIDADPRODUCTOS"));
                System.out.println(rs.getNString("PRECIOUNITARIO"));
            }
            rs.close();
            conn.close();
        }
        catch (Exception e)
        {
         e.printStackTrace();
        }
      return listaProd;
    }

    public int totalDescuento(){
        //Este método retorna un número entero con el descuento que se realizó 
        //a una factura.
        int descuento = 0;
        try{
            oracleConn ora1 = new oracleConn();
            int idFactura = ora1.IdFactura();
            OracleDataSource ds;
            ds = new OracleDataSource();
            ds.setURL(jdbcUrl);
            conn=ds.getConnection(userid,password);
            String idFacturaS = Integer.toString(idFactura);
            String sql ="SELECT DESCUENTO FROM FACTURA WHERE ID_FACTURA = "+idFacturaS;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
            descuento = Integer.parseInt(rs.getNString("DESCUENTO"));}
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        return descuento;
    }
    public int totalPagar(){
        //Retorna un número entero con el monto total a pagar para la última
        //factura que se realizó.
        int total = -1;
        try{
        oracleConn ora1 = new oracleConn();
        int idFactura = ora1.IdFactura();
        OracleDataSource ds;
        ds = new OracleDataSource();
        ds.setURL(jdbcUrl);
        conn=ds.getConnection(userid,password);
        String idFacturaS = Integer.toString(idFactura);
        String sql ="SELECT TOTAL FROM FACTURA WHERE ID_FACTURA = "+idFacturaS;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
        total = Integer.parseInt(rs.getNString("TOTAL"));}
        }
        catch(Exception e){
            System.out.println(e);
        }
        return total;
    }

    public LinkedList<inventario> getInventario(){
         //Este método retorna una LinkedList con todos los productos y su
        //información respectiva para mostrarlo en la pantalla de inventario
        LinkedList<inventario> listaInv =new LinkedList<inventario>();
        try{
            
            OracleDataSource ds;
            ds = new OracleDataSource();
            ds.setURL("jdbc:oracle:thin:@localhost:1521/GestorEmpresa");
            conn=ds.getConnection("GestorEmpresarial","gestorE");
            String sql = "select p.id_producto, p.producto, p.descripcion,p.preciounitario, m.marca, ca.categoria, p.cantidad, p.minimo, g.NOMBREBODEGA from producto p, marca m,categoria ca, bodega g, inventario ie where p.IDMARCA = m.ID_MARCA and p.IDCATEGORIA = ca.ID_CATEGORIA and ie.ID_PRODUCTO = p.ID_PRODUCTO and ie.ID_BODEGA = g.ID_BODEGA" ;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                inventario Inv = new inventario();
                Inv.setId(rs.getNString("ID_PRODUCTO"));
                Inv.setProducto(rs.getNString("PRODUCTO"));
                Inv.setDescripcion(rs.getNString("DESCRIPCION"));
                Inv.setPrecio(rs.getNString("PRECIOUNITARIO"));
                Inv.setMarca(rs.getNString("MARCA"));
                Inv.setCategoria(rs.getNString("CATEGORIA"));
                Inv.setCantidad(rs.getNString("CANTIDAD"));
                Inv.setMinimo(rs.getNString("MINIMO"));
                Inv.setBodega(rs.getNString("NOMBREBODEGA"));
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
                //Este método retorna una LinkedList con todas las bodegas que se encuentran
        //registradas en la base de datos
        
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
    
    public static LinkedList<PuntosVenta> getNombrePuntoVenta(){
        //Este método retorna un LinkedList con todos los nombres de los puntos
        //de ventas en la base de datos, esto para poder utilizarlos en 
        //diferentes combobox en la aplicación.
        LinkedList<PuntosVenta> listaPuntosVenta = new LinkedList<PuntosVenta>();
        try{
            OracleDataSource ds;
            ds = new OracleDataSource();
            ds.setURL(jdbcUrl);
            conn=ds.getConnection(userid,password);
            String sql = "SELECT nombrepuntodeventa FROM puntodeventa" ;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                PuntosVenta pv = new PuntosVenta();
                pv.setNombre(rs.getNString("nombrepuntodeventa"));
                listaPuntosVenta.add(pv);
            }
            rs.close();
            conn.close();
        }
        catch (Exception e)
        {
         e.printStackTrace();
        }
      return listaPuntosVenta;
    }
    
    public static LinkedList<PuntoDeVenta> getPuntoVenta(){
        //Este método retorna una LinkedList con todos los puntos de ventas
        //y su información respectiva para ser mostrada en la aplicación.
        
        LinkedList<PuntoDeVenta> listaPV =new LinkedList<PuntoDeVenta>();
        try{            
            OracleDataSource ds;
            ds = new OracleDataSource();
            ds.setURL(jdbcUrl);
            conn=ds.getConnection(userid,password);
            String sql = "select pv.id_puntodeventa, pv.nombrepuntodeventa, d.pais, d.provincia, d.canton, d.direccion_exacta, t.numtelefono from puntodeventa pv, direccion d, telefono t where pv.id_direccion = d.id_direccion and pv.id_telefono = t.id_telefono" ;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                PuntoDeVenta PV = new PuntoDeVenta();
                PV.setId(rs.getNString("id_puntodeventa"));
                PV.setNombre(rs.getNString("nombrepuntodeventa"));
                PV.setPais(rs.getNString("pais"));
                PV.setProvincia(rs.getNString("provincia"));
                PV.setCanton(rs.getNString("canton"));
                PV.setDireccion(rs.getNString("direccion_exacta"));
                PV.setTelefono(rs.getNString("numtelefono"));
                listaPV.add(PV);
            }
            rs.close();
            conn.close();
        }
        catch (Exception e)
        {
         e.printStackTrace();
        }
      return listaPV;
    }

    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
public void agregarUser(Integer pCedula,String pPassword,String pTipo,String pUserName) throws SQLException{
    //Método que agrega un usuario a la base de datos     
    OracleDataSource ds;
    ds = new OracleDataSource();
    ds.setURL(jdbcUrl);
    conn=ds.getConnection(userid,password);
    CallableStatement cs;
    cs = conn.prepareCall("{ CALL insertarusuario(?,?,?,?)}");
    //populate stored proc parameters
    cs.setInt(1, pCedula);
    cs.setString(2, pPassword);
    cs.setString(3, pTipo);
    cs.setString(4, pUserName);
    //execute stored procedure
    cs.execute();
    cs.close();
    conn.close(); 
}
public int verificaLogin(String pUser, String pPassword) throws SQLException{
    //Este es el primer método que se utiliza en la aplicación, verifica los
    //datos enviados por un usuario para saber si este se encuentra o no
    //registrado en la base de datos.
    
    OracleDataSource ds;
    ds = new OracleDataSource();
    ds.setURL(jdbcUrl);
    conn = ds.getConnection(userid,password);
    CallableStatement cs;
    cs = conn.prepareCall("{CALL ? := LOGIN(?,?)}");
    cs.registerOutParameter(1, Types.INTEGER);
    cs.setString(2, pUser);
    cs.setString(3, pPassword);
    cs.execute();
    int esLogin = cs.getInt(1);
    cs.close();
    conn.close(); 
    return esLogin;
        
    }
public int verificaStock(int pID_PRODUCTO) throws SQLException{
    //Este método verifica todos los productos en el inventario, cuando alguno
    //llegue a una cantidad menor a la minima para ordenar retorna un numero 
    //1 --> como true y quiere decir que SI se debe realizar un pedido de ese 
    //producto, y si es un 0 quiere decir que aún no es necesario
    OracleDataSource ds;
    ds = new OracleDataSource();
    ds.setURL(jdbcUrl);
    conn = ds.getConnection(userid,password);
    CallableStatement cs;
    cs = conn.prepareCall("{CALL ? := CANTIDAD_MINIMO(?)}");
    cs.registerOutParameter(1, Types.INTEGER);
    cs.setInt(2, pID_PRODUCTO);
    cs.execute();
    int valor = cs.getInt(1);
    cs.close();
    conn.close(); 
    return valor;
        
}

   public static LinkedList<Persona> getPersona(){
       //Retorna una LinkedList con todas las personas registradas en la 
       //base de datos.
       
        LinkedList<Persona> listaPersona = new LinkedList<Persona>();
        try{
            OracleDataSource ds;
            ds = new OracleDataSource();
            ds.setURL(jdbcUrl);
            conn=ds.getConnection(userid,password);
            String sql = "select cedula, nombre_Persona, apellido_persona from Persona where tipo_persona = 'PROVEEDOR'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Persona Per = new Persona();
                Per.setCed(rs.getInt("cedula"));
                Per.setNombre(rs.getNString("nombre_Persona"));
                Per.setApellido(rs.getNString("apellido_persona"));
                listaPersona.add(Per);
            }
            rs.close();
            conn.close();
        }
        catch (Exception e)
        {
         e.printStackTrace();
        }
      return listaPersona;
    }
      

public void reStock(int pID_PRODUCTO, int pCANTIDAD) throws SQLException{
    //Este método es el que realiza el restock del producto que se encuentra 
    //con menos del minimo de productos.
    OracleDataSource ds;
    ds = new OracleDataSource();
    ds.setURL(jdbcUrl);
    conn=ds.getConnection(userid,password);
    CallableStatement cs;
    cs = conn.prepareCall("{ CALL RESTOCK(?,?)}");
    //populate stored proc parameters
    cs.setInt(1, pID_PRODUCTO);
    cs.setInt(2, pCANTIDAD);
    cs.execute();
    cs.close();
    conn.close(); 
    }

public void reStockManual(int pID_PRODUCTO,int pCANTIDAD, String pTransaccion) throws SQLException{
    //Este método es el que realiza el restock del producto que se encuentra 
    //con menos del minimo de productos manualmente.
    OracleDataSource ds;
    ds = new OracleDataSource();
    ds.setURL(jdbcUrl);
    conn=ds.getConnection(userid,password);
    CallableStatement cs;
    cs = conn.prepareCall("{ CALL RESTOCK_MANUAL(?,?,?)}");
    //populate stored proc parameters
    cs.setInt(1, pID_PRODUCTO);
    cs.setInt(2, pCANTIDAD);
    cs.setString(3,pTransaccion);
    cs.execute();
    cs.close();
    conn.close(); 
    
}

public LinkedList<Persona> getProvedores(){
    //Retorna una LinkedList con los nombres de todos los proveedores registrados
    // en la base de datos.
        LinkedList<Persona> listaProd = new LinkedList<Persona>();
        try{
            oracleConn ora1 = new oracleConn();
            int idFactura = ora1.IdFactura();
            OracleDataSource ds;
            ds = new OracleDataSource();
            ds.setURL(jdbcUrl);
            conn=ds.getConnection(userid,password);
            String idFacturaS = Integer.toString(idFactura);
            String sql = "SELECT P.NOMBRE_PERSONA,P.APELLIDO_PERSONA,T.NUMTELEFONO,P.EMAIL_PERSONA, D.DIRECCION_EXACTA FROM PERSONA P, DIRECCION D, TELEFONO T WHERE P.ID_DIRECCION = D.ID_DIRECCION AND P.ID_TELEFONO = T.ID_TELEFONO AND P.TIPO_PERSONA = 'PROVEEDOR'"; 
            Statement ejec = conn.createStatement();     
            ResultSet rs = ejec.executeQuery(sql);
            
            while (rs.next()){
                Persona persona = new Persona();
                persona.setNombre(rs.getNString("NOMBRE_PERSONA"));
                persona.setApellido(rs.getNString("APELLIDO_PERSONA"));
                persona.setTelefono(rs.getNString("NUMTELEFONO"));
                persona.setEmail(rs.getNString("EMAIL_PERSONA"));
                persona.setDireccion(rs.getNString("DIRECCION_EXACTA"));
                listaProd.add(persona);
                
            }
            rs.close();
            conn.close();
        }
        catch (Exception e)
        {
         e.printStackTrace();
        }
      return listaProd;
    }

public LinkedList<ProductXPersona> getProductXPersona(int ced){
    //Retorna una linkedListo con todos los productos por persona que se
    //encuentran registrados en la base de datos.
        LinkedList<ProductXPersona> listaPXP = new LinkedList<ProductXPersona>();
        try{
            oracleConn ora1 = new oracleConn();
            int idFactura = ora1.IdFactura();
            OracleDataSource ds;
            ds = new OracleDataSource();
            ds.setURL(jdbcUrl);
            conn=ds.getConnection(userid,password);
            String idFacturaS = Integer.toString(idFactura);
            String sql = "SELECT pf.Id_factura, pf.ID_producto, Cantidadproductos FROM productoxfactura pf, factura f WHERE f.PERSONA = '"+ ced +"'and pf.id_factura = f.id_factura"; 
            Statement ejec = conn.createStatement();     
            ResultSet rs = ejec.executeQuery(sql);
            while (rs.next()){
                ProductXPersona PXP = new ProductXPersona();
                PXP.setCANTIDAD(rs.getNString("Cantidadproductos"));
                PXP.setID_FACTURA(rs.getNString("Id_factura"));
                String sql1 = "select p.producto, p.descripcion, p.preciounitario, m.marca, ca.categoria from producto p, marca m, categoria ca where p.idcategoria = ca.id_categoria and p.idmarca = m.id_marca and p.id_producto = " + rs.getNString("ID_producto");
                Statement ejc = conn.createStatement();     
                ResultSet rs1 = ejc.executeQuery(sql1);
                while (rs1.next()){
                    PXP.setCATEGORIA(rs1.getNString("categoria"));
                    PXP.setDESCRIPCION(rs1.getNString("descripcion"));
                    PXP.setMARCA(rs1.getNString("marca"));
                    PXP.setPRECIOUNITARIO(rs1.getNString("preciounitario"));
                    PXP.setPRODUCTO(rs1.getNString("producto"));
                    PXP.setTOTAL();
                }
                listaPXP.add(PXP);
            }
            rs.close();
            conn.close();
        }
        catch (Exception e)
        {
         e.printStackTrace();
        }
      return listaPXP;
    }
public LinkedList<ventas> ventasGeneralesXPV(){
    //Retorna una linkedList con objetos de ventas generales, es decir una lista
    // con todos las ventas que se han realizado en el sistema.
        LinkedList<ventas> listaV = new LinkedList<ventas>();
        try{
            oracleConn ora1 = new oracleConn();
            int idFactura = ora1.IdFactura();
            OracleDataSource ds;
            ds = new OracleDataSource();
            ds.setURL(jdbcUrl);
            conn=ds.getConnection(userid,password);
            String idFacturaS = Integer.toString(idFactura);
            String sql = "SELECT F.ID_FACTURA,P.NOMBRE_PERSONA,P.APELLIDO_PERSONA,PD.NOMBREPUNTODEVENTA,F.DESCUENTO,F.TOTAL FROM FACTURA F, PERSONA P, PUNTODEVENTA PD WHERE F.PERSONA = P.CEDULA AND F.ID_PUNTODEVENTA = PD.ID_PUNTODEVENTA";
            Statement ejec = conn.createStatement();     
            ResultSet rs = ejec.executeQuery(sql);
            while (rs.next()){
                ventas venta = new ventas();
                venta.setFactura(rs.getString("ID_FACTURA"));
                venta.setNombre(rs.getNString("NOMBRE_PERSONA"));
                venta.setApellido(rs.getNString("APELLIDO_PERSONA"));
                venta.setPuntoDeVenta(rs.getNString("NOMBREPUNTODEVENTA"));
                venta.setDescuento(rs.getNString("DESCUENTO"));
                venta.setTotal(rs.getNString("TOTAL"));
                listaV.add(venta);
            }
            rs.close();
            conn.close();
        }
        catch (Exception e)
        {
         e.printStackTrace();
        }
      return listaV;
    }

   public String getCliente(int cedula){
       //Retorna toda la información de un cliente mediante su cédula.
       String Client = "";
        try{
            OracleDataSource ds;
            ds = new OracleDataSource();
            ds.setURL(jdbcUrl);
            conn=ds.getConnection(userid,password);
            String sql = "select cedula, nombre_Persona, apellido_persona from Persona where cedula =" + cedula;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Client = Client + rs.getInt("cedula") + " : ";
                Client = Client + rs.getNString("nombre_Persona") + " ";
                Client = Client + rs.getNString("apellido_persona");
            }
            rs.close();
            conn.close();
        }
        catch (Exception e)
        {
         e.printStackTrace();
         Client = Integer.toString(cedula);
        }
      return Client;
    }
   
   public int totalPagarManual(int id_factura){
       //Se utiliza para la creación de la factura manual, recibe el id de la 
       //factura y retorna el monto total a pagar de esa factura.
        int total = -1;
        try{

        OracleDataSource ds;
        ds = new OracleDataSource();
        ds.setURL(jdbcUrl);
        conn=ds.getConnection(userid,password);
        String idFacturaS = Integer.toString(id_factura);
        String sql ="SELECT TOTAL FROM FACTURA WHERE ID_FACTURA = "+idFacturaS;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
        total = Integer.parseInt(rs.getNString("TOTAL"));}
        }
        catch(Exception e){
            System.out.println(e);
        }
        return total;
    }
   
   public LinkedList<contenidoFactura> getProductosFacturaManual(int id_factura){
       //Retorna una linlkedList con todos los productos de una factura en especifica
       // recibiendo el número su id
        LinkedList<contenidoFactura> listaProd = new LinkedList<contenidoFactura>();
        try{
            
            OracleDataSource ds;
            ds = new OracleDataSource();
            ds.setURL(jdbcUrl);
            conn=ds.getConnection(userid,password);
            String idFacturaS = Integer.toString(id_factura);
            String sql = "SELECT P.PRODUCTO, C.CANTIDADPRODUCTOS ,P.PRECIOUNITARIO, P.DESCRIPCION FROM PRODUCTO P, PRODUCTOXFACTURA C WHERE P.ID_PRODUCTO = C.ID_PRODUCTO AND C.ID_FACTURA = " + idFacturaS; 
            Statement ejec = conn.createStatement();     
            ResultSet rs = ejec.executeQuery(sql);
            
            while (rs.next()){
                contenidoFactura factura = new contenidoFactura();
                factura.setNombreP(rs.getNString("PRODUCTO"));
                factura.setDescripcion(rs.getNString("DESCRIPCION"));
                factura.setCantidad(rs.getNString("CANTIDADPRODUCTOS"));
                factura.setPrecio(rs.getNString("PRECIOUNITARIO"));
                factura.setTotalC();
                listaProd.add(factura);
                System.out.println(rs.getNString("PRODUCTO"));
                System.out.println(rs.getNString("DESCRIPCION"));
                System.out.println(rs.getNString("CANTIDADPRODUCTOS"));
                System.out.println(rs.getNString("PRECIOUNITARIO"));
            }
            rs.close();
            conn.close();
        }
        catch (Exception e)
        {
         e.printStackTrace();
        }
      return listaProd;
    }
    public int totalDescuentoManual(int id_factura){
        //Retorna un número entero con el total del descuento que se aplica a una
        //factura manualmente, recibiendo el id de dicha factura.
        int descuento = 0;
        try{
            OracleDataSource ds;
            ds = new OracleDataSource();
            ds.setURL(jdbcUrl);
            conn=ds.getConnection(userid,password);
            String idFacturaS = Integer.toString(id_factura);
            String sql ="SELECT DESCUENTO FROM FACTURA WHERE ID_FACTURA = "+idFacturaS;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
            descuento = Integer.parseInt(rs.getNString("DESCUENTO"));}
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        return descuento;

}}
