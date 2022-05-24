package co.jp.netwisdom.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import co.jp.netwisdom.dao.UserInfoHobbyDAO;
import co.jp.netwisdom.entity.UserInfoHobby;
import co.jp.netwisdom.form.UserForm;
import co.jp.netwisdom.service.UserUpdateInitService;


public class UserUpdateInitAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		UserForm userForm = (UserForm)form;
		
		String username = userForm.getUsername();
		
		UserUpdateInitService upService = new UserUpdateInitService();
		upService.userUpdateInit(username);
		
		UserInfoHobbyDAO uhdao = new UserInfoHobbyDAO(); 
		UserInfoHobby list = uhdao.upUserIH(username);
		
		request.setAttribute("data", list);
		return mapping.findForward("userReg");
	}	
}
