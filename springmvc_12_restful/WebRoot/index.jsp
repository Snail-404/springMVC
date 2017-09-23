<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>

	<form action="testPojo">
		username:<input type="text" name="userName"><br>
		password:<input type="password" name="passWord"><br>
		city:<input type="text" name="address.city"><br>
		province:<input type="text" name="address.province"><br>
		<input type="submit" value="提交"><br>
	</form>

	<a href="testCookie">test testCookie</a>
	<br>
	<br>
	<a href="testrequestHeader">test requestHeader</a>
	<br>
	<br>
	<a href="requestParam?userName=zhangsan&age=13">test requestParam</a>
	<br>
	<br>
	<form action="restful/33" method="post">
		<input type="hidden" name="_method" value="PUT"> <input
			type="submit" value="Test PUT">
	</form>

	<br>
	<br>
	<form action="restful/33" method="post">
		<input type="hidden" name="_method" value="DELETE"> <input
			type="submit" value="Test DELETE">
	</form>

	<br>
	<br>
	<form action="restful" method="post">
		<input type="submit" value="Test POST">
	</form>

	<br>
	<br>
	<a href="restful/33">Test GET</a>

	<br>
	<br>
	<br>
	<a href="testRest/33">点击</a>
</body>
</html>
