package conexionProducto;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;


public class InsertProducto {
	
	public static void insert_producto(String nombreProducto, String color, String detalle, int precio) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		cn = conexion.conectar();
		
		String insertQuery = "insert into producto (nombreProducto, color, detalle, precio) values(?,?,?,?);";
		
		try (Connection connection = cn;
	             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

	            // Setear los valores de las columnas
	            preparedStatement.setString(1, nombreProducto);
	            preparedStatement.setString(2, color);
	            preparedStatement.setString(3, detalle);
	            preparedStatement.setInt(4, precio);

	            // Ejecutar la inserción
	            int rowsInserted = preparedStatement.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("Inserción exitosa, " + rowsInserted + " columna/s afectadas");
	            }

	        } catch (SQLException e) {
	        	System.out.println("hola");
	        	e.printStackTrace();
	            
	        }
		
	}
	public static void main(String[] args) {
		
		
		
		
		
	}
}
