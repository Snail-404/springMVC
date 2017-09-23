<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
  <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
  <script type="text/javascript">
  		$(function(){
  			$("#testJson").click(function(){
  				var url=this.href;
  				var args={};
  				$.post(url,args,function(data){
  					for(var i=0;i<data.length;i++){
  						var id=data[i].id;
  						var lastName=data[i].lastName;
  						
  						alert(id+"--"+lastName);
  					}
  				});
  				return false;
  			});
  		});
  	</script>
  	</head>
  <body>
  	<a href="emps">查看</a>
  	<br>
  	<a id="testJson" href="testJson">test Json</a>
  	<br>
  	<a href="i18n1">i18n1</a>
  
</html>
