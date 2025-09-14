package ex1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;




public class Program4 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String title = "test3";
		String content = "hahaha3";
		String files = "";
		int id = 1;
		
		String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC&useSSL=false";
		String sql = "DELETE FROM NOTICE WHERE ID = ?";
				
				
			
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,"root","doitmysql");
		PreparedStatement st =con.prepareStatement(sql);
		st.setInt(1, id);
		
		
		int result = st.executeUpdate();
		System.out.println(result);
	
		
		st.close();
		con.close();
		
		
		
	}
}
