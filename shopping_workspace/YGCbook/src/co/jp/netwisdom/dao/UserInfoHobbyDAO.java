package co.jp.netwisdom.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.key.dbManager.JdbcTemplate;
import co.jp.netwisdom.entity.UserInfoHobby;
import co.jp.netwisdom.mapping.UserInfoHobbyMapping;

public class UserInfoHobbyDAO {
	
	private JdbcTemplate template = new JdbcTemplate();

	//执行查询
	public  List<UserInfoHobby>  SearchUH(String username,String password,String sex,String major ){
		String sql = "SELECT uf.username,password,sex,GROUP_CONCAT(hobby)hobby,major,intro "
					 + "FROM userinfo uf "
					 + "LEFT JOIN hobby hy "
					 + "ON uf.username = hy.username WHERE 1=1 ";
				
				if (!username.equals("")) {
					sql += "AND uf.username = '" + username + "'";
				}
				if (password != null) {
					sql += "AND password = '" + password + "'";
				}	
				if (sex  != null) {
					sql += "AND sex = '" + sex + "'";
				}
				if (!major.equals("")) {
					sql += "AND major = '"+ major +"'";
				}

				sql += " AND uf.delFlg ='0' AND hy.delFlg = '0'";

				sql += " GROUP BY uf.username";
				
				List<UserInfoHobby> list = new ArrayList<UserInfoHobby>();
				try {
					list = template.selete(sql, new UserInfoHobbyMapping());
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return list;
	}
	
	//根据Username执行更新
	public  UserInfoHobby upUserIH(String username){
		String sql = "SELECT uf.username,password,sex,GROUP_CONCAT(hobby) hobby,major,intro "
					 + "FROM userinfo uf "
					 + "LEFT JOIN hobby hy "
					 + "ON uf.username = hy.username WHERE ";
				
				sql += " uf.username = '" + username + "'";
				
				sql += " AND uf.delFlg ='0' AND hy.delFlg = '0'";
				
				sql += " GROUP BY uf.username";
				
				List<UserInfoHobby> list = new ArrayList<UserInfoHobby>();
				try {
					list = template.selete(sql, new UserInfoHobbyMapping());
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return list.get(0);
	}
	
	public  List<UserInfoHobby>  SearchUser(String username,String password,String sex,String major ){
		String sql = "SELECT uf.username,password,sex,GROUP_CONCAT(hobby) hobby,major,intro "
					 + "FROM userinfo uf "
					 + "LEFT JOIN hobby hy "
					 + "ON uf.username = hy.username WHERE 1=1 ";
				
				if (username != null && !username.equals("")) {
					sql += "AND uf.username = '" + username + "'";
				}
				if (password != null) {
					sql += "AND password = '" + password + "'";
				}	
				if (sex  != null) {
					sql += "AND sex = '" + sex + "'";
				}
				if (major !=null && !major.equals("")) {
					sql += "AND major = '"+ major +"'";
				}

				sql += " AND uf.delFlg ='0' AND hy.delFlg = '0'";

				sql += " GROUP BY uf.username";
				
				List<UserInfoHobby> list = new ArrayList<UserInfoHobby>();
				try {
					list = template.selete(sql, new UserInfoHobbyMapping());
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return list;
	}
}
