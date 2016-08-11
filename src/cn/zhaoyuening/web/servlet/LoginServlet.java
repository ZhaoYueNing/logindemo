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
		//�����get���� �� ֱ���ض��򵽵�¼����
		response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//��ȡ����
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		
		//��֤��¼
		User user = LoginService.loginUser(u);
		if(user==null){
			//��¼ʧ��
			request.setAttribute("login_message", "��¼ʧ�ܣ�������!");
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}else{
			//��¼�ɹ�
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/jsp/success.jsp");
		}
	}

}
