<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="co.jp.netwisdom.dao.UserInfoDAO"%>
<%@ page import="co.jp.netwisdom.entity.UserInfoHobby" %>
<% List<UserInfoHobby> datas = (List<UserInfoHobby>)request.getAttribute("data"); %>




<html>
	<head>
	<title>调取数据库用户信息页面</title>
	<style type="text/css">
		
		th{
			width:100px;
			background-color:SkyBlue;
		}
		#td1{
			width:100px;
			background-color:#ccc8aa;
		}
		
		body {
			text-align:center;
		}
		table {
			text-align:center;
			width:100%;
		}
		
		
		
		
	</style>
	</head>
	
	<body>
		<form action="userSearch.do" method="post">
				<br/>
				<div align="center">
			
					姓名:
						<input type="text" name="username" id="username" >
			
						<br/>
						<br/>
					性别:
						<input type="radio" name="sex" id="sex1" value="0">男
						<input type="radio" name="sex" id="sex2" value="1">女
						<br/>
						<br/>
					专业:
						<select name="major" id="major">
						<option value="">-</option>
						<option value="0">软件工程</option>
						<option value="1">英语</option>
						<option value="2">数学</option>
						</select>
						<br/>
						<br/>
						<input type="submit" value="查询">
						<input type="reset" value="重置">  
				</div>
		</form>
			
		<br/>
		<div align="center">查询信息一览</div>
		<hr>
		<table border="1" align="center">
			<tr>
				<th>姓名</th>
				<th>密码</th>
				<th>性别</th>
				<th>爱好</th>
				<th>专业</th>
				<th>简介</th>
				
			</tr>
			<% if(datas!= null) {%>
				<% for( UserInfoHobby uh : datas){%>
					<tr>
						<td bgcolor="#eee8aa" ><a href="userUpdateInit.do?username=<%=uh.getUsername()%>"><%=uh.getUsername()%></a></td>
						<td bgcolor="#ccc8aa" ><%=uh.getPassword()%></td>
						<td bgcolor="#ffdab9" ><%=uh.getSex().replace("0","男").replace("1","女")%></td>
						<td bgcolor="#88cdaa" ><%=uh.getHobby().replace("0","足球").replace("1","篮球").replace("2","网球")%></td>
						<td bgcolor="#aaa0dd" ><%=uh.getMajor().replace("0","软件工程").replace("1","英语").replace("2","数学")%></td>
						<td bgcolor="#ee7f50" ><%=uh.getIntro()%></td>
						<!-- <td id="td1" ><input type="submit" value="删除"></td>  未实装 -->
					</tr>
				<%}%>
			<%}%> 
			
		</table>
	</body>
</html>