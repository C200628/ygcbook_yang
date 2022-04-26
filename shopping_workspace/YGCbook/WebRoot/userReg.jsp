<html>
<head>
<title>课后练习题</title>

</head>


<body>
	<form action="userRegister" method="post" >
		<br>
		<div class="headImg" align="center">	
		姓名:<input type="text" name="username" id="username">
			<br>
		密码:<input type="password" name="password"id="password">
			<br>
			<br>
		性别:<input type="radio" name="sex" id="sex1" value="0" checked>男
			<input type="radio" name="sex" id="sex2" value="1">女
			<br>
			<br>
		爱好:<input type="checkbox" name="hobby" id="hobby1" value="0">足球
			<input type="checkbox" name="hobby" id="hobby2" value="1">篮球
			<input type="checkbox" name="hobby" id="hobby3" value="2">网球
			<br>
			<br>
		专业:<select name="major" id="major">
			<option value="0">软件工程</option>
			<option value="1">英语</option>
			<option value="2">数学</option>
			</select>
			<br>
			<br>
		简介:<br><textarea name="intro" id="intro">abcd</textarea>
			<br>
		
			<input type="submit" value="注册用户">
			<input type="button" value="重置">
			</div>
	</form>
</body>
</html>