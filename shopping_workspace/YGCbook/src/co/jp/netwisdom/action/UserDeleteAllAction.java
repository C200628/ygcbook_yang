package co.jp.netwisdom.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserInfoDAO;
import co.jp.netwisdom.form.UserForm;


public class UserDeleteAllAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		UserForm userForm = (UserForm)form;
		
		String[] usernames = userForm.getCheck();
		
		HobbyDAO hdao = new HobbyDAO();
		UserInfoDAO udao = new UserInfoDAO();
		
		for(String username:usernames) {
			boolean upUserInfoFlag = true;
			upUserInfoFlag = udao.upUserInfoFlag(username);
			
			boolean upHobbyFlag = true;
			upHobbyFlag = hdao.upHobbyFlag(username);
	
			if(upUserInfoFlag && upHobbyFlag) {
				System.out.println("用户信息 爱好信息删除成功！！");
			}
		}
		return mapping.findForward("userSearch");
	}	
}
