package co.jp.netwisdom.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import co.jp.netwisdom.entity.UserInfo;
import co.jp.netwisdom.form.UserForm;
import co.jp.netwisdom.service.CheckUserNameService;

public class CheckUserNameAction extends Action {

	private CheckUserNameService checkUserNameService = new CheckUserNameService();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		UserForm userForm = (UserForm) form;
		String username = userForm.getUsername();

		UserInfo userInfo = checkUserNameService.checkUserName(username);

		PrintWriter printWriter = response.getWriter();
		if (userInfo != null) {
			printWriter.print("1");
		} else {
			printWriter.print("0");
		}
		printWriter.close();

		return null;
	}
}
