package banking.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils {
	private final String URL = "jdbc:mysql://localhost:3306/bankdb";
	private final String USER = "root";
	private final String PASSWORD = "password";
	private final String UPDATE = "update customer set balance = ? where name = ?";
	private final String SELECT = "select * from customer where name = ?";
	private int balance = 0;

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		//Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		return conn;
	}
	
	public void update(int bal, String name) {
		try(Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
			stmt.setInt(1, bal);
			stmt.setString(2, name);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int select(String name) {
		try(Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT)) {
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				balance = rs.getInt("balance");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return balance;
	}
}
