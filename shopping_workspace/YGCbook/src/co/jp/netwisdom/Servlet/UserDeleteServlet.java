package co.jp.netwisdom.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserInfoDAO;


public class UserDeleteServlet extends HttpServlet{
	public void doGet(HttpServletRequest request ,HttpServletResponse response)
		throws ServletException,IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response )
		throws ServletException,IOException{
		String username = request.getParameter("username");
		
		HobbyDAO hdao = new HobbyDAO();
		UserInfoDAO udao = new UserInfoDAO();
		
		boolean upUserInfoFlag = true;
		upUserInfoFlag = udao.upUserInfoFlag(username);
		
		boolean upHobbyFlag = true;
		upHobbyFlag = hdao.upHobbyFlag(username);

		if(upUserInfoFlag && upHobbyFlag) {
			System.out.println("用户信息 爱好信息删除成功！！");
			response.sendRedirect("/YGCbook/userSearch.jsp");
		}
	}	
}
