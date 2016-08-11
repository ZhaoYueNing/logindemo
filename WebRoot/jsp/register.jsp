<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		//检查注册信息是否符合规范
		function check() {
			var username = document.register_form.username.value;
			var password = document.register_form.password.value;
			var password2 = document.register_form.password2.value;
			if(password!=password2){
				alert("两次密码输入不相同");
				return false;
			}
			if(username.length<8){
				alert("用户名长度必须大于8位");
				return false;
			}
			return true;
		}
	</script>

  </head>
  
  <body>
  	<!-- 用户名 密码 确认密码 邮箱 生日 性别 -->
    <h1>注册</h1>
    <hr><font color="red">${register_message}</font><br>
    <form method="post" onsubmit="return check()" action="register.do" name="register_form">
    	<table>
    		<tr><td>用户名：</td><td><input type="text" name="username"/></td></tr>
    		<tr><td>密&nbsp;码：</td><td><input type="text" name="password"/></td></tr>
    		<tr><td>重复密码:</td><td><input type="text" name="password2"/></td></tr>
    		<tr><td>邮箱:</td><td><input type="text" name="email"/></td></tr>
    		<tr><td>性别:</td><td> <input type="radio" value="1" name="gender"/>男
    					<input type="radio" value="0" name="gender">女</td>			    
    		</td></tr>
    		<tr><td colspan="2"><input type="submit" value="注册"></td></tr>
    	</table>
    </form>
  </body>
</html>
