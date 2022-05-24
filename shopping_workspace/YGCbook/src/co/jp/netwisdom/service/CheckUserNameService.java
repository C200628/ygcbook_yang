package co.jp.netwisdom.service;


import java.util.List;


import co.jp.netwisdom.dao.UserInfoDAO;
import co.jp.netwisdom.entity.UserInfo;


public class CheckUserNameService {
	public List<UserInfo> checkUserName(String username) {
		
			UserInfoDAO userInfoDAO = new UserInfoDAO();
			return userInfoDAO.checkUserName(username); 
			
	}
}
