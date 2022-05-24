package co.jp.netwisdom.service;


import java.util.ArrayList;
import java.util.List;

import co.jp.netwisdom.Dto.UserUpdateDto;
import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserInfoDAO;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.UserInfo;


public class UserUpdateService   {
	
	public void userUpdate(UserUpdateDto dto) {
			
		String[] hobby = dto.getHobby();
		
		List hobbyList = new ArrayList();
		
		if(hobby == null) {
			hobby = new String[]{""};
		}
		for(int i = 0; i < hobby.length;i++) {
			Hobby hobbyObj = new Hobby();
			hobbyObj.setUsername(dto.getUsername());
			hobbyObj.setHobby(hobby[i]);
			hobbyList.add(hobbyObj);
		}
		
		HobbyDAO hdao = new HobbyDAO();
		UserInfoDAO udao = new UserInfoDAO();
		
		boolean upUserInfoFlag = true;
		upUserInfoFlag = udao.upUserInfoFlag(dto.getUsername());
		upUserInfoFlag = udao.sava(new UserInfo(dto.getUsername(), dto.getPassword(), dto.getSex(), dto.getMajor(), dto.getIntro()));
		
		boolean upHobbyFlag = true;
		upHobbyFlag = hdao.upHobbyFlag(dto.getUsername());
		upHobbyFlag = hdao.sava(hobbyList);
		
		if(upUserInfoFlag && upHobbyFlag) {
			System.out.println("用户信息 爱好信息更新成功！！");
		}else {
			System.out.println("用户信息 爱好信息更新失败！！");
			
		}
	}	
}
