import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EJ_SelectHR {

	public static void main(String[] args) {
		String SQL_SELECT = "SELECT MIN(DEPARTMENTS.DEPARTMENT_NAME) DEPARTAMENTO, COUNT(EMPLOYEES.EMPLOYEE_ID) EMPLEADOS, NVL(SUM(SALARY+NVL(SALARY*COMMISSION_PCT, 0)),0) RETRIBUCION"
				+ " FROM DEPARTMENTS, EMPLOYEES WHERE DEPARTMENTS.DEPARTMENT_ID = EMPLOYEES.DEPARTMENT_ID(+)"
				+ " GROUP BY DEPARTMENTS.DEPARTMENT_ID ORDER BY DEPARTAMENTO";
		
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HR", "HR");
			Statement statement = conn.createStatement();
			){
			
			ResultSet resultSet = statement.executeQuery(SQL_SELECT);
			
			while (resultSet.next()) {
				String name = resultSet.getString("DEPARTAMENTO");
				long nempleados = resultSet.getLong("EMPLEADOS");
				BigDecimal retribucion = resultSet.getBigDecimal("RETRIBUCION");
				
				System.out.printf("%30s %3d %10.2f\n", name, nempleados, retribucion);
			}
			
		}catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
