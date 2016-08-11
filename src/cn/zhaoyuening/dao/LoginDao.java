package cn.zhaoyuening.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import cn.zhaoyuening.domain.User;
import cn.zhaoyuening.utils.JdbcUtils;

public class LoginDao {
	public static User findUser(User u){
		User user=null;
		
		String username = u.getUsername();
		String password = u.getPassword();
		//从数据库验证是否有该用户
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pst=null;
		try {
			pst = conn.prepareStatement("select * from user where username=? and password=?");
			pst.setString(1, username);
			pst.setString(2, password);
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
				return user;
			}
		} catch (SQLException e) {
			
		}finally{
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return user;
	}
}
