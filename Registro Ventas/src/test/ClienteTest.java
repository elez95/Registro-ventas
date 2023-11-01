package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import clientes.Cliente;

public class ClienteTest {
	
	@Test
	@DisplayName("Prueba para verificar que se controla que el campo es vacío y arroje exception")
    public void pruebaCreateClienteConCadenaVacia() {
        String nombreVacio = "";
        assertThrows(IllegalArgumentException.class, () -> Cliente.create_cliente(nombreVacio));
    }
	 @Test
	 @DisplayName("Intenta llamar a create_cliente con una cadena no vacía")
	    public void pruebaCreateClienteConCadenaNoVacia() {
	        String nombreNoVacio = "Ejemplo";
	        assertDoesNotThrow(() -> Cliente.create_cliente(nombreNoVacio));
	    }
}
