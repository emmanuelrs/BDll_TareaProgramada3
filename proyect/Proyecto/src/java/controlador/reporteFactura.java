package controlador;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reporteFactura")
public class reporteFactura extends HttpServlet {
    public reporteFactura(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");  
                String idFact = request.getParameter("idFactura");
                String respuesta = ""; 
                respuesta = respuesta + "oracleConn ora2 = new oracleConn();";
              
                respuesta = respuesta + "<td> ₡" + "ora2.totalPagarManual("+idFact+")"+"</td>";
           
                RequestDispatcher a = request.getRequestDispatcher("iFacturaManual.jsp?idfact=" + respuesta);
		a.forward(request, response);
                

    }
    
}