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

public class Ej_Select {

	public static void main(String[] args) {
		List<Empleado> result = new ArrayList<Empleado>();
		
		String SQL_SELECT = "Select * from EMP";
		
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			Statement statement = conn.createStatement();
			){
			
			ResultSet resultSet = statement.executeQuery(SQL_SELECT);
			
			while (resultSet.next()) {
				long id = resultSet.getLong("EMPNO");
				String name = resultSet.getString("ENAME");
				BigDecimal salario = resultSet.getBigDecimal("SAL");
				Timestamp fecha = resultSet.getTimestamp("HIREDATE");
				
				Empleado obj = new Empleado(id,name,salario,fecha.toLocalDateTime());
				
				result.add(obj);
			}
			
			result.forEach(System.out::println);
		}catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
