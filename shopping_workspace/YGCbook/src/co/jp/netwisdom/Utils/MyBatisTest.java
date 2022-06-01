package co.jp.netwisdom.Utils;


public class MyBatisTest {

	public static void main(String[] args) {
		
		
//		获取Session工厂
//		SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
//		获取Session
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		获取mapper
//		HobbyMapper hobbyMapper = sqlSession.getMapper(HobbyMapper.class);
//		UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
//		UserInfoHobbyMapper userInfoHobbyMapper = sqlSession.getMapper(UserInfoHobbyMapper.class);
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		try {
//			發送請求，執行sql操作
//			userInfoMapper.save(new UserInfo("b123","abc123","1","0","ceshi111"));
//			userInfoMapper.upUserInfoFlag("b111");
//			hobbyMapper.save("b111","1");
//			hobbyMapper.upHobbyFlag("b111");
//			map.put("username", "b123");
//			map.put("hobby", "1");
//			hobbyMapper.save(map);
//			List<UserInfoHobby> list = userInfoHobbyMapper.SearchUser("", "", "", "");
//			UserInfo userInfo = userInfoHobbyMapper.upUserIH("b123");
//			
//			執行提交
//			sqlSession.commit();
//			System.out.println(userInfo.getUsername());
//			System.out.println(list.size());
//		} catch (Exception e) {
//			執行回滾
//			sqlSession.rollback();
//			System.out.println("趕緊找！！出錯了！！");
//			e.printStackTrace();
//		}finally {
//			sqlSession.close();
//		}
	}
}
