<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
div {
	position: absolute;
	left: 40%;
}
</style>

</head>

<body>
	<div>
		<h1>后台管理员登陆界面</h1>
		<span style="color: red; font-size: 15px;">${msg}</span>
		<form action="<c:url value='/admin/AdminLoginServlet'/>" method="post" target="_black">
			<input type="hidden" name="method" value="login" /> 
			用户名：<input type="text" name="username" value="${form.username}" /> <br /><br /> 
			密 码：<input type="password" name="password" value="${form.password}" /> <br /><br /> 
			<input type="submit" value="提交" /><br />
		</form>
	</div>
</body>
</html>
