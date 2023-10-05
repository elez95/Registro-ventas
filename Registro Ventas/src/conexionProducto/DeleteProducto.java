package conexionProducto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexion.Conexion;

public class DeleteProducto {
	
	
	public static void delete_producto(int id_producto) {
		
		Conexion conexion = new Conexion();
		Connection cn = null;
		cn = conexion.conectar();
		
		String deleteQuery = "DELETE from clientes WHERE idProducto = '" + id_producto + "';";
		
		
		
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
