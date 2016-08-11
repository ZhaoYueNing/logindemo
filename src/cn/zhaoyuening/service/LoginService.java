package cn.zhaoyuening.service;

import cn.zhaoyuening.dao.LoginDao;
import cn.zhaoyuening.domain.User;

public class LoginService {
	
	public static User loginUser(User u){
		return LoginDao.findUser(u);
	}
	
}
