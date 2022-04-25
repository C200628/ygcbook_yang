package co.jp.netwisdom.dao;

import java.sql.SQLException;
import java.util.List;
import cn.key.dbManager.JdbcTemplate;
import co.jp.netwisdom.entity.Hobby;

public class HobbyDAO {
	
	private JdbcTemplate template = new JdbcTemplate();
	
	public boolean sava(List list) {
		int row = 0;
		String sql = "insert into hobby(username,hobby) " +
					 "	values(?,?) ";
	
	try {
		for(Object object : list) {
			Hobby hobbyobject = (Hobby)object;
			Object[] values = null;
			values = new Object[] {
					hobbyobject.getUsername(),
					hobbyobject.getHobby()};
			row = template.updata(sql, values);
		}
	}catch (SQLException e) {

	}catch (ClassNotFoundException e) {
	
	}
	return true;
	}
}
