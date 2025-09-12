package ex1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;




public class Program {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC&useSSL=false";
		String sql = "SELECT * FROM NOTICE WHERE HIT > 10";
		
				
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,"root","doitmysql");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		
		
		while (rs.next()) {
			
				int id = rs.getInt("ID");
				String title = rs.getString("title");
				String wr_id = rs.getString("WRITER_ID");
				String content = rs.getString("CONTENT");
				Date refdate = rs.getDate("REGDATE");
				int hit = rs.getInt("HIT");
				 		
				System.out.printf("id :%d, title:%s,writerd:%s,regDate:%s,content:%s,hit:%d\n",id,title,wr_id,content,refdate,hit);
			}
		
		rs.close();
		st.close();
		con.close();
		
		
		
	}
}
