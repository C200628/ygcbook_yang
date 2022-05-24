package co.jp.netwisdom.service;

import java.util.ArrayList;
import java.util.List;

import co.jp.netwisdom.Dto.UserRigisterDto;
import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserInfoDAO;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.UserInfo;


public class UserRigsterService {
	
	public boolean UserRigster(UserRigisterDto dto) {
		
		
			//爱好信息导入
			HobbyDAO hobbydao = new HobbyDAO();
			//用户信息导入
			UserInfoDAO userinfodao = new UserInfoDAO();
			
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

			boolean successFlag = true;
			//判断导入数据是否成功并执行重定向
			if (userinfodao.sava(new UserInfo(dto.getUsername(), dto.getPassword(), dto.getSex(), dto.getMajor(), dto.getIntro())) 
				&& hobbydao.sava(hobbyList)){
				System.out.println("用户信息 爱好信息导入数据库成功！！");
				
			}else{
				System.out.println("用户信息 爱好信息导入数据库失败！！");
				successFlag = false;
			}
			return successFlag;
	}
}

