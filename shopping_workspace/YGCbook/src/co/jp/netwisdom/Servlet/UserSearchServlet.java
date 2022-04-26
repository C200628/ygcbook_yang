package co.jp.netwisdom.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.jp.netwisdom.dao.UserInfoDAO;
import co.jp.netwisdom.entity.UserInfo;

public class UserSearchServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		String username = request.getParameter("username");
		
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		UserInfo userInfo = userInfoDAO.findById(username);
		System.out.println("读取成功");
		System.out.println("检索信息如下：");
		System.out.println("用户名：" + userInfo.getUsername());
		System.out.println("密码：" + userInfo.getPassword());
		System.out.println("性别：" + userInfo.getSex());
		System.out.println("专业：" + userInfo.getMajor());
		System.out.println("简介：" + userInfo.getIntro());
		
		
		
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		this.doGet(request, response);
	}
}
