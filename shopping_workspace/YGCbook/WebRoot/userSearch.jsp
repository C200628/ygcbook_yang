



<html>
	<head>
	<title>调取数据库用户信息页面</title>
	<style type="text/css">
		th{
		width:100px;
		background-color:SkyBlue
		}
	
	</style>
	</head>
	
	<body>
		<form action="userSearch" method="post">
				<br>
				<div align="center">
					姓名:
						<input type="text" name="username" id="username">
						<br>
						<br>
					性别:
						<input type="radio" name="sex" id="sex1" value="0">男
						<input type="radio" name="sex" id="sex2" value="1">女
						<br>
						<br>
					专业:
						<select name="major" id="major">
						<option value="">-</option>
						<option value="0">软件工程</option>
						<option value="1">英语</option>
						<option value="2">数学</option>
						</select>
						<br>
						<br>
						<input type="submit" value="查询">
						<input type="reset" value="重置">  
				</div>
		</form>
			
				<br>
				<div align="center">查询信息一览</div>
				<hr>
				<div align="center">
					<table border="1" >
						<tr>
							<th>姓名</th>
							<th>性别</th>
							<th>爱好</th>
							<th>专业</th>
							<th>简介</th>
						</tr>
					</table>
				</div>
	</body>
</html>