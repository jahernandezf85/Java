import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ej_Delete {

	public static String cadena(String nombre) {
		return "DELETE FROM EMP WHERE ENAME = '" + nombre + "'";
	}
	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			Statement statement = conn.createStatement();
			){
			
			int row = statement.executeUpdate(cadena("Andrea"));
			
			System.out.println("Numero de filas eliminadas: " + row);
			
		}catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
