package co.jp.netwisdom.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import co.jp.netwisdom.dao.UserInfoHobbyDAO;
import co.jp.netwisdom.entity.UserInfoHobby;
import co.jp.netwisdom.form.UserForm;

public class UserSearchAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
			
			UserForm userForm = (UserForm)form;
			
			String username = userForm.getUsername();
			String password = userForm.getPassword();
			String sex = userForm.getSex();
			String major = userForm.getMajor();
			
		
		UserInfoHobbyDAO dao = new UserInfoHobbyDAO(); 
		List<UserInfoHobby> list = dao.SearchUH(username, password,sex, major);
		
		request.setAttribute("data", list);
		return mapping.findForward("userSearch");
		
	}
}
