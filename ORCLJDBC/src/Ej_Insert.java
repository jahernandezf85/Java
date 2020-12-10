import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ej_Insert {
	public static String cadena(long numero,String nombre, BigDecimal salario) {
		return "INSERT INTO EMP(EMPNO, ENAME, SAL, HIREDATE) VALUES ('" + numero + "','" + nombre + "','" + salario + "','" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "')";
	}
	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			Statement statement = conn.createStatement();
			){
			
			int row = statement.executeUpdate(cadena(1111, "Andrea", new BigDecimal(1200)));
			
			System.out.println("Numero de filas insertadas: " + row);
			
		}catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
