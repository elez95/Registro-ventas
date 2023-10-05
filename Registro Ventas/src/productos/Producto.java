package productos;

import java.sql.SQLException;

import conexion.DeleteCliente;
import conexionProducto.InsertProducto;

public class Producto {

	
	//private int id_cliente;
	//private String nombre_cliente;

	
	public void agregar_producto(String nombre_producto, String color, String detalle, int precio) {
		
		InsertProducto.insert_producto(nombre_producto, color, detalle, precio);
	
		
	}
	
	public void editar_producto() {}
	
	public void eliminar_producto(String nombre_cliente) {
		
		DeleteCliente.delete_cliente(nombre_cliente);
		
	}

	
	
	
	
	
	

	public static void main(String args []) throws SQLException {
		
		Producto p = new Producto();
		p.agregar_producto("Cartera", "verde", "marca Discovery", 25);
		
	}
	
}
