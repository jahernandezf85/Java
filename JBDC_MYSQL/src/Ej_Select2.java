import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import clases.Empleado;

public class Ej_Select2 {

	public static void main(String[] args) {
		
		
		String SQL_SELECT = "SELECT nombre_Espa, precio_unidad from productos where productos.nombre_espa like \"%cerveza%\"";
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/almacen", "root", "root");
			Statement statement = conn.createStatement();
			){
			
			ResultSet resultSet = statement.executeQuery(SQL_SELECT);
			
			while (resultSet.next()) {
				
				String name = resultSet.getString("nombre_Espa");
				BigDecimal precio = resultSet.getBigDecimal("precio_unidad");

				System.out.println(name + " " + precio);
				
			}
			
		}catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
