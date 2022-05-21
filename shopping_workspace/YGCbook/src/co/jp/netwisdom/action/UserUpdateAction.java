package co.jp.netwisdom.action;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserInfoDAO;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.UserInfo;
import co.jp.netwisdom.form.UserForm;



public class UserUpdateAction  extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		UserForm userForm = (UserForm)form;
		
		String username = userForm.getUsername();
		String password = userForm.getPassword();
		String sex = userForm.getSex();
		String major = userForm.getMajor();
		String intro = userForm.getIntro();	 
		String[] hobby = userForm.getHobby();

		List hobbyList = new ArrayList();
		for(int i = 0; i < hobby.length;i++) {
			Hobby hobbyObj = new Hobby();
			hobbyObj.setUsername(username);
			hobbyObj.setHobby(hobby[i]);
			hobbyList.add(hobbyObj);
		}
		
		HobbyDAO hdao = new HobbyDAO();
		UserInfoDAO udao = new UserInfoDAO();
		
		boolean upUserInfoFlag = true;
		upUserInfoFlag = udao.upUserInfoFlag(username);
		upUserInfoFlag = udao.sava(new UserInfo(username,password,sex,major,intro));
		
		boolean upHobbyFlag = true;
		upHobbyFlag = hdao.upHobbyFlag(username);
		upHobbyFlag = hdao.sava(hobbyList);
		
		if(upUserInfoFlag && upHobbyFlag) {
			System.out.println("用户信息 爱好信息更新成功！！");
			return mapping.findForward("Success");
		}else {
			System.out.println("用户信息 爱好信息更新失败！！");
			return mapping.findForward("Error");
		}
		
	}	
}
