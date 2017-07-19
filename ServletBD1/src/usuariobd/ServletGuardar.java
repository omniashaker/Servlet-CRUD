package usuariobd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletGuardar
 */
@WebServlet("/ServletGuardar")
public class ServletGuardar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGuardar() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		int edad = Integer.parseInt(request.getParameter("edad"));
		
		
 
		
		
		
		
		Usuario u = new Usuario();
		u.setEdad(edad);
		u.setNombre(nombre);
		u.setApellidos(apellidos);
		
		int num = UsuarioSql.insertar(u) ; 
		
		if (num >0) {
			pw.println("<h2> Insertado correctamente ! </h2>");
			request.getRequestDispatcher("index.html").include(request, response);
			 
		}
		else{
			pw.println("<h2> No se ha insertado:(   </h2>");
			 
		}
		
	
	
	}

}
