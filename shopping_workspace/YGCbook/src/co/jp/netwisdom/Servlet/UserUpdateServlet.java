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



public class UserUpdateServlet extends HttpServlet{
	public void doGet(HttpServletRequest request ,HttpServletResponse response)
		throws ServletException,IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response )
		throws ServletException,IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex 	 = request.getParameter("sex");
		String major = request.getParameter("major");
		String intro = request.getParameter("intro");
		String [] hobbyArray = request.getParameterValues("hobby");
		
		List hobbyList = new ArrayList();
		
		for(int i = 0; i < hobbyArray.length;i++) {
			Hobby hobbyObject = new Hobby();
			hobbyObject.setHobby(hobbyArray[i]);
			hobbyList.add(hobbyObject);
		}
		
		HobbyDAO hdao = new HobbyDAO();
		UserInfoDAO udao = new UserInfoDAO();
		
		boolean upUserInfoFlag = true;
		upUserInfoFlag = udao.upUserInfoFlag(username);
		upUserInfoFlag = udao.sava(new UserInfo(username,password,sex,major,intro));
		
		boolean upHobbyFlag = true;
		upHobbyFlag = hdao.upHobbyFlag(username);
		upHobbyFlag = hdao.sava(hobbyList);
		
		if(upUserInfoFlag && upHobbyFlag) {
			System.out.println("用户信息 爱好信息更新成功！！");
			request.getRequestDispatcher("/userRegSuccess.jsp").forward(request, response);
		}else {
			System.out.println("用户信息 爱好信息更新失败！！");
			response.sendRedirect("/YGCbook/UserRegFail.jsp");
		}
		
	}	
}
