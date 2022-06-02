package co.jp.netwisdom.service;

import java.util.List;
import org.springframework.stereotype.Service;
import co.jp.netwisdom.Interface.UserNameSearchServiceInterface;
import co.jp.netwisdom.Utils.MyBatisUtil;
import co.jp.netwisdom.entity.UserInfoHobby;
import co.jp.netwisdom.mapper.UserInfoHobbyMapper;

@Service
public class UserNameSearchService implements UserNameSearchServiceInterface {

	@Override
	public List<UserInfoHobby> userNameSearch(String username, String password, String sex, String major) {

		// 获取mapper
		UserInfoHobbyMapper userInfoHobbyMapper = MyBatisUtil.getMapper(UserInfoHobbyMapper.class);

		// 发送請求，执行sql操作
		List<UserInfoHobby> list = userInfoHobbyMapper.SearchUser(username, password, sex, major);

		return list;
	}
}
