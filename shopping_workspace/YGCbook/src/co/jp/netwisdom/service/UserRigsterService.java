package co.jp.netwisdom.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import co.jp.netwisdom.Dto.UserRigisterDto;
import co.jp.netwisdom.Interface.UserRigsterServiceInterface;
import co.jp.netwisdom.Utils.MyBatisUtil;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.UserInfo;
import co.jp.netwisdom.mapper.HobbyMapper;
import co.jp.netwisdom.mapper.UserInfoMapper;

@Service
public class UserRigsterService implements UserRigsterServiceInterface {

	@Override
	public boolean UserRigster(UserRigisterDto dto) {

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
		boolean successFlag = true;
		// 获取mapper
		HobbyMapper hobbyMapper = MyBatisUtil.getMapper(HobbyMapper.class);
		UserInfoMapper userInfoMapper = MyBatisUtil.getMapper(UserInfoMapper.class);

		// 发送請求，执行sql操作
		userInfoMapper.save(new UserInfo(dto.getUsername(), dto.getPassword(), dto.getSex(), dto.getMajor(), dto.getIntro()));

		for (Hobby hobby : hobbyList) {
			hobbyMapper.save(hobby.getUsername(), hobby.getHobby());
		}

		// 判断导入数据是否成功
		if (successFlag) {
			System.out.println("用户信息 爱好信息导入数据库成功！！");

		} else {
			System.out.println("用户信息 爱好信息导入数据库失败！！");
			successFlag = false;
		}
		return successFlag;
	}
}
