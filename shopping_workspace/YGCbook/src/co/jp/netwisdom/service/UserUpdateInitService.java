package co.jp.netwisdom.service;

import co.jp.netwisdom.dao.UserInfoHobbyDAO;
import co.jp.netwisdom.entity.UserInfoHobby;

public class UserUpdateInitService {
	public UserInfoHobby userUpdateInit(String username) {
		
		UserInfoHobbyDAO uhdao = new UserInfoHobbyDAO(); 
		UserInfoHobby list = uhdao.upUserIH(username);
		
		return list;
	}	
}
