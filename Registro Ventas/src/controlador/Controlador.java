package controlador;

import clientes.Cliente;
import graficos.VentanaIngresarProducto;
import graficos.VentanaPrincipal;

public class Controlador {
	

	
	public static void main(String [] args) {
		
		VentanaPrincipal principal = new VentanaPrincipal();
		principal.setVisible(true);
		principal.setLocationRelativeTo(null);	
	}
	
	public void ingresarCliente(String nombreCliente) {
		Cliente.create_cliente(nombreCliente);
	}

}
