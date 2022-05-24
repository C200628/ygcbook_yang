package co.jp.netwisdom.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import co.jp.netwisdom.form.UserForm;
import co.jp.netwisdom.service.UserDeleteAllService;


public class UserDeleteAllAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		UserForm userForm = (UserForm)form;
		
		String[] usernames = userForm.getCheck();
		
		new UserDeleteAllService().userDeleteAll(usernames);
		
		return mapping.findForward("userSearch");
	}	
}
