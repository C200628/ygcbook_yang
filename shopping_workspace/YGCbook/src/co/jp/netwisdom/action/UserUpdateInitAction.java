package co.jp.netwisdom.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import co.jp.netwisdom.Interface.UserUpdateInitServiceInterface;
import co.jp.netwisdom.entity.UserInfoHobby;
import co.jp.netwisdom.form.UserForm;

@Controller(value = "/userUpdateInit")
public class UserUpdateInitAction extends Action {

	@Autowired
	private UserUpdateInitServiceInterface userUpdateInitService;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		UserForm userForm = (UserForm) form;

		String username = userForm.getUsername();

		UserInfoHobby list = userUpdateInitService.userUpdateInit(username);

		request.setAttribute("data", list);
		return mapping.findForward("userReg");
	}
}
