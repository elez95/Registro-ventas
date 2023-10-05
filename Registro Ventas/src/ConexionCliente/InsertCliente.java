package ConexionCliente;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

import conexion.Conexion;

public class InsertCliente {
	
	//private String nombre;
	
	public static void insert_cliente(String nombre) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		cn = conexion.conectar();
		
		String insertQuery = "insert into clientes (nombre) values(?);";
		
		try (Connection connection = cn;
	             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

	            // Setear los valores de las columnas
	            preparedStatement.setString(1, nombre);
	            //preparedStatement.setInt(2, edad);
	            //preparedStatement.setInt(3, id);

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
