package co.jp.netwisdom.form;

import org.apache.struts.action.ActionForm;

public class UserForm extends ActionForm{
	
	public String[] getCheck() {
		return check;
	}
	public void setCheck(String[] check) {
		this.check = check;
	}
	private String username;
	private String password;
	private String sex;
	private String major;
	private String intro;	
	private String[] hobby;
	private String[] check;
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getSex() {
		return sex;
	}
	public String getMajor() {
		return major;
	}
	public String getIntro() {
		return intro;
	}
	public String[] getHobby() {
		return hobby;
	}
	
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}

}
