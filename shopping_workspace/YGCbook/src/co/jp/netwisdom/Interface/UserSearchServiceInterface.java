package co.jp.netwisdom.Interface;

import java.util.List;
import co.jp.netwisdom.entity.UserInfoHobby;

public interface UserSearchServiceInterface {
	public List<UserInfoHobby> userSearch(String username, String password, String sex, String major);
}