package conexion;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

public class TestInsert {
	
	public static void main(String[] args) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		//Statement stm = null;
		//ResultSet rs = null;
		
		String nombre = "Samuel";
		int id = 3;
		int edad = 34;
		
		cn = conexion.conectar();
		
		String insertQuery = "insert into tabla1 (nombre, edad, id) values(?,?,?);";
		
		try (Connection connection = cn;
	             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

	            // Setear los valores de las columnas
	            preparedStatement.setString(1, nombre);
	            preparedStatement.setInt(2, edad);
	            preparedStatement.setInt(3, id);

	            // Ejecutar la inserción
	            int rowsInserted = preparedStatement.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("Inserción exitosa.");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("hola");
	        }
	}
}
