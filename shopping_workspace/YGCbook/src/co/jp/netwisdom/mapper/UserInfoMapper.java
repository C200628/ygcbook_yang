package co.jp.netwisdom.mapper;

import org.apache.ibatis.annotations.Param;

import co.jp.netwisdom.entity.UserInfo;

public interface UserInfoMapper {
		
		//执行保存
		public void save(UserInfo userInfo); 
		
		//执行伦理删除
		public boolean upUserInfoFlag(String username);
		
		//Ajax检查用户名
		public UserInfo checkUserName(@Param("username")String username);
		
}		
		//执行物理删除 涉及更改jdbc底层代码 未实装 
/*		public boolean delete(String username) {
			String sql = "DELETE userinfo,hobby"
						+" FROM userinfo,hobby"
						+" WHERE ";
				sql += " userinfo.username = '" + username + "'";
				sql += " AND hobby.username = '" + username + "'";
*/

