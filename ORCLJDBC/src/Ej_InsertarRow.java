import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Ej_InsertarRow {

	private static final String SQL_INSERT = "INSERT INTO EMP (EMPNO, ENAME, SAL, HIREDATE) VALUES (?,?,?,?)";
	
	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT);
			){
			
			preparedStatement.setInt(1, 6666);
			preparedStatement.setString(2,  "Manuel");
			preparedStatement.setBigDecimal(3, new BigDecimal(3450.50));
			preparedStatement.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
			
			int row = preparedStatement.executeUpdate();
			
			System.out.println("Numero de filas insertadas: " + row);
			
		}catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
}
