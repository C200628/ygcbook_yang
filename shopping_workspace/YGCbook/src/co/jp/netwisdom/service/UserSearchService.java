package co.jp.netwisdom.service;

import java.util.List;
import co.jp.netwisdom.dao.UserInfoHobbyDAO;
import co.jp.netwisdom.entity.UserInfoHobby;


public class UserSearchService {
	public List<UserInfoHobby> userSearch(String username,String password,String sex, String major) {
		
		UserInfoHobbyDAO dao = new UserInfoHobbyDAO(); 
		return dao.SearchUH(username, password, sex, major);
		
	}
}
