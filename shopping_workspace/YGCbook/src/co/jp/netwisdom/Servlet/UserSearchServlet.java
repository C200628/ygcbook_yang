package co.jp.netwisdom.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class UserSearchServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		String username = request.getParameter("username");
		String sex = request.getParameter("sex");
		String major = request.getParameter("major");
		
		System.out.println(username);
		System.out.println(sex);
		System.out.println(major);
		
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		this.doGet(request, response);
	}
}
