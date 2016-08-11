package cn.zhaoyuening.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.zhaoyuening.domain.User;
import cn.zhaoyuening.utils.JdbcUtils;

public class RegisterDao {
	public static int registerUser(User user){
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("insert into user (username,password,email,gender,birth) values (?,?,?,?,?)");
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getEmail());
			pst.setInt(4, user.getGender());
			pst.setDate(5, new java.sql.Date(user.getBirth().getTime()));
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally{
			try{
				if(conn!=null){
					conn.close();
				}
				if(pst!=null){
					pst.close();
				}
			}catch(Exception e){
				
			}
		}
	}
	public static void main(String[] args) {
		User user = new User();
		user.setBirth(new java.sql.Date(1996,10,04));
		user.setEmail("610786189@qq.com");
		user.setPassword("20080808");
		user.setUsername("610786189");
		user.setGender(1);
		System.out.println(registerUser(user));
	}
}
