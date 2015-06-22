
package controlador;
import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/compraXcliente")
public class compraXcliente extends HttpServlet {
    public compraXcliente(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");  
                String cedula = request.getParameter("ced");
                int cedu = Integer.parseInt(cedula);
                String tabla = "";
                oracleConn con = new oracleConn();
                String datos = " ";
                datos = con.getCliente(cedu);
                LinkedList<ProductXPersona> listaPXP = con.getProductXPersona(cedu);
                for (int i=0;i<listaPXP.size();i++)
                {
                String linea = "";
                linea = linea + "<tr>";
                linea = linea +  "<td>"+listaPXP.get(i).getPRODUCTO()+"</td>";
                linea = linea +  "<td>"+listaPXP.get(i).getDESCRIPCION()+"</td>";
                linea = linea + "<td>"+listaPXP.get(i).getPRECIOUNITARIO()+"</td>";
                linea = linea + "<td>"+listaPXP.get(i).getMARCA()+"</td>";
                linea = linea + "<td>"+listaPXP.get(i).getCATEGORIA()+"</td>";
                linea = linea + "<td>"+listaPXP.get(i).getID_FACTURA()+"</td>";
                linea = linea + "<td>"+listaPXP.get(i).getCANTIDAD()+"</td>";
                linea = linea + "<td>"+listaPXP.get(i).getTOTAL()+"</td>";
                linea = linea + "</tr>";
                tabla = tabla + linea;
                }
                datos = con.getCliente(cedu);
                tabla = tabla + ";" + datos;
                System.out.print("datos -->" +datos);
                RequestDispatcher a = request.getRequestDispatcher("compraXcliente.jsp?tab=" + tabla);
		a.forward(request, response);
    }
    
}
