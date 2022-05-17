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
			
			Object[] values = userInfo.getObjArray();
			
			try {
				row = template.updata(sql, values);
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return row == 1;
		}

		public boolean upUserInfoFlag(String username) {
			
			String sql = "update userInfo set delFlg = '1' where username= ? ";
			
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
