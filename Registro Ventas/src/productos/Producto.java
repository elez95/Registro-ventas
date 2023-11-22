package productos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.Conexion;

public class Producto {


	public static void create_producto(String tipoProducto, String marca, String color, String detalle, double precioCompra, double precioVenta, int cantidad) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		cn = conexion.conectar();
		boolean camposEstanVacios = revisar_campos_vacios_producto(tipoProducto, marca, color, detalle, Double.toString(precioCompra), Double.toString(precioVenta), Integer.toString(cantidad));

		if(!es_numerico(Double.toString(precioCompra))) {
			throw new IllegalArgumentException("El campo precio compra solo permite caracteres numéricos y ','");
		}
		
		if(camposEstanVacios) {
			String insertQuery = "insert into producto (tipoProducto, marca, color, detalle, precioCompra, precioVenta, cantidad) values(?,?,?,?,?,?,?);";

			try (Connection connection = cn;
					PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

				// Setear los valores de las columnas
				preparedStatement.setString(1, tipoProducto);
				preparedStatement.setString(2, marca);
				preparedStatement.setString(3, color);
				preparedStatement.setString(4, detalle);
				preparedStatement.setDouble(5, precioCompra);
				preparedStatement.setDouble(6, precioVenta);
				preparedStatement.setInt(7, cantidad);

				// Ejecutar la inserción
				int rowsInserted = preparedStatement.executeUpdate();
				if (rowsInserted > 0) {
					System.out.println("Inserción exitosa, " + rowsInserted + " columna/s afectadas");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			throw new IllegalArgumentException("Hay campos vacios");
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
				String tipoProducto = resultado.getString("tipoProducto"); //cambiar nombre a tipo producto
				String marca = resultado.getString("marca");
				String colorProducto = resultado.getString("color");
				String detalleProducto = resultado.getString("detalle");
				double precioProducto = resultado.getDouble("precioCompra");
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
	public static void update_producto(int id, String columna, String dato) {
		
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
	        System.out.println("Columna " + columna + " actualizada. " + "Filas afectadas: " + filasAfectadas);
	    } catch (SQLException e) {
	        System.out.println("Error al ejecutar la sentencia SQL de actualización");
	        e.printStackTrace();
	    }
	}


	public static void delete_producto(int id_producto) {

		//probar que existe el id del producto
		if(existe_producto(id_producto)) {
			Conexion conexion = new Conexion();
			Connection cn = null;
			cn = conexion.conectar();

			String deleteQuery = "DELETE from producto WHERE idProducto = '" + id_producto + "';";



			try(Connection connection = cn;
					PreparedStatement preparedstatement = connection.prepareStatement(deleteQuery)){

				int rowsDeleted = preparedstatement.executeUpdate(deleteQuery);

				if(rowsDeleted > 0) {
					System.out.println("Delete exitoso, " + rowsDeleted + " columna/s afectadas");
				}

			} catch(SQLException e) {
				e.printStackTrace();
			}
		} else {
			throw new IllegalArgumentException("No existe el producto con el id: " + id_producto);
		}
	}
	
	public static boolean existe_producto(int id) {
		Conexion c = new Conexion();
		int idProducto = 0;
		try (Connection conexion = c.conectar();
				Statement statement = conexion.createStatement()) {

			// Ejecutar una consulta SQL para seleccionar todos los registros de la tabla
			String consultaSQL = "SELECT * FROM producto where idProducto = '" + id + "';";
			ResultSet resultado = statement.executeQuery(consultaSQL);

			while (resultado.next()) {
				idProducto = resultado.getInt("idProducto");
			}

		} catch (SQLException e) {
			System.out.println("Error al leer la tabla");
			e.printStackTrace();
		}
		if (idProducto == 0) {
			return false;
		}
		return true;
	}
	
	public static boolean revisar_campos_vacios_producto(String tipoProducto, String marca, String color, String detalle, String precioCompra, String precioVenta, String cantidad) {
	
		if(tipoProducto == null || tipoProducto.equals("")) {return false;}
		if(marca == null || marca.equals("")) {return false;}
		if(color == null || color.equals("")) {return false;}
		if(precioCompra == null || precioCompra.equals("")) {return false;}
		if(precioVenta == null || precioVenta.equals("")) {return false;}
		if(cantidad == null || cantidad.equals("")) {return false;}
		return true;
	}


	private static boolean es_numerico(String numero) {
		
		for(int i = 0; i < numero.length(); i++) {
			if(!Character.isDigit(numero.charAt(i))) {
				if(numero.charAt(i) != ',') {
					return false;
				}
			}
		}		
		return true;
	}
	
	public static void main(String args []) throws SQLException {

		//Producto p = new Producto();
		//Producto.create_producto("Mochila", "Adidas", "Negro", "Mochila deportiva", "10,4", 300, 20);
		//Producto.update_producto(6, "cantidad", "45");
		//Producto.create_producto("Morral", "", "Gris", "", 15.0, 32.0, 20);
		//Producto.read_tabla();
		//System.out.println(Producto.existe_producto(8));
		//Producto.delete_producto(7);
	}

}
