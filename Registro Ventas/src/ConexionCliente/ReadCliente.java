package ConexionCliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.Conexion;

//import com.mysql.cj.xdevapi.Statement;

public class ReadCliente {
	
	public static void leerTabla() {
		Conexion c = new Conexion();
        try (Connection conexion = c.conectar();
             Statement statement = conexion.createStatement()) {

            // Ejecutar una consulta SQL para seleccionar todos los registros de la tabla
            String consultaSQL = "SELECT * FROM clientes";
            ResultSet resultado = statement.executeQuery(consultaSQL);

            // Recorrer el resultado y mostrar los datos
            while (resultado.next()) {
                // Reemplaza "columna1" y "columna2" con los nombres de las columnas de tu tabla
                String columna1 = resultado.getString("nombre");
                //String columna2 = resultado.getString("columna2");
                System.out.println("Columna1: " + columna1 );
            }

        } catch (SQLException e) {
            System.out.println("Error al leer la tabla");
            e.printStackTrace();
        }
    }

}
