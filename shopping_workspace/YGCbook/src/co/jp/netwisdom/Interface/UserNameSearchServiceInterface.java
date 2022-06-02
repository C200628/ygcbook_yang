package co.jp.netwisdom.Interface;

import java.util.List;
import co.jp.netwisdom.entity.UserInfoHobby;

public interface UserNameSearchServiceInterface {
	public List<UserInfoHobby> userNameSearch(String username, String password, String sex, String major);
}
