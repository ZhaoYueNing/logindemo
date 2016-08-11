package cn.zhaoyuening.service;

import cn.zhaoyuening.dao.RegisterDao;
import cn.zhaoyuening.domain.User;

public class RegisterService {
	public static int rigisterUser(User user){
		return RegisterDao.registerUser(user);
	}
}
