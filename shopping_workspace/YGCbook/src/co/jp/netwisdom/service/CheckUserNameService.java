package co.jp.netwisdom.service;


import co.jp.netwisdom.Utils.MyBatisUtil;
import co.jp.netwisdom.entity.UserInfo;
import co.jp.netwisdom.mapper.UserInfoMapper;

public class CheckUserNameService {
	public UserInfo checkUserName(String username) {

		// 获取mapper
		UserInfoMapper userInfoMapper = MyBatisUtil.getMapper(UserInfoMapper.class);
		
		//执行Ajax检查username的sql操作
		UserInfo userInfo = userInfoMapper.checkUserName(username); 
		
		return userInfo;
	}
}
