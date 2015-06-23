package controlador;
/*
Elaborado por: Emmanuel Rosales Salas, Luis Serrano y Cristiam Flores Nuñez
Bases de Datos 2.
*/

//Imports necerios para la clase
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Esta clase recibe la cédula de un usuario y muestra todas las compras que ha realizado
//con su nombre.


@WebServlet("/reporteFacturaUSR")
public class reporteFacturaUSR extends HttpServlet {
    public reporteFacturaUSR(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");  
                String idFact = request.getParameter("idFactura");
                //Envía la cédula con el Dispatcher para que se imprima la respectiva tabla
                RequestDispatcher a = request.getRequestDispatcher("iFacturaManual.jsp?idfact=" + idFact);
		a.forward(request, response);
    } 
}
