package co.jp.netwisdom.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.jp.netwisdom.Dto.UserRigisterDto;
import co.jp.netwisdom.form.UserForm;
import co.jp.netwisdom.service.UserRigsterService;

@Controller(value = "/userRegister")
public class UserRigsterAction extends Action {

	@Autowired
	private UserRigsterService userRigsterService;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		UserForm userForm = (UserForm) form;

		UserRigisterDto dto = new UserRigisterDto();
		dto.setUsername(userForm.getUsername());
		dto.setPassword(userForm.getPassword());
		dto.setSex(userForm.getSex());
		dto.setMajor(userForm.getMajor());
		dto.setIntro(userForm.getIntro());
		dto.setHobby(userForm.getHobby());

		// 重复上述set对象 get对象的操作 未实装
		// dto = (UserRigisterDto)BeanPropertiesCopy.copy(userForm, dto);
		boolean successFlag = userRigsterService.UserRigster(dto);

		// 判断导入数据是否成功并执行重定向
		if (successFlag) {
			return mapping.findForward("Success");

		} else {
			return mapping.findForward("Error");
		}
	}
}
