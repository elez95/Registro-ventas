package conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConexion {
	
	public static void main(String[] args) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement(); //sirve para crear sentencias sql
			//rs = stm.executeQuery("Select * from tabla1;");
			rs = stm.executeQuery("insert into tabla1 values('Samuel',43,3);");
			
			while(rs.next()) {
				int id        = rs.getInt(3);
				String nombre = rs.getString(1);
				int edad      = rs.getInt(2);
				
				System.out.println(id +" " + nombre + " "+ edad);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!= null) {
					rs.close();
				}
				
				if(stm != null) {
					stm.close();
				}
				if(cn != null) {
					cn.close();
				}
				
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
