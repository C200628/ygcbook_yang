package co.jp.netwisdom.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import co.jp.netwisdom.dao.UserInfoDAO;
import co.jp.netwisdom.entity.UserInfo;
import co.jp.netwisdom.form.UserForm;

public class CheckUserNameAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
			
			UserForm userForm = (UserForm)form;
			String username = userForm.getUsername();
			
			UserInfoDAO userInfoDAO = new UserInfoDAO();
			
			List<UserInfo> list = userInfoDAO.checkUserName(username); //获取数据

			PrintWriter printWriter = response.getWriter();
			if (list.size() >= 1) {
				printWriter.print("1");
			} else {
				printWriter.print("0");
			}
			printWriter.close();
		return null;
	}
}
