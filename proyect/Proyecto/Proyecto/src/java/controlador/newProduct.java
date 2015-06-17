package controlador;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/newProduct")
public class newProduct extends HttpServlet {
    
    public newProduct(){
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String contextPath = request.getContextPath();
		
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String precio = request.getParameter("precio");
                String marca = request.getParameter("marca");
                String tipo = request.getParameter("tipo");
                String total = request.getParameter("total");
                String minimo = request.getParameter("minimo");

                System.out.print(nombre + descripcion + precio + marca + tipo + total + minimo);
                
                
                response.sendRedirect(response.encodeRedirectURL("index.jsp"));
    }
}