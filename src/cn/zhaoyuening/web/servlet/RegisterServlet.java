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

		//��ȡ����
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setEmail(request.getParameter("email"));
		user.setBirth(new Date());
		user.setGender(Integer.parseInt(request.getParameter("gender")));
		user.setPassword(request.getParameter("password"));
		//ע�����
		int registerCount = RegisterService.rigisterUser(user);
		//����ע����
		if(registerCount>0){
			//ע��ɹ������ص�½����
			request.getSession().setAttribute("login_message", "ע��ɹ������¼!");
			response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
		}else{
			//ע��ʧ��,����ע��ҳ��
			request.setAttribute("register_message", "ע��ʧ�ܣ��û����������ѱ�ע�ᣬ������!");
			request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
		}
	}

}
