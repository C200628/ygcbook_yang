<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="co.jp.netwisdom.entity.UserInfoHobby" %>
<% UserInfoHobby data = (UserInfoHobby)request.getAttribute("data"); %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>注册成功跳转页面</title>
	<meta http-equiv="refresh" content="5; url=userSearch.jsp"> <!--5秒后跳转检索界面-->
	</head>
		<body>
			<div align="center">
			<h1>当前操作执行成功！！！</h1>
			</div>
		</body>
</html>