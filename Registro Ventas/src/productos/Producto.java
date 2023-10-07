package productos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.Conexion;

public class Producto {



	public static void create_producto(String tipoProducto, String color, String detalle, double precio) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		cn = conexion.conectar();

		String insertQuery = "insert into producto (tipoProducto, color, detalle, precio) values(?,?,?,?);";

		try (Connection connection = cn;
				PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

			// Setear los valores de las columnas
			preparedStatement.setString(1, tipoProducto);
			preparedStatement.setString(2, color);
			preparedStatement.setString(3, detalle);
			preparedStatement.setDouble(4, precio);

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

	public static void read_tabla() {

		Conexion c = new Conexion();
		try (Connection conexion = c.conectar();
				Statement statement = conexion.createStatement()) {

			// Ejecutar una consulta SQL para seleccionar todos los registros de la tabla
			String consultaSQL = "SELECT * FROM producto;";
			ResultSet resultado = statement.executeQuery(consultaSQL);

			// Recorrer el resultado y mostrar los datos
			while (resultado.next()) {
				// Reemplaza "columna1" y "columna2" con los nombres de las columnas de tu tabla
				String tipoProducto = resultado.getString("tipoProducto"); //cambiar nombre a tipo producto
				String marca = resultado.getString("marca");
				String colorProducto = resultado.getString("color");
				String detalleProducto = resultado.getString("detalle");
				double precioProducto = resultado.getDouble("precio");
				int idProducto = resultado.getInt("idProducto");
				System.out.println("Id: " + idProducto + " Tipo: " + tipoProducto + " Marca: " + marca + " Color: " + colorProducto
						+ " Detalle: " + detalleProducto + " Precio: " + precioProducto);
			}

		} catch (SQLException e) {
			System.out.println("Error al leer la tabla");
			e.printStackTrace();
		}
	}

	// Método para actualizar un registro por su ID y nuevo nombre
	public static void update_cliente(int id, String columna, String dato) {
		
	    String sentenciaSQL = "UPDATE producto SET " + columna + " = ? WHERE idProducto = ?";
	    Conexion c = new Conexion();
	    try (Connection conexion = c.conectar();
	         PreparedStatement preparedStatement = conexion.prepareStatement(sentenciaSQL)) {

	        // Establece los parámetros en la sentencia SQL
	        preparedStatement.setString(1, dato);
	        preparedStatement.setInt(2, id);

	        // Ejecuta la sentencia SQL de actualización
	        int filasAfectadas = preparedStatement.executeUpdate();

	        // Imprime el número de filas afectadas por la actualización
	        System.out.println("Filas afectadas: " + filasAfectadas);
	    } catch (SQLException e) {
	        System.out.println("Error al ejecutar la sentencia SQL de actualización");
	        e.printStackTrace();
	    }
	}


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


	public static void main(String args []) throws SQLException {

		//Producto p = new Producto();
		//p.agregar_producto("Cartera", "verde", "marca Discovery", 25);
		Producto.update_cliente(1, "precio", "20.5");
		//Producto.create_producto("Mochila", "Negro", "mochila chica", 26);
		Producto.read_tabla();

	}

}
