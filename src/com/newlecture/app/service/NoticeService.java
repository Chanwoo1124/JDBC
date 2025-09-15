package com.newlecture.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.app.entity.Notice;

public class NoticeService {
	private String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC&useSSL=false";
	private String uid = "root";
	private String password = "doitmysql";
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	public List<Notice> getList() throws ClassNotFoundException, SQLException{
		
		String sql = "SELECT * FROM NOTICE";
		
				
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		List<Notice> list = new ArrayList<Notice>();
		
		while (rs.next()) {
			
				int id = rs.getInt("ID");
				String title = rs.getString("title");
				String writer_id = rs.getString("WRITER_ID");
				String content = rs.getString("content");
				Date refdate = rs.getDate("REGDATE");
				int hit = rs.getInt("HIT");
				String files = rs.getString("files"); 
		
				Notice notice = new Notice(
									id,
									title,
									writer_id,
									content,
									refdate,
									hit,
									files
						);
				list.add(notice);
				
				
			}
			rs.close();
			st.close();
			con.close();
			
			return list;
		
	}

	
	public int insert(Notice notice) throws SQLException, ClassNotFoundException {
		
		String title = notice.getTitle();
		String writerId = notice.getWr_id();
		String content = notice.getContent();
		String files = notice.getFiles();
		
		
		String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC&useSSL=false";
		String sql =
			    "INSERT INTO notice (title, writer_id, content, files) " +
			    "VALUES (?,?,?,?)";

	
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,password);
		PreparedStatement st =con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, writerId);
		st.setString(3, content);
		st.setString(4, files);
		int result = st.executeUpdate();

		
		st.close();
		con.close();
		return result;
	}
	
	public int update (Notice notice) throws ClassNotFoundException, SQLException {
		String title = notice.getTitle();
		String content = notice.getContent();
		String files = notice.getFiles();
		int id = notice.getId();
		
		String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC&useSSL=false";
		String sql ="UPDATE NOTICE "+
					"SET TITLE = ?,"+
					"CONTENT=?,"+
					"files = ?"+
					"WHERE id = ?";
			    

	
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,password);
		PreparedStatement st =con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, files);
		st.setInt(4, id);
		
		
		int result = st.executeUpdate();
	
		
		st.close();
		con.close();
		
		return result;
		
	}
	public int delete (int id) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC&useSSL=false";
		String sql = "DELETE FROM NOTICE WHERE ID = ?";
				
				
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,password);
		PreparedStatement st =con.prepareStatement(sql);
		st.setInt(1, id);
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
	
		return result;
	}
}