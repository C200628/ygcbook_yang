package co.jp.netwisdom.Servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserUpdateInitServlet extends HttpServlet{
	public void doGet(HttpServletRequest request ,HttpServletResponse response)
		throws ServletException,IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response )
		throws ServletException,IOException{
		String username = request.getParameter("username");
		Map<String,String> map = new HashMap<String, String>();
		map.put(username, username);
		System.out.println("map值"+map);
		request.getSession().setAttribute("data", map);
		request.getRequestDispatcher("/userReg.jsp").forward(request, response);
	}
}
