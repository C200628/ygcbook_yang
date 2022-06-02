package co.jp.netwisdom.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import co.jp.netwisdom.Interface.UserSearchServiceInterface;
import co.jp.netwisdom.entity.UserInfoHobby;
import co.jp.netwisdom.form.UserForm;

@Controller(value = "/userSearch")
public class UserSearchAction extends Action {

	@Autowired
	private UserSearchServiceInterface userSearchService;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		UserForm userForm = (UserForm) form;

		String username = userForm.getUsername();
		String password = userForm.getPassword();
		String sex = userForm.getSex();
		String major = userForm.getMajor();

		List<UserInfoHobby> list = userSearchService.userSearch(username, password, sex, major);

		request.setAttribute("data", list);
		return mapping.findForward("userSearch");

	}
}
