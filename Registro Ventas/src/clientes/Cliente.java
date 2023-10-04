package clientes;


import java.sql.SQLException;

import conexion.DeleteCliente;
import conexion.InsertCliente;

public class Cliente {

	
	private int id_cliente;
	private String nombre_cliente;
	
	
	
	
	
	public void agregar_Cliente(String nombre_cliente) {
		
		InsertCliente.insert_cliente(nombre_cliente);
	
		
	}
	
	public void editar_Cliente() {}
	
	public void eliminar_Cliente(String nombre_cliente) {
		
		DeleteCliente.delete_cliente(nombre_cliente);
		
	}

	
	
	
	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public int getId_cliente() {
		return id_cliente;
	}
	
	

	public static void main(String args []) throws SQLException {
		
		Cliente c = new Cliente();
		//c.agregar_Cliente("Juan");
		c.eliminar_Cliente("Lucas");
		
	}
	
}
