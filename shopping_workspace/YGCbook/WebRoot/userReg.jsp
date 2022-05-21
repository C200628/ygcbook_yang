<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page import="co.jp.netwisdom.entity.UserInfoHobby" %>
<% UserInfoHobby data = (UserInfoHobby)request.getAttribute("data"); %>


<html>
	<head>
	<title>用户注册页面</title>
	<script>
	    function changeActionName(actionName) {
	        document.getElementById("form").action = actionName;
	        document.getElementById("username").disabled = false;  
	    }
	    //alert("数据加载成功");
		function executeAjax() {
			   $.ajax({
			    url : 'checkName.do?username=' + document.getElementById("username").value,
			    type : 'post', // 数据发送方式
			    dataType : 'text', // 接受数据格式
				    error : function(flag) {},
				    async : true,// 异步加载
				    success : function(flag) {
				    	if(flag == 0){
				    		document.getElementById("flag").innerHTML='';
				    	}else{
				    		alert("该用户已被注册！！")
				    	}
				    	
				    }  
			   });
		 }
	</script>
	<script src="jquery-3.2.1.min.js">

	</script>
	</head>
	
	<body>
	<% if(data != null) {%>
		<form action="updateReg" id="form" method="post" >
			<br/>
			<div align="center">
					<bean:message bundle="userResources" key="username"/>:
						<input type="text" disabled name="username" id="username" value="<%=data.getUsername()%>"/>
					<br/>
					<bean:message bundle="userResources" key="password"/>:
						<input type="password" name="password" id="password" value="<%=data.getPassword()%>"/>
					<br/>
					<br/>
					<bean:message bundle="userResources" key="sex"/>:
						<input type="radio" name="sex" id="sex1" value="0" checked <%if("0".equals(data.getSex())){%>checked<% } %>/><bean:message bundle="userResources" key="male"/>
						<input type="radio" name="sex" id="sex2" value="1"<%if("1".equals(data.getSex())){%>checked<% } %>/><bean:message bundle="userResources" key="female"/>
					<br/>
					<br/>
					<bean:message bundle="userResources" key="hobby"/>:
						<input type="checkbox" name="hobby" id="hobby1" value="0" <%if(data.getHobby().contains("0")){%>checked<%} %>/><bean:message bundle="userResources" key="football"/>
						<input type="checkbox" name="hobby" id="hobby2" value="1" <%if(data.getHobby().contains("1")){%>checked<%} %>/><bean:message bundle="userResources" key="basketball"/>
						<input type="checkbox" name="hobby" id="hobby3" value="2" <%if(data.getHobby().contains("2")){%>checked<%} %>/><bean:message bundle="userResources" key="tennis"/>
					<br/>
					<br/>
					<bean:message bundle="userResources" key="major"/>:
						<select name="major" id="major">
							<option value="0" <%if("0".equals(data.getMajor())){%>selected<% } %>><bean:message bundle="userResources" key="software"/></option>
							<option value="1" <%if("1".equals(data.getMajor())){%>selected<% } %>><bean:message bundle="userResources" key="english"/></option>
							<option value="2" <%if("2".equals(data.getMajor())){%>selected<% } %>><bean:message bundle="userResources" key="math"/></option>
						</select>
					<br/>
					<br/>
					<bean:message bundle="userResources" key="intro"/>:
					<br/>
					<textarea name="intro" id="intro" ><%=data.getIntro() %></textarea>
					<br/>
					
					<input type="submit"  value="<bean:message bundle="userResources" key="updateReg"/>" onclick="changeActionName('updateReg.do')" />
            		<input type="submit"  value="<bean:message bundle="userResources" key="deldateReg"/>" onclick="changeActionName('deldateReg.do')" /> 
					<input type="reset" value="<bean:message bundle="userResources" key="reset"/>">
				</div>
			</form>	
			
			<%} else {%>
			<form action="userRegister.do" method="post" >
				<div align="center">
					<bean:message bundle="userResources" key="username"/>:<input type="text" onblur="executeAjax()" name="username" id="username"value=""/>
					<font color="red" id="flag"></font>
					<br/>
					<bean:message bundle="userResources" key="password"/>:<input type="password" name="password" id="password"/>
					<br/>
					<br/>
					<bean:message bundle="userResources" key="sex"/>:<input type="radio" name="sex" id="sex1" value="0" checked/><bean:message bundle="userResources" key="male"/>
						<input type="radio" name="sex" id="sex2" value="1"/><bean:message bundle="userResources" key="female"/>
					<br/>
					<br/>
					<bean:message bundle="userResources" key="hobby"/>:
						<input type="checkbox" name="hobby" id="hobby1" value="0" /><bean:message bundle="userResources" key="football"/>
						<input type="checkbox" name="hobby" id="hobby2" value="1" /><bean:message bundle="userResources" key="basketball"/>
						<input type="checkbox" name="hobby" id="hobby3" value="2" /><bean:message bundle="userResources" key="tennis"/>
					<br/>
					<br/>
					<bean:message bundle="userResources" key="major"/>:
						<select name="major" id="major">
							<option value="0" selected><bean:message bundle="userResources" key="software"/></option>
							<option value="1"><bean:message bundle="userResources" key="english"/></option>
							<option value="2"><bean:message bundle="userResources" key="math"/></option>
						</select>
					<br/>
					<br/>
					<bean:message bundle="userResources" key="intro"/>:<br/><textarea name="intro" id="intro" >abcd</textarea>
					<br/>
					<br/>
					<input type="submit" value="<bean:message bundle="userResources" key="userRegister"/>">
					<input type="reset"  value="<bean:message bundle="userResources" key="reset"/>">
				<%}%>
			</div>	
		</form>
	</body>
</html>