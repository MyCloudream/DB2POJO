package cn.ucai.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLiteDBUtils {
	/**
	 * 得到对数据库的连接
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/sks/Desktop/superwechat_Database_V02-master/superwechat_v04.db");
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭所有数据库操作的相关资源
	 * @param conn
	 * @param ment
	 * @param rs
	 */
	public static void closeAll(Connection conn,PreparedStatement ps ,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
