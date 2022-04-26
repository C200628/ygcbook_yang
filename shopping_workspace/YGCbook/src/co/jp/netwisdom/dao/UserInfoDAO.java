package co.jp.netwisdom.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import cn.key.dbManager.JdbcTemplate;
import co.jp.netwisdom.entity.UserInfo;
import co.jp.netwisdom.mapping.UserInfoMapping;

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
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return (row == 1);
		}
		
		
		public UserInfo findById(String username) {
			
			String sql = "select * from userinfo where username = '" + username +"'";
			
			List<UserInfo> list  = new Vector<UserInfo>();
			
			try {
				list = template.selete(sql,new UserInfoMapping());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list.get(0);
		}
}
