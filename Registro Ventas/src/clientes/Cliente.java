package clientes;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import conexion.Conexion;

public class Cliente {


	public static void create_cliente(String nombre) {
		
		if(nombre != null) {
			nombre = nombre.replaceAll("\\s", ""); //esto esta mal porque no debe guardarse el nombre sin espacios, solo debe usarse para comparar
			if(nombre != "" || nombre == null) {
				Conexion conexion = new Conexion();
				Connection cn = null;
				cn = conexion.conectar();

				String insertQuery = "insert into clientes (nombre) values(?);";

				try (Connection connection = cn;
						PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

					// Setear los valores de las columnas
					preparedStatement.setString(1, nombre);

					// Ejecutar la inserción
					int rowsInserted = preparedStatement.executeUpdate();
					if (rowsInserted > 0) {
						System.out.println("Creacion de cliente exitosa, " + rowsInserted + " columna/s afectadas");
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			else {
				throw new IllegalArgumentException("No puede tener el campo nombre vacio");
			}
		} else {
			throw new IllegalArgumentException("El campo es null");
		}
	}

	public static void read_tabla() {
		
		Conexion c = new Conexion();
		try (Connection conexion = c.conectar();
				Statement statement = conexion.createStatement()) {

			// Ejecutar una consulta SQL para seleccionar todos los registros de la tabla
			String consultaSQL = "SELECT * FROM clientes";
			ResultSet resultado = statement.executeQuery(consultaSQL);

			// Recorrer el resultado y mostrar los datos
			while (resultado.next()) {
				// Reemplaza "columna1" y "columna2" con los nombres de las columnas de tu tabla
				String nombreCliente = resultado.getString("nombre");
				int idCliente = resultado.getInt("id");
				System.out.println("Id: " + idCliente + " Nombre: " + nombreCliente );
			}

		} catch (SQLException e) {
			System.out.println("Error al leer la tabla");
			e.printStackTrace();
		}
	}

	
	// Método para actualizar un registro por su ID y nuevo nombre
	public static void update_cliente(int id, String nuevoNombre) {

		if(existe_cliente(id)) {
			String sentenciaSQL = "UPDATE clientes SET nombre = ? WHERE id = ?";
			Conexion c = new Conexion();
			try (Connection conexion = c.conectar();
					PreparedStatement preparedStatement = conexion.prepareStatement(sentenciaSQL)) {

				// Establece los parámetros en la sentencia SQL
				preparedStatement.setString(1, nuevoNombre);
				preparedStatement.setInt(2, id);

				// Ejecuta la sentencia SQL de actualización
				int filasAfectadas = preparedStatement.executeUpdate();

				// Imprime el número de filas afectadas por la actualización
				System.out.println("Filas afectadas: " + filasAfectadas);
			} catch (SQLException e) {
				System.out.println("Error al ejecutar la sentencia SQL de actualización");
				e.printStackTrace();
			}
		} else {
			throw new IllegalArgumentException("El id ingresado no pertenece a ningún cliente");
		}
	}
	

    public static void delete_cliente(int id) {

    	Conexion conexion = new Conexion();
    	if(existe_cliente(id)) {
    		Connection cn = null;
    		cn = conexion.conectar();

    		String deleteQuery = "DELETE from clientes WHERE id = '" + id + "';";

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
    		throw new IllegalArgumentException("no existe el cliente con el id " + id);
    	}
    }
	
	public static boolean existe_cliente(int id) {
		Conexion c = new Conexion();
		int idCliente = 0;
		try (Connection conexion = c.conectar();
				Statement statement = conexion.createStatement()) {

			// Ejecutar una consulta SQL para seleccionar todos los registros de la tabla
			String consultaSQL = "SELECT * FROM clientes where id = '" + id + "';";
			ResultSet resultado = statement.executeQuery(consultaSQL);

			while (resultado.next()) {
				idCliente = resultado.getInt("id");
			}

		} catch (SQLException e) {
			System.out.println("Error al leer la tabla");
			e.printStackTrace();
		}
		if (idCliente == 0) {
			return false;
		}
		return true;
	}

	public static void main(String args []) throws SQLException {


		//Cliente.create_cliente("Victoria");
		//Cliente.delete_cliente(32);
		//Cliente.update_cliente(11, "Palandri");
		//Cliente.read_tabla();
		System.out.println(Cliente.existe_cliente(10));

	}

}
