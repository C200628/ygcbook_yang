package co.jp.netwisdom.service;

import co.jp.netwisdom.Utils.MyBatisUtil;
import co.jp.netwisdom.entity.UserInfoHobby;
import co.jp.netwisdom.mapper.UserInfoHobbyMapper;

public class UserUpdateInitService {
	public UserInfoHobby userUpdateInit(String username) {

		// 获取mapper
		UserInfoHobbyMapper userInfoHobbyMapper = MyBatisUtil.getMapper(UserInfoHobbyMapper.class);

		// 发送請求，执行sql操作
		UserInfoHobby userInfoHobby = userInfoHobbyMapper.upUserIH(username);

		return userInfoHobby;
	}
}
