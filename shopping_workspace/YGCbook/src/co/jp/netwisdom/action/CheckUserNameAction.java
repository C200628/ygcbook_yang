package co.jp.netwisdom.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import co.jp.netwisdom.Interface.CheckUserNameServiceInterface;
import co.jp.netwisdom.entity.UserInfo;
import co.jp.netwisdom.form.UserForm;

@Controller(value = "/checkName")
public class CheckUserNameAction extends Action {

	@Autowired
	private CheckUserNameServiceInterface checkUserNameService;

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
