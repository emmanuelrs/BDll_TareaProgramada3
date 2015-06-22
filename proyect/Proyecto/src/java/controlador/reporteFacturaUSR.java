package controlador;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reporteFacturaUSR")
public class reporteFacturaUSR extends HttpServlet {
    public reporteFacturaUSR(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");  
                String idFact = request.getParameter("idFactura");
                RequestDispatcher a = request.getRequestDispatcher("iFacturaManual.jsp?idfact=" + idFact);
		a.forward(request, response);
    } 
}
