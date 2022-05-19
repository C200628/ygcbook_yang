package co.jp.netwisdom.dao;

import java.sql.SQLException;
import cn.key.dbManager.JdbcTemplate;
import co.jp.netwisdom.entity.UserInfo;


public class UserInfoDAO {
	
		private JdbcTemplate template = new JdbcTemplate();
		
		//执行保存
		public boolean sava(UserInfo userInfo) {

			int row = 0;
			String sql = "insert into userInfo(username,password,sex,major,intro) values(?,?,?,?,?) ";
			
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
		
		//执行伦理删除
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
		
		//执行物理删除 涉及更改jdbc底层代码 未实装 
/*		public boolean delete(String username) {
			
			String sql = "DELETE userinfo,hobby"
						+" FROM userinfo,hobby"
						+" WHERE ";
				sql += " userinfo.username = '" + username + "'";
				sql += " AND hobby.username = '" + username + "'";
	
			try {
				template.updata(sql, username);
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return true;
		}	*/
}
