package co.jp.netwisdom.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.key.dbManager.IResultSetMapping;
import co.jp.netwisdom.entity.Hobby;

public class HobbyMapping implements IResultSetMapping{
	
	
	@Override
	public Object mapping(ResultSet rs) throws SQLException{
		int i = 1;
		Hobby hobby = new Hobby(rs.getString(i++),rs.getString(i++));
		return hobby;
	}
}

