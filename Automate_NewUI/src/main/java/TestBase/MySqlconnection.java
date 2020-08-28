package TestBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlconnection {

	private static MySqlconnection MysqlInstance = null;
	
	private MySqlconnection() {
		
	}
	
	public static Connection  ConnectToDB() {
		
		Connection conn =null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://10.11.36.10:3306/vrm", "adserv_stage", "adstage");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return conn;
	}
	
	public static MySqlconnection getMysqlinstance() {
		
		if (MysqlInstance==null) {
			MysqlInstance = new MySqlconnection();
		}
		
		return MysqlInstance;
	}
}
