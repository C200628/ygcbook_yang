<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page import="java.util.List"%>
<%@ page import="co.jp.netwisdom.entity.UserInfoHobby" %>
<% List<UserInfoHobby> data = (List<UserInfoHobby>)request.getAttribute("data"); %>


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
	<script>
	
	    function userUpdate(username){
	    	window.location="userUpdateInit.do?username=" + username;
	    }
	    
	    function deleteUser(username){
	    	window.location="deldateReg.do?username=" + username;
	    }
	    
        function delAll() {
        	var checkboxs = document.getElementsByName("check");
        	var check = false;
            for (var i = 0; i < checkboxs.length; i++) {
               	if (document.getElementById("AllCheckbox").checked){
                    check = true;
                }
               	checkboxs[i].checked = check;
            }
        }
	    	
        function delAllAction(actionName) {
        	document.getElementById("form").action = 'delAllUser.do';
        	
	    }
        
        
		function executeAjax() {
			
			   var sex;
			   if(document.getElementsByName("sex")[0].checked){
				   sex = 0;
			   }else{
				   sex = 1;
			   }
			   var major = document.getElementById("major").value; 
			   $.ajax({
			    url:'userNameSearch.do?sex='+ sex +'&major='+ major +'&username='+ document.getElementById("username").value,
			    type:'post', // 数据发送方式
			    dataType:'json', // 接受数据格式
				error: function(e) {
					console.log(e);
				},
				async: true,// 异步加载
				success: function(users) { 
				    while($("#userTable tr").length>1){
				    	$("#userTable tr").eq(1).remove();
				    }
				    	
				    for(var i = 0;i < users.datas.length; i++){
				    	username = users.datas[i].username;
			   			password = users.datas[i].password;
			   				sex = users.datas[i].sex;
			   				if(sex == 0){
			   					sex = "男";
			   				}else{
			   					sex = "女";
			   				}
			   				hobby = users.datas[i].hobby.replace("0","足球").replace("1","篮球").replace("2","网球");
			   				major = users.datas[i].major;
			   				if(major == 0){
			   					major = "软件工程";
			   				}else if(major == 1){
			   					major = "英语";
			   				}else{
			   					major = "数学";
			   				}
			   				intro = users.datas[i].intro;
			   				
			   				var UserTb = '<tr>'+
					   						'<td bgcolor="#C0C0C0" style="width:3px"><input type="checkbox" name="check" value="' + username + '"></td>'+
					   						'<td bgcolor="#eee8aa" >'+'<a href="userUpdateInit.do?username='+ username +'">' + username + '</a>'+'</td>'+
					   						'<td bgcolor="#ccc8aa" >' + password + '</td>'+
					   						'<td bgcolor="#ffdab9" >' + sex + '</td>'+
					   						'<td bgcolor="#88cdaa" >' + hobby + '</td>'+
					   						'<td bgcolor="#aaa0dd" >' + major + '</td>'+
					   						'<td bgcolor="#ee7f50" >' + intro + '</td>'+
					   						'<td id="td1"><input type="button" value="更新用户"'+ "onClick=userUpdate('"+ username +"')" + ' /><input type="button" value="删除用户"'+ "onClick=deleteUser('"+ username +"')" + ' /></td>'+		
					   					 '</tr>';
			   				$("#userTable").append(UserTb);
				    	}
				    	$("#userTable").append('<tr><td bgcolor= "SkyBlue" colspan="8"><input type="submit" value="一括删除" onclick="delAllAction()"></td></tr>');
				    }  
			   });
		 }
        	    
	</script>
	
	<script src="jquery-3.2.1.min.js"></script>
	
	</head>
	
	<body>
		<form action="userSearch.do" method="post" id="form">
				<br/>
				<div align="center">
			
					<bean:message bundle="userResources" key="username"/>:
						<input type="text" name="username" id="username" onblur="executeAjax()" />
						<br/>
						<br/>
					<bean:message bundle="userResources" key="sex"/>:
						<input type="radio" name="sex" id="sex1" value="0" onblur="executeAjax()"><bean:message bundle="userResources" key="male"/>
						<input type="radio" name="sex" id="sex2" value="1" onblur="executeAjax()"><bean:message bundle="userResources" key="female"/>
						<br/>
						<br/>
					<bean:message bundle="userResources" key="major"/>:
						<select name="major" id="major" onblur="executeAjax()">
						<option value="">-</option>
						<option value="0"><bean:message bundle="userResources" key="software"/></option>
						<option value="1"><bean:message bundle="userResources" key="english"/></option>
						<option value="2"><bean:message bundle="userResources" key="math"/></option>
						</select>
						<br/>
						<br/>
						<input type="submit" value="<bean:message bundle="userResources" key="inquire"/>">
						<input type="reset" value="<bean:message bundle="userResources" key="reset"/>">  
				</div>
				<br/>
				<div align="center"><bean:message bundle="userResources" key="information"/></div>
				<hr>
				<table border="1" id="userTable">
					<tr>
						<th style=width:3px><input type="checkbox" id="AllCheckbox" onclick="delAll()"></th>
						<th><bean:message bundle="userResources" key="username"/></th>
						<th><bean:message bundle="userResources" key="password"/></th>
						<th><bean:message bundle="userResources" key="sex"/></th>
						<th><bean:message bundle="userResources" key="hobby"/></th>
						<th><bean:message bundle="userResources" key="major"/></th>
						<th><bean:message bundle="userResources" key="intro"/></th>
						<th><bean:message bundle="userResources" key="update"/>
							 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<bean:message bundle="userResources" key="delete"/>
						</th>
					</tr>
					<% if(data!= null) {%>
						<% for( UserInfoHobby uh : data){%>
							<tr>
								<td bgcolor="#C0C0C0" style="width:3px"><input type="checkbox" name="check" value="<%=uh.getUsername()%>"></td>
								<td bgcolor="#eee8aa" ><a href="userUpdateInit.do?username=<%=uh.getUsername()%>"><%=uh.getUsername()%></a></td>
								<td bgcolor="#ccc8aa" ><%=uh.getPassword()%></td>
								<td bgcolor="#ffdab9" ><%=uh.getSex().replace("0","男").replace("1","女")%></td>
								<td bgcolor="#88cdaa" ><%=uh.getHobby().replace("0","足球").replace("1","篮球").replace("2","网球")%></td>
								<td bgcolor="#aaa0dd" ><%=uh.getMajor().replace("0","软件工程").replace("1","英语").replace("2","数学")%></td>
								<td bgcolor="#ee7f50" ><%=uh.getIntro()%></td>
								<td id="td1" >
									<input type="button"  onClick="userUpdate('<%=uh.getUsername()%>')" value="<bean:message bundle="userResources" key="updateReg"/>"/>
		            				<input type="button" onClick="deleteUser('<%=uh.getUsername()%>')" value="<bean:message bundle="userResources" key="deldateReg"/>"/> 
								</td>		
							</tr>
						<%}%>
					 <%}%>	
							<tr>
								<td bgcolor= "SkyBlue" colspan="8">
									<input type="submit" value="<bean:message bundle="userResources" key="deleteAll"/>" onclick="delAllAction()">
								</td>
							</tr>	
				</table>
		</form>
	</body>
</html>