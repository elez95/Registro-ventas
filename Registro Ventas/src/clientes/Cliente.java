package clientes;


import java.sql.SQLException;

import ConexionCliente.DeleteCliente;
import ConexionCliente.InsertCliente;
import ConexionCliente.ReadCliente;

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

	public void leer_clientes() {
		ReadCliente.leerTabla();
	}
	
	
	
	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public int getId_cliente() {
		return id_cliente;
	}
	
	

	public static void main(String args []) throws SQLException {
		
		Cliente c = new Cliente();
		c.agregar_Cliente("Milei");
		c.leer_clientes();
		//c.eliminar_Cliente("Lucas");
		
	}
	
}
