package usuariobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioSql {

	//creamos la conexion a la base de datos
	
	public static Connection getConnection(){
		Connection conn=null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/usuarios";
			conn = DriverManager.getConnection(url, "root","root114");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	public static int insertar(Usuario u){
		int us =0;
		
		try {
			String sql = "INSERT INTO `usuario`(`nombre`, `apellidos`,`edad`) VALUES (?,?,?)";
			Connection con = UsuarioSql.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(sql);
		
			preparedStatement.setString(1, u.getNombre());
			preparedStatement.setString(2, u.getApellidos());
			preparedStatement.setInt(3, u.getEdad());
			
			us = preparedStatement.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return us;
		
	}
	
	
	public static int actualizar(Usuario u){
		int us =0;

		try {
			String sql = "UPDATE `usuario` SET   `nombre`=?,`apellidos`=? , `edad`=? WHERE id=?";
			Connection con = UsuarioSql.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, u.getNombre());
			preparedStatement.setString(2, u.getApellidos());
			preparedStatement.setInt(3, u.getEdad());
			preparedStatement.setInt(4, u.getId());
			
			us = preparedStatement.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return us;
	}
	
	public static int Eliminar(int id){
		
		int st = 0;
		
		try {
			String sql = "DELETE FROM `usuario` WHERE id=?";
			Connection con = UsuarioSql.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			 
			preparedStatement.setInt(1, id);
			
			st = preparedStatement.executeUpdate();
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return st;
		
	}
	
	public static Usuario  ObtenerUsuario(int id){
		
		Usuario usuario = new Usuario();
		
		try {
			String sql = "SELECT * FROM `usuario` WHERE id=?";
			Connection con = UsuarioSql.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				usuario.setId(resultSet.getInt(1));
				usuario.setNombre(resultSet.getString(2));
				usuario.setApellidos(resultSet.getString(3));
				usuario.setEdad(resultSet.getInt(4));
				
				
			}

			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuario;
		
	}

	public static List<Usuario>  listaUsuario(){
		
		List<Usuario> list = new ArrayList<Usuario>();
		
		try {
			String sql = "SELECT * FROM `usuario` WHERE 1";
			Connection con = UsuarioSql.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setId(resultSet.getInt(1));
				usuario.setNombre(resultSet.getString(2));
				usuario.setApellidos(resultSet.getString(3));
				usuario.setEdad(resultSet.getInt(4));
				list.add(usuario);
				
			}

			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}	
		
		
		
		
}
