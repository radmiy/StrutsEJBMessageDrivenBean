package by.epamlab.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import by.epamlab.beans.user.User;
import by.epamlab.constants.Constants;
import by.epamlab.ifaces.IUserDAO;
import by.epamlab.model.factories.UserFactory;
import by.epamlab.struts.form.RegistrationForm;
import by.epamlab.utilits.Security;

public class RegistrationAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        RegistrationForm registrationForm = (RegistrationForm) form;
        String target = "success";

        try {
            String login = registrationForm.getUserNameReg();
            byte[] password = Security.criptPass(registrationForm.getPasswordReg());
            request.getSession().removeAttribute(Constants.KEY_USER);

            IUserDAO userDAO = UserFactory.getImplFromFactory();
            User user = userDAO.setUser(login, password);
            if(user != null) {
				request.getSession().setAttribute(Constants.KEY_USER, user);
				return mapping.findForward(target);
            }
        }catch (IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        }

        target = "failure";
        ActionErrors actionErrors = new ActionErrors();
        actionErrors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.username.null"));
        saveErrors(request, actionErrors);
        return mapping.findForward(target);
    }



}