package co.jp.netwisdom.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import co.jp.netwisdom.entity.UserInfoHobby;

public interface UserInfoHobbyMapper {

	//执行查询
	public  List<UserInfoHobby> SearchUH(@Param("username")String username,@Param("password")String password,@Param("sex")String sex,@Param("major")String major );
	//根据Username执行更新
	public  UserInfoHobby upUserIH(String username);
	
	public  List<UserInfoHobby>  SearchUser(@Param("username")String username,@Param("password")String password,@Param("sex")String sex,@Param("major")String major );
}
