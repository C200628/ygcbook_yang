package co.jp.netwisdom.entity;

public class UserInfoHobby {
	private String username;
	private String sex;
	private String major;
	private String intro;
	private String hobby;
	
	public UserInfoHobby(String username,String sex,String hobby,String major,String intro) {
		super();
		this.username = username;
		this.sex = sex;
		this.hobby=hobby;
		this.major = major;
		this.intro= intro;
		
	}
	
	public UserInfoHobby() {
		super();

	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return sex;
	}
	public void setMajor(String major) {
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getIntro() {
		return intro;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getHobby() {
		return hobby;
	}
}