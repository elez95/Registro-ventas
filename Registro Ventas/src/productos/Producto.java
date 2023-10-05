package productos;

import java.sql.SQLException;

import conexionProducto.DeleteProducto;
import conexionProducto.InsertProducto;

public class Producto {

	
	public void agregar_producto(String nombre_producto, String color, String detalle, int precio) {
		
		InsertProducto.insert_producto(nombre_producto, color, detalle, precio);
	
		
	}
	
	public void editar_producto() {}
	
	public void eliminar_producto(int id_producto) {
		
		DeleteProducto.delete_producto(id_producto);
		
	}


	

	public static void main(String args []) throws SQLException {
		
		Producto p = new Producto();
		p.agregar_producto("Cartera", "verde", "marca Discovery", 25);
		
	}
	
}
