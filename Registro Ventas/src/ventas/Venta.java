package ventas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import conexion.Conexion;

public class Venta {
	
	//revisar que la cantidad de productos que se pretende comprar sea menor o igual a la cantidad del stock
	//una vez creada la compra se debe descontar el stock de ese producto
	public static void create_venta(int id_cliente, int id_producto, int cantidad) {
	
		Map<String, String> registroProducto = get_producto(id_producto);
		Map<String, String> registroCliente = get_cliente(id_cliente);
		
		if(registroProducto.get("idProducto") != null) {
			if(registroCliente.get("id") != null) {
				int idProducto = Integer.parseInt(registroProducto.get("idProducto"));
				int idCliente = Integer.parseInt(registroCliente.get("id"));
				String tipoProducto = registroProducto.get("tipoProducto");
				String nombreCliente = registroCliente.get("nombreCliente");
				String marca = registroProducto.get("marca");
				LocalDate fechaActual = LocalDate.now();
				//no se puede parsear null a string, verificar primero que no sea null, hacerlo con lun if y con un exception
				int stock = Integer.parseInt(registroProducto.get("cantidad")); 
				System.out.println(nombreCliente + " " + stock);
				
				//verificar que exista el cliente (posiblemente hacerlo en la clase cliente)
				
				//verificar que exista el producto (posiblemente hacerlo en la clase producto)
				
				//acá va la verificación de la cantidad de stock del producto frente a la cantidad deseada para vender	
				if(cantidad <= stock) {
					//falta obtener la fecha para setear
					insert_venta(idProducto, idCliente, nombreCliente, tipoProducto, marca, fechaActual, cantidad);
					
					System.out.println("Fecha actual: " + fechaActual);
					System.out.println("hola");
				} else {
					System.out.println("else");
					//acá salta la exception que diga que no hay suficiente stock
				}
			} else {
				System.out.println("El id del cliente es null");
			}
		} else {
			System.out.println("El id del producto es null");
		}
		
	
		
	}
	
	public static void read_tabla() {}
	
	
	//revisar cuando se pasa un id que no existe
	private static Map<String,String> get_cliente(int id_cliente){
		Map<String, String> registro = new HashMap<>();
		
		Conexion c = new Conexion();
	    try (Connection conexion = c.conectar();
	         PreparedStatement preparedStatement = conexion.prepareStatement("SELECT * FROM clientes WHERE id = ?")) {

	        preparedStatement.setInt(1, id_cliente); // Establece el valor del parámetro

	        ResultSet resultado = preparedStatement.executeQuery();

	        if (resultado.next()) { // Mueve el cursor a la primera fila (debería ser la única)
	            String id = String.valueOf(resultado.getInt("id"));
	            registro.put("id", id);

	            String nombreCliente = resultado.getString("nombre");
	            registro.put("nombreCliente", nombreCliente);
	            	
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al leer la tabla");
	        e.printStackTrace();
	    }
		
		return registro;
	}
	
	//revisar cuando se pasa un id que no existe
	private static Map<String, String> get_producto(int id_producto) {
	    Map<String, String> registro = new HashMap<>();

	    Conexion c = new Conexion();
	    try (Connection conexion = c.conectar();
	         PreparedStatement preparedStatement = conexion.prepareStatement("SELECT * FROM producto WHERE idProducto = ?")) {

	        preparedStatement.setInt(1, id_producto); // Establece el valor del parámetro

	        ResultSet resultado = preparedStatement.executeQuery();

	        if (resultado.next()) { // Mueve el cursor a la primera fila (debería ser la única)
	            String id = String.valueOf(resultado.getInt("idProducto"));
	            registro.put("idProducto", id);

	            String producto = resultado.getString("tipoProducto");
	            registro.put("tipoProducto", producto);
	            
	            String marca = resultado.getString("marca");
	            registro.put("marca", marca);
	            
	            String color = resultado.getString("color");
	            registro.put("color", color);
	            
	            String detalle = resultado.getString("detalle");
	            registro.put("detalle", detalle);
	            
	            String precioCompra = String.valueOf(resultado.getDouble("precioCompra"));
	            registro.put("precioCompra", precioCompra);
	            
	            String precioVenta = String.valueOf(resultado.getDouble("precioVenta"));
	            registro.put("precioVenta", precioVenta);
	            
	            String cantidad = String.valueOf(resultado.getInt("cantidad"));
	            registro.put("cantidad", cantidad);
	            	
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al leer la tabla");
	        e.printStackTrace();
	    }
	    return registro;
	}
	
	private static void insert_venta(int idProducto, int idCliente, String nombreCliente, String tipoProducto, String marca, LocalDate fechaVenta, int cantidadVendida) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		cn = conexion.conectar();

		String insertQuery = "insert into venta (idProducto, idCliente, nombreCliente, tipoProducto, marca, fechaVenta, cantidadVendida) values(?,?,?,?,?,?,?);";

		try (Connection connection = cn;
				PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

			// Setear los valores de las columnas
			preparedStatement.setInt(1, idProducto);
			preparedStatement.setInt(2, idCliente);
			preparedStatement.setString(3, nombreCliente);
			preparedStatement.setString(4, tipoProducto);
			preparedStatement.setString(5, marca);
			preparedStatement.setDate(6, Date.valueOf(fechaVenta));
			preparedStatement.setInt(7, cantidadVendida);
			

			// Ejecutar la inserción
			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Inserción exitosa, " + rowsInserted + " columna/s afectadas");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}


	public static void main(String args[]) {
		
		Venta.create_venta(15, 6, 1);
		
	}
}
