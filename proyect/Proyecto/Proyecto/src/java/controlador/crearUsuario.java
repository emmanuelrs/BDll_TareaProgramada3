/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Emmanuel
 */
<<<<<<< HEAD
@WebServlet("/crearUsuario")
public class crearUsuario extends HttpServlet {
    public crearUsuario(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String contextPath = request.getContextPath();
                
                String nombreUsuario = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String cedula = request.getParameter("cedula");
                String pais = request.getParameter("pais");
                String provincia = request.getParameter("provincia");
                String canton = request.getParameter("canton");
                String direccion = request.getParameter("direccion");
                String numero = request.getParameter("telefono");
                String tipo = request.getParameter("tipo");
                String email = request.getParameter("email");
                oracleConn conect;
                conect = new oracleConn();

        try {
            conect.crearUsuario(nombreUsuario,cedula,apellido, pais, provincia,canton,direccion,email,numero,tipo);
        } catch (SQLException ex) {
            System.out.print("Error");
            Logger.getLogger(newProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

                response.sendRedirect(response.encodeRedirectURL("crearUsuario.jsp"));
    }
    
   
=======
public class crearUsuario {
>>>>>>> origin/master
    
}
