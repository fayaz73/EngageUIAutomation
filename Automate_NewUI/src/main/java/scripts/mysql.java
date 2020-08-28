package scripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class mysql {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://10.11.36.24:3306/vrm", "adserv_stage", "adstage");
		 Statement st = conn.createStatement();
		 
		 ResultSet rs = st.executeQuery("select RateLimit,IsTFAEnabled from OAuthUser where Email like 'fayaz.ahamed@vizurycn.com'");
		 
		// PreparedStatement preparedStatement = conn.prepareStatement("");
		// preparedStatement.executeUpdate("update OAuthUser set IsTFAEnabled = 0 where Email like 'fayaz.ahamed73@gmail.com'");
		 
		 while(rs.next()) {
			 System.out.println(rs.getInt("RateLimit")+"::::"+ rs.getInt("IsTFAEnabled"));
		 }
		 
	}

}
