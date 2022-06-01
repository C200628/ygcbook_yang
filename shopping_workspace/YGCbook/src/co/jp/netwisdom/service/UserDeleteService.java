package co.jp.netwisdom.service;

import co.jp.netwisdom.Utils.MyBatisUtil;
import co.jp.netwisdom.mapper.HobbyMapper;
import co.jp.netwisdom.mapper.UserInfoMapper;

public class UserDeleteService {
	public void userDelete(String username) {

		// 获取mapper
		UserInfoMapper userInfoMapper = MyBatisUtil.getMapper(UserInfoMapper.class);
		HobbyMapper hobbyMapper = MyBatisUtil.getMapper(HobbyMapper.class);
		
		// 发送請求，执行sql操作
		userInfoMapper.upUserInfoFlag(username);
		hobbyMapper.upHobbyFlag(username);
	}
}
