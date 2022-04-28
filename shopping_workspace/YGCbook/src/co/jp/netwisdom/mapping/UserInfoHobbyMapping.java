package co.jp.netwisdom.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.key.dbManager.IResultSetMapping;

public class UserInfoHobbyMapping implements IResultSetMapping{

	@Override
	public Object mapping(ResultSet rs) throws SQLException {
		int i = 1;
		UserInfoHobbyMapping userInfoHobbyMapping = new UserInfoHobbyMapping(
				rs.getString(i++),
				rs.getString(i++),
				rs.getString(i++),
				rs.getString(i++),
				rs.getString(i++)
				);
		return userInfoHobbyMapping;
	}
	

}
