package usuariobd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet2
 */
@WebServlet("/UpdateServlet2")
public class UpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		int edad = Integer.parseInt(request.getParameter("edad"));
		
		
		Usuario usuario = new Usuario() ;
		usuario.setId(id);
		usuario.setNombre(nombre);
		usuario.setApellidos(apellidos);
		usuario.setEdad(edad);
		
		
		int num = UsuarioSql.actualizar(usuario);
		
		if (num >0) {
			response.sendRedirect("VerUsuarios");
			
		}else{
			printWriter.println("<h2> No se ha actualizado correctamente</h2>");
		}
		
		
		
		
		
	}

}
