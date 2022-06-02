package co.jp.netwisdom.service;

import org.springframework.stereotype.Service;
import co.jp.netwisdom.Interface.UserDeleteAllServiceInterface;
import co.jp.netwisdom.Utils.MyBatisUtil;
import co.jp.netwisdom.mapper.HobbyMapper;
import co.jp.netwisdom.mapper.UserInfoMapper;

@Service
public class UserDeleteAllService implements UserDeleteAllServiceInterface{
	
	@Override
	public void userDeleteAll(String[] usernames) {

		// 获取mapper
		UserInfoMapper userInfoMapper = MyBatisUtil.getMapper(UserInfoMapper.class);
		HobbyMapper hobbyMapper = MyBatisUtil.getMapper(HobbyMapper.class);
		// 发送請求，执行sql操作
		for (String username : usernames) {
			userInfoMapper.upUserInfoFlag(username);
			hobbyMapper.upHobbyFlag(username);
		}
	}
}