package co.jp.netwisdom.service;


import java.util.List;
import co.jp.netwisdom.dao.UserInfoHobbyDAO;
import co.jp.netwisdom.entity.UserInfoHobby;


public class UserNameSearchService  {

		public List<UserInfoHobby> userNameSearch(String username, String password,String sex,String major) {
			
			UserInfoHobbyDAO dao = new UserInfoHobbyDAO();
			return  dao.SearchUser(username, password, sex, major);
	}
}
