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
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	/* $(function(){
		$("#userName").blur(function() {
		var userName=$("#userName").val();
		console.log("userName:"+userName);
		$.ajax({
			type:"post",
			url:"ajax.do",
			data:{"userName":userName},
			async:true,
			dataType:"text",
			success: function(data) {
				alert(data);
			},
			error: function(xhr, textState) {
				alert("数据请求失败");
			}
		});
	});
	}); */
	$(function() {
		$("#btn").click(
				function() {
					$.ajax({
						type : "post",
						url : "json.do",
						async : true,
						dataType : "json",
						success : function(data) {
							alert(data);
							var html = '';
							/* for ( var i = 0; i < data.length; i++) {
								html += "<tr><td>" + data[i].id + "</td><td>"
										+ data[i].userName + "</td><td>"
										+ data[i].age + "</td></tr>";
							}
							$("#tby").html(html); */
							$.each(data, function(i, n) {
								var otd = $("<tr><td>" + n.id + "</td><td>"
										+ n.userName + "</td><td>" + n.age
										+ "</td><tr>");
								$("#tby").append(otd);

							});
						},
						error : function(xhr, textState) {
							alert("数据请求失败");
						}
					});
				});
	});
</script>
</head>

<body>
	<!--  用户名：<input type="text" name="userName" id="userName"> -->
	<input type="button" value="获取数据" id="btn">
	<table width="60%" border="1px">
		<tr align="center">
			<th>id</th>
			<th>userName</th>
			<th>age</th>
		</tr>
		<tbody id="tby" align="center">
		</tbody>
	</table>
</body>
</html>
