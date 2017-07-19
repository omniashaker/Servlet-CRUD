package usuariobd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<h1> Actualizar informacion del Usuario  </h1> ");
		String idusuario = request.getParameter("id");
		int id = Integer.parseInt(idusuario);
		
		Usuario usuario = UsuarioSql.ObtenerUsuario(id);
		
		printWriter.print("<head>");  
		printWriter.print(" <link href='css/bootstrap.min.css' rel='stylesheet'>");  
		printWriter.print(" </head>");  
		printWriter.print("<body>");  
		printWriter.print("<form action='UpdateServlet2' method='post'>");  
		printWriter.print("<table>");  
		printWriter.print("<tr><td></td><td><input   name='id' value='"+usuario.getId()+"'/></td></tr>");  
		printWriter.print("<tr><td>Nombre:</td><td><input type='text' name='nombre' value='"
		+usuario.getNombre()+"'/></td></tr>");  
		printWriter.print("<tr><td>Apellidos:</td><td><input type='text' name='apellidos' value='"
		+usuario.getApellidos()+"'/></td></tr>"); 
		printWriter.print("<tr><td>Edad:</td><td><input type='text' name='edad' value='"
		+usuario.getEdad()+"'/></td></tr>"); 

		  
		printWriter.print("<tr><td colspan='2'><input type='submit' value='submit '/></td></tr>");  
		printWriter.print("</table>");  
		printWriter.print("</form>");
		printWriter.print("</body>"); 
	
 
	}

}
