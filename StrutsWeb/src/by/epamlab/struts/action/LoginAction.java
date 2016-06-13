package by.epamlab.struts.action;

import by.epamlab.constants.Constants;
import by.epamlab.struts.form.LoginForm;
import by.epamlab.utilits.Security;
import by.epamlab.ifaces.IUserDAO;
import by.epamlab.beans.user.Role;
import by.epamlab.beans.user.User;
import by.epamlab.model.factories.UserFactory;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LoginForm loginForm = (LoginForm) form;
        String target = "failure";
		ActionErrors actionErrors = new ActionErrors();
        try {
            String login = loginForm.getUserName();
            byte[] password = Security.criptPass(loginForm.getPassword());
            request.getSession().removeAttribute(Constants.KEY_USER);

            IUserDAO userDAO = UserFactory.getImplFromFactory();
            User user = userDAO.getUser(login, password);
            if(user != null && user.getRole() != Role.VISITOR) {
            	target = "success";
            	request.getSession().setAttribute(Constants.KEY_USER, user);
            	return mapping.findForward(target);
            }else
            {
                if(user == null) {
                	actionErrors.add("nouser", new ActionMessage("error.nouser.null"));
                }else {
                	actionErrors.add("password", new ActionMessage("error.password.incorrect"));
                }
                saveErrors(request, actionErrors);
                return mapping.findForward(target);
            }

        }catch (IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        }

        actionErrors.add("nouser", new ActionMessage("error.nouser.null"));
        saveErrors(request, actionErrors);
        return mapping.findForward(target);
    }



}