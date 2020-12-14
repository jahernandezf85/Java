import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clases.Empleado;

public class Ej_CreateTable {

	public static void main(String[] args) {
		List<Empleado> result = new ArrayList<Empleado>();
		
		String SQL_SELECT = "CREATE TABLE EMPLEADOX" +
				"(" +
				" ID INT AUTO_INCREMENT PRIMARY KEY," + 
				" NOMBRE VARCHAR(100) NOT NULL," +
				" SALARIO DECIMAL(15, 2) NOT NULL," + 
				" FECHA DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP" +
				")";
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?serverTimezone=UTC", "root", "root");
			Statement statement = conn.createStatement();
			){
			
			statement.execute(SQL_SELECT);
			
			
			result.forEach(System.out::println);
		}catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
