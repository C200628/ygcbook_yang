package co.jp.netwisdom.service;

import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserInfoDAO;


public class UserDeleteAllService {
	public void userDeleteAll(String[] usernames) {

		HobbyDAO hdao = new HobbyDAO();
		UserInfoDAO udao = new UserInfoDAO();
		
		for(String username:usernames) {
			boolean upUserInfoFlag = true;
			upUserInfoFlag = udao.upUserInfoFlag(username);
			
			boolean upHobbyFlag = true;
			upHobbyFlag = hdao.upHobbyFlag(username);
	
			if(upUserInfoFlag && upHobbyFlag) {
				System.out.println("用户信息 爱好信息删除成功！！");
			}
		}
	}	
}
