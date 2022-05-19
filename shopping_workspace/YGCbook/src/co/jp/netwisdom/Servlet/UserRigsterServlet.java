package co.jp.netwisdom.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserInfoDAO;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.UserInfo;

public class UserRigsterServlet extends HttpServlet {
		public void doGet(HttpServletRequest request , HttpServletResponse response) 
				throws ServletException, IOException{
				this.doPost(request, response);
		}
		
		public void doPost(HttpServletRequest request , HttpServletResponse response)
				throws ServletException, IOException{
				
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String sex = request.getParameter("sex");
				String major = request.getParameter("major");
				String intro = request.getParameter("intro");	
				//TODO hobbyArray = null的情况下跳转到注册初始化页面未实现
				String[] hobbyArray = request.getParameterValues("hobby");
				
				List hobbyList = new ArrayList();

				for(int i = 0; i < hobbyArray.length;i++) {
					Hobby hobbyObject = new Hobby();
					hobbyObject.setUsername(username);
					hobbyObject.setHobby(hobbyArray[i]);
					hobbyList.add(hobbyObject);
				}
			
					
			
				//用户信息导入
				UserInfoDAO userinfodao = new UserInfoDAO();
				//爱好信息导入
				HobbyDAO hobbydao = new HobbyDAO();
				//判断导入数据是否成功并执行重定向
				if (userinfodao.sava(new UserInfo(username, password, sex, major, intro)) && hobbydao.sava(hobbyList)){
					System.out.println("用户信息 爱好信息导入数据库成功！！");
					request.getRequestDispatcher("/userRegSuccess.jsp").forward(request, response);
					
				}else{
					System.out.println("用户信息 爱好信息导入数据库失败！！");
					response.sendRedirect("/YGCbook/UserRegFail.jsp");
				}
				
	
		}
}
