package co.jp.netwisdom.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.jp.netwisdom.Dto.UserUpdateDto;
import co.jp.netwisdom.Interface.UserUpdateServiceInterface;
import co.jp.netwisdom.form.UserForm;

@Controller(value = "/updateReg")
public class UserUpdateAction  extends Action {
	
	@Autowired
	private UserUpdateServiceInterface userUpdateService;
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		UserForm userForm = (UserForm)form;

		UserUpdateDto dto = new UserUpdateDto();
		
		dto.setUsername(userForm.getUsername());
		dto.setPassword(userForm.getPassword());
		dto.setSex(userForm.getSex());
		dto.setMajor(userForm.getMajor());
		dto.setIntro(userForm.getIntro());	
		dto.setHobby(userForm.getHobby());
		dto.setHobby(userForm.getHobby());
		
		//重复上述set对象 get对象的操作 未实装
		//dto = (UserRigisterDto)BeanPropertiesCopy.copy(userForm, dto);
		userUpdateService.userUpdate(dto);
	
		return mapping.findForward("Success");
	}	
}
