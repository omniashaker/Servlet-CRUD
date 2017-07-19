package usuariobd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VerUsuarios
 */
@WebServlet("/VerUsuarios")
public class VerUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");  
        PrintWriter printWriter=response.getWriter();  
        
        
		printWriter.print("<head>");  
		printWriter.print(" <link href='css/bootstrap.min.css' rel='stylesheet'>");  
		printWriter.print(" </head>");  
		printWriter.print("<body>");  
		
		printWriter.println("<a href='index.html' class='btn btn-info' role='button'>Añadir Usuario</a>");  
		
		
		
        printWriter.println("<h1>Usuarios</h1>");  
          
        List<Usuario> list=UsuarioSql.listaUsuario();  
          
        printWriter.print("<table border='1' width='100%'");  
        printWriter.print("<tr><th>Id</th><th>Nombre</th>"
        	                                + "<th>Apellidos</th><th>Edad</th>"
        	                                +"<th>Edit</th><th>Delete</th></tr>");  
        for(Usuario usuario:list){  
        	
        	printWriter.print("<tr><td>"+usuario.getId()+"</td><td>"+usuario.getNombre()
        	+"</td><td>"+usuario.getApellidos()+"</td><td>"+usuario.getEdad()+"</td><td><a href='UpdateServlet?id="+usuario.getId()
        	+"'>edit</a></td><td><a href='DeletServlet?id="+usuario.getId()+"'>delete</a></td></tr>");  
        }  
        printWriter.print("</table>");  
		printWriter.print("</body>"); 
	
	
	
	
	
	}


}
