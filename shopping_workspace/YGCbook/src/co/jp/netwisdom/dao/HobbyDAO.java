package co.jp.netwisdom.dao;

import java.sql.SQLException;
import java.util.List;
import cn.key.dbManager.JdbcTemplate;
import co.jp.netwisdom.entity.Hobby;

public class HobbyDAO {
	
	private JdbcTemplate template = new JdbcTemplate();
	
	public boolean sava(List list) {
		
		String sql = "insert into hobby(username,hobby) values(?,?) ";
		int row = 0;
		try {
			for(Object object : list) {
				Hobby hobbyObj = (Hobby)object;
				Object[] values = null;
				values = new Object[] {
						hobbyObj.getUsername(),
						hobbyObj.getHobby()};
				row = template.updata(sql, values);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return row == 1;
	}
	
	public boolean upHobbyFlag(String username) {
		
		String sql = "update hobby set delFlg = '1' where username = ? ";
				
		Object[] values = new Object[] {username};

		try {
			template.updata(sql, values);
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return true;
	}
}
