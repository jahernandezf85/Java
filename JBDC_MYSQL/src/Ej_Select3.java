import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ej_Select3 {

	public static void main(String[] args) {
		String SQL_SELECT = "SELECT PROD.NOMBRE_ESPA PRODUCTO, CAT.NOMBRE_CATE CATEGORIA, PROV.NOMBRE PROVEEDOR"
				+ " FROM PRODUCTOS PROD INNER JOIN CATEGORIAS CAT ON PROD.CATID = CAT.CATID"
				+ " INNER JOIN PROVEEDORES PROV ON PROD.PROVID = PROV.PROVID"
				+ " ORDER BY CATEGORIA, PROVEEDOR";
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/almacen", "root", "root");
			Statement statement = conn.createStatement();
			){
			
			ResultSet resultSet = statement.executeQuery(SQL_SELECT);
			
			while (resultSet.next()) {
				
				String nombre = resultSet.getString("producto");
				String categoria = resultSet.getString("categoria");
				String proveedor = resultSet.getString("proveedor");
				System.out.printf("%-20s %-20s %-40s\n", categoria, proveedor, nombre);
				
				
			}
			
		}catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
