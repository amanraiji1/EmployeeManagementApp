import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
	Connection c;
	Statement s;
	public Conn() {
		try {
			//Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			

			//create the connection
			String user = "root";
			String password = "amanrai@123";
			String url = "jdbc:mysql://localhost:3306/employeemanagementsystem";
			c = DriverManager.getConnection(url,user,password);
			s = c.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
