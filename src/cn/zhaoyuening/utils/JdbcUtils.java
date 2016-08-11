package cn.zhaoyuening.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

import cn.zhaoyuening.domain.User;
/**
 * <b>jdbc开发工具类</b><br>
 * 快速链接数据库
 * @author Zhao
 * <hr>
 * 应该在代码src目录下写配置文件，保存数据库配置。<br>
 * 文件名：jdbc.properties<br>
 * 文件格式<br>
 * driver=com.mysql.jdbc.Driver<br>
 * url=jdbc:mysql:///testdb<br>
 * username=xxxx<br>
 * password=xxxx<br>
 */
public class JdbcUtils {
	private static Connection conn = null;
	private static String url;
	private static String username;
	private static String password;
	private static String driver;
	static{
		//获取jdbc配置
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		url = bundle.getString("url");
		username=bundle.getString("username");
		password=bundle.getString("password");
		driver=bundle.getString("driver");
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 返回与数据库的链接
	 * @return 与数据库的链接对象 
	 */
	public static Connection getConnection(){
		try{
			if(conn==null||conn.isClosed()){
				conn = DriverManager.getConnection(url, username, password);
			}
			return conn;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 关闭与数据库的连接
	 */
	public static void closeConnection(){
		try {
			if(conn==null){
				return ;
			}
			conn.close();
			conn=null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws SQLException {
		User user = new User();
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pst = conn.prepareStatement("select * from user where username=? and password=?");
		pst.setString(1,"admin");
		pst.setString(2, "20080808");
		ResultSet rs = pst.executeQuery();
		if(rs.next()){
			String email = rs.getString("email");
			Date date = rs.getDate("birth");
			int gender = rs.getInt("gender");
			user = new User();
			user.setBirth(date);
			user.setEmail(email);
			user.setPassword(password);
			user.setUsername(username);
			user.setGender(gender);
			System.out.println(email);
		}
	}
}
