<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index1.jsp' starting page</title>
    
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
  	<a href="contro/testMyView">test testMyView</a>
  	<br>
  	<form action="contro/testModelAttribute" method="post">
  		<input type="hidden" name="id" value="1">
  		name:<input type="text" name="name" value="dkl">
		age:<input type="text" name="age" value="33">
		<input type="submit" value="submit">
  	</form>
  	<a href="contro/testSessionAttribute">test SessionAttribute</a>
  	<br>
    <a href="contro/testMap">test map</a>
  </body>
</html>
