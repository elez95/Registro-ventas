package ConexionCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexion.Conexion;

public class DeleteCliente {
	
	
	String nombre;
	
	public static void delete_cliente(String nombre_cliente) {
		
		Conexion conexion = new Conexion();
		Connection cn = null;
		cn = conexion.conectar();
		
		String deleteQuery = "DELETE from clientes WHERE nombre = '" + nombre_cliente + "';";
		
		
		
		try(Connection connection = cn;
				PreparedStatement preparedstatement = connection.prepareStatement(deleteQuery)){
			
			int rowsDeleted = preparedstatement.executeUpdate(deleteQuery);
			
			if(rowsDeleted > 0) {
				System.out.println("Delete exitoso, " + rowsDeleted + " columna/s afectadas");
			}
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
