import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Ej_BatchUpdate {
	private static final String SQL_CREATE = "CREATE TABLE EMPLEADOS" + 
			"(" + 
			" ID INT NOT NULL AUTO_INCREMENT," + 
			" NOMBRE VARCHAR(100) NOT NULL," + 
			" SALARIO DECIMAL(15, 2) NOT NULL," + 
			" FECHA DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP," + 
			" PRIMARY KEY (ID)" + 
			")";
	    private static final String SQL_DROP = "DROP TABLE IF EXISTS EMPLEADOS";

	    private static final String SQL_INSERT = "INSERT INTO EMPLEADOS (NOMBRE, SALARIO, FECHA) VALUES (?,?,?)";

	    private static final String SQL_UPDATE = "UPDATE EMPLEADOS SET SALARIO=? WHERE NOMBRE=?";

	
		
    public static void main(String[] args) {

    	 try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?serverTimezone=UTC", "root", "root");
         		         PreparedStatement pc = conn.prepareStatement(SQL_CREATE);
    		             PreparedStatement pi = conn.prepareStatement(SQL_INSERT);
    		             PreparedStatement pu = conn.prepareStatement(SQL_UPDATE)) {

    		            conn.setAutoCommit(false); 
    		            pc.execute();

    		            pi.setString(1, "Carlos");
    		            pi.setBigDecimal(2, new BigDecimal(10));
    		            pi.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
    		            pi.addBatch();

    		            pi.setString(1, "IGNACIO");
    		            pi.setBigDecimal(2, new BigDecimal(20));
    		            pi.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
    		            pi.addBatch();

    		            pi.setString(1, "ELENA");
    		            pi.setBigDecimal(2, new BigDecimal(30));
    		            pi.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
    		            pi.addBatch();

    		            int[] rows = pi.executeBatch();

    		            System.out.println(Arrays.toString(rows));

    		            pu.setBigDecimal(1, new BigDecimal(999.99));
    		            pu.setString(2, "IGNACIO");
    		            pu.addBatch();

    		            pu.setBigDecimal(1, new BigDecimal(888.88));
    		            pu.setString(2, "Carlos");
    		            pu.addBatch();

    		            int[] rows2 = pu.executeBatch();

    		            System.out.println(Arrays.toString(rows2));

    		            conn.commit();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

   

}