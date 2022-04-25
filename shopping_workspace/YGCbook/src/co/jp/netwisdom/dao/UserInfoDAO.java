package co.jp.netwisdom.dao;

import java.sql.SQLException;
import cn.key.dbManager.JdbcTemplate;
import co.jp.netwisdom.entity.UserInfo;

public class UserInfoDAO {
	
		private JdbcTemplate template = new JdbcTemplate();
		
		public boolean sava(UserInfo userInfo) {
			int row = 0;
			String sql = "insert into userInfo(username,password,sex,major,intro) " +
					"	values(?,?,?,?,?) ";
			
		Object[] values = new Object[]{
				userInfo.getUsername(),
				userInfo.getPassword(),
				userInfo.getSex(),
				userInfo.getMajor(),
				userInfo.getIntro()};
		
		try {
			row = template.updata(sql, values);
		}catch (SQLException e) {

		}catch (ClassNotFoundException e) {
		
		}
		return (row == 1);
	}
}
