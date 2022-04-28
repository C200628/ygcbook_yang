package co.jp.netwisdom.Servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jp.netwisdom.dao.UserInfoHobbyDAO;
import co.jp.netwisdom.entity.UserInfoHobby;



public class UserSearchServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		String username = request.getParameter("username");
		String sex = request.getParameter("sex");
		String major = request.getParameter("major");
		
		UserInfoHobbyDAO dao = new UserInfoHobbyDAO(); 
		List<UserInfoHobby> list = dao.SearchUIH(username, sex, major);
	
	
		request.setAttribute("data", list);
		
		request.getRequestDispatcher("/userSearch.jsp").forward(request, response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		this.doGet(request, response);
	}
}
