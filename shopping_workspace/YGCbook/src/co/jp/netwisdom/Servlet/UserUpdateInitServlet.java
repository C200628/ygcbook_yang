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

public class UserUpdateInitServlet extends HttpServlet{
	public void doGet(HttpServletRequest request ,HttpServletResponse response)
		throws ServletException,IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response )
		throws ServletException,IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String hobby = request.getParameter("hobby");
		String major = request.getParameter("major");
		String intro = request.getParameter("intro");
		
		UserInfoHobbyDAO daos = new UserInfoHobbyDAO();
		List<UserInfoHobby> list = daos.SearchUH(username,password,hobby,major,intro);
		
		request.setAttribute("data", list);
		request.getRequestDispatcher("/userReg.jsp").forward(request, response);
	}
}
