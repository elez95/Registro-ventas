package ventas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import conexion.Conexion;

public class Venta {
	
	//revisar que la cantidad de productos que se pretende comprar sea menor o igual a la cantidad del stock
	//una vez creada la compra se debe descontar el stock de ese producto
	public static void create_venta(int id_cliente, int id_producto, int cantidad) {
	
		Map<String, String> registroProducto = get_producto(id_producto);
		Map<String, String> registroCliente = get_cliente(id_cliente);
		
		String tipoProducto = registroProducto.get("tipoProducto");
		String nombreCliente = registroCliente.get("nombreCliente");
		//no se puede parsear null a string, verificar primero que no sea null, hacerlo con lun if y con un exception
		int stock = Integer.parseInt(registroProducto.get("cantidad")); 
		System.out.println(nombreCliente + " " + stock);
		
		//acá va la verificación de la cantidad de stock del producto frente a la cantidad deseada para vender	
		if(cantidad <= stock) {
			//aca se crea la venta y se descuenta el stock
		} else {
			//acá salta la exception que diga que no hay suficiente stock
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
	            registro.put("id", id);

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


	public static void main(String args[]) {
		
		Venta.create_venta(14, 6, 1);
		
	}
}
