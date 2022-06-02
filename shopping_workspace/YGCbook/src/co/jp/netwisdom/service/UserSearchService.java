package co.jp.netwisdom.service;

import java.util.List;
import org.springframework.stereotype.Service;
import co.jp.netwisdom.Interface.UserSearchServiceInterface;
import co.jp.netwisdom.Utils.MyBatisUtil;
import co.jp.netwisdom.entity.UserInfoHobby;
import co.jp.netwisdom.mapper.UserInfoHobbyMapper;

@Service
public class UserSearchService implements UserSearchServiceInterface{
	
	@Override
	public List<UserInfoHobby> userSearch(String username, String password, String sex, String major) {

		// 获取mapper
		UserInfoHobbyMapper userInfoHobbyMapper = MyBatisUtil.getMapper(UserInfoHobbyMapper.class);

		// 发送請求，执行sql操作
		List<UserInfoHobby> list = userInfoHobbyMapper.SearchUH(username, password, sex, major);

		return list;
	}
}
