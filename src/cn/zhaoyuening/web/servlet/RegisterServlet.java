package cn.zhaoyuening.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zhaoyuening.domain.User;
import cn.zhaoyuening.service.RegisterService;
@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect(request.getContextPath()+"/jsp/register.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取参数
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setEmail(request.getParameter("email"));
		user.setBirth(new Date());
		user.setGender(Integer.parseInt(request.getParameter("gender")));
		user.setPassword(request.getParameter("password"));
		//注册操作
		int registerCount = RegisterService.rigisterUser(user);
		//处理注册结果
		if(registerCount>0){
			//注册成功，返回登陆界面
			request.getSession().setAttribute("login_message", "注册成功，请登录!");
			response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
		}else{
			//注册失败,返回注册页面
			request.setAttribute("register_message", "注册失败，用户名或邮箱已被注册，请重试!");
			request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
		}
	}

}
