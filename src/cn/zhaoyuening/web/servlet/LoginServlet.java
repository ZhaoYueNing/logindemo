package cn.zhaoyuening.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zhaoyuening.domain.User;
import cn.zhaoyuening.service.LoginService;
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//如果是get请求 ， 直接重定向到登录界面
		response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		
		//验证登录
		User user = LoginService.loginUser(u);
		if(user==null){
			//登录失败
			request.setAttribute("login_message", "登录失败，请重试!");
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}else{
			//登录成功
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/jsp/success.jsp");
		}
	}

}
