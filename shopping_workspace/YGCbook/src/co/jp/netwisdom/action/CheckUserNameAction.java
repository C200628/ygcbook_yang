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

			PrintWriter pw = response.getWriter();
			if (list.size() >= 1) {
				pw.print("1");
			} else {
				pw.print("0");
			}
			pw.close();
		return null;
	}
}
