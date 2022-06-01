package co.jp.netwisdom.service;

import java.util.ArrayList;
import java.util.List;
import co.jp.netwisdom.Dto.UserUpdateDto;
import co.jp.netwisdom.Utils.MyBatisUtil;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.UserInfo;
import co.jp.netwisdom.mapper.HobbyMapper;
import co.jp.netwisdom.mapper.UserInfoMapper;

public class UserUpdateService {

	public void userUpdate(UserUpdateDto dto) {

		String[] hobbys = dto.getHobby();

		List<Hobby> hobbyList = new ArrayList<>();

		if (hobbys == null) {
			hobbys = new String[] { "" };
		}
		for (int i = 0; i < hobbys.length; i++) {
			Hobby hobbyObj = new Hobby();
			hobbyObj.setUsername(dto.getUsername());
			hobbyObj.setHobby(hobbys[i]);
			hobbyList.add(hobbyObj);
		}

		// 获取mapper
		UserInfoMapper userInfoMapper = MyBatisUtil.getMapper(UserInfoMapper.class);
		HobbyMapper hobbyMapper = MyBatisUtil.getMapper(HobbyMapper.class);
		// 发送請求，执行sql操作
		userInfoMapper.upUserInfoFlag(dto.getUsername());
		userInfoMapper.save(new UserInfo(dto.getUsername(), dto.getPassword(), dto.getSex(), dto.getMajor(), dto.getIntro()));
		
		hobbyMapper.upHobbyFlag(dto.getUsername());
		for (Hobby hobby : hobbyList) {
			hobbyMapper.save(hobby.getUsername(), hobby.getHobby());
		}

	}
}
