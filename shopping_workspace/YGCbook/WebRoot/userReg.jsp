<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="co.jp.netwisdom.entity.UserInfoHobby" %>
<% List<UserInfoHobby> datas = (List<UserInfoHobby>)request.getAttribute("data"); %>


<html>
	<head>
	<title>用户注册页面</title>
	
	</head>
	
	
	<body>
		<form action="userRegister" method="post" >
				<br>
			<div align="center">
			<% if(datas != null) {%>
				<% for( UserInfoHobby uh : datas){%>
					姓名:<input type="text" name="username" id="username" value="<%=uh.getUsername()%>">
						<br>
					密码:<input type="password" name="password" id="password" value="<%=uh.getPassword()%>">
						<br>
						<br>
					性别:<input type="radio" name="sex" id="sex1" value="0" checked>男
						<input type="radio" name="sex" id="sex2" value="1">女
						<br>
						<br>
					爱好:<input type="checkbox" name="hobby" id="hobby1" value="0" <%if(uh.getHobby().contains("0")){%>checked<%} %>>足球
						<input type="checkbox" name="hobby" id="hobby2" value="1" <%if(uh.getHobby().contains("1")){%>checked<%} %>>篮球
						<input type="checkbox" name="hobby" id="hobby3" value="2" <%if(uh.getHobby().contains("2")){%>checked<%} %>>网球
						<br>
						<br>
					专业:<select name="major" id="major">
						<option value="0" <%if("0".equals(uh.getMajor())){%>selected<% } %>>软件工程</option>
						<option value="1" <%if("1".equals(uh.getMajor())){%>selected<% } %>>英语</option>
						<option value="2" <%if("2".equals(uh.getMajor())){%>selected<% } %>>数学</option>
						</select>
						<br>
						<br>
					简介:<br><textarea name="intro" id="intro" ><%=uh.getIntro() %></textarea>
						<br>
					<%}%>
				<%}%>	
				<input type="submit" value="注册用户">
				<input type="reset" value="重置">
				</div>
		</form>
	</body>
</html>