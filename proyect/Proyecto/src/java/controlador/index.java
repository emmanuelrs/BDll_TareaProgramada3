package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class index extends HttpServlet {
    public index(){
        super();
    }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String contextPath = request.getContextPath();
                String userName = request.getParameter("username");
                String contrasena = request.getParameter("password");
                
                oracleConn conect;
                conect = new oracleConn();
                int resultado = 0;
                try{
                    resultado = conect.verificaLogin(userName, contrasena);
                }
                catch(Exception e){
                    System.out.println(e);
                    
                }
                if(resultado == 1){
                    String tip;
                    tip = conect.Login(userName);
                    System.out.println(tip);
                    if(tip.equals("ADMINISTRADOR")){
                        response.sendRedirect(response.encodeRedirectURL("index2.jsp"));
                    }
                    else if(tip.equals("VENDEDOR")){
                        response.sendRedirect(response.encodeRedirectURL("index2USR.jsp"));
                    }
                    else{
                        response.sendRedirect(response.encodeRedirectURL("index.jsp")); 
                    } 
                    }
                else{
                    System.out.println("NO");
                    response.sendRedirect(response.encodeRedirectURL("index.jsp"));
                    }
                
          
    }
    
}
