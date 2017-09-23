<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testJson.jsp' starting page</title>
    
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
  				alert("aaaaaaaaa");
  				$.post(url,args,function(data){
  					
  					for(var i=0;i<data.length;i++){
  						var id=data[i].id;
  						var userName=data[i].userName;
  						alert(id+"--"+userName);
  					}
  				});
  				return false;
  			});
  		});
  	</script>
  </head>
  
  <body>
    <a id="testJson" href="json.do">test Json</a>
  </body>
</html>
