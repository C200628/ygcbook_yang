package co.jp.netwisdom.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.key.dbManager.IResultSetMapping;
import co.jp.netwisdom.entity.UserInfoHobby;

public class UserInfoHobbyMapping implements IResultSetMapping{



	@Override
	public Object mapping(ResultSet rs) throws SQLException {
		int i = 1;
		UserInfoHobby userInfoHobbyMapping = new UserInfoHobby(
				rs.getString(i++),
				rs.getString(i++),
				rs.getString(i++),
				rs.getString(i++),
				rs.getString(i++)
				);
		return userInfoHobbyMapping;
	}
	

}
