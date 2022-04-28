package co.jp.netwisdom.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.key.dbManager.JdbcTemplate;
import co.jp.netwisdom.entity.UserInfoHobby;
import co.jp.netwisdom.mapping.UserInfoHobbyMapping;

public class UserInfoHobbyDAO {
	
	private JdbcTemplate template = new JdbcTemplate();
	
	public  List<UserInfoHobby>  SearchUIH(String username,String sex,String major ){
		String sql = "SELECT uf.username,sex,GROUP_CONCAT(hobby)hobby,major,intro "
				+ "FROM userinfo uf "
				+ "LEFT JOIN hobby hy "
				+ "ON uf.username = hy.username WHERE 1=1 ";
		
				if (!username.equals("")) {
					sql += "AND uf.username = '" + username + "'";
				}
				if (sex  != null) {
					sql += "AND sex = '" + sex + "'";
				}
				if (!major.equals("")) {
					sql += "AND major = '"+ major +"'";
				}
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
