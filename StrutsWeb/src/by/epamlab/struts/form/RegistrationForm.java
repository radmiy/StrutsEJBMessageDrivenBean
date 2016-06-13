package by.epamlab.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class RegistrationForm extends ActionForm{

    /**
	 * 
	 */
	private static final long serialVersionUID = -2931527046553232051L;
	private String userNameReg = null;
    private String passwordReg = null;
    private String repeatPasswordReg = null;

    public String getUserNameReg() {
        return userNameReg;
    }

    public void setUserNameReg(String userNameReg) {
        this.userNameReg = userNameReg;
    }

    public String getPasswordReg() {
        return passwordReg;
    }

    public void setPasswordReg(String passwordReg) {
        this.passwordReg = passwordReg;
    }

    public String getRepeatPasswordReg() {
        return repeatPasswordReg;
    }

    public void setRepeatPasswordReg(String repeatPasswordReg) {
        this.repeatPasswordReg = repeatPasswordReg;
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors actionErrors = new ActionErrors();

            if(userNameReg == null || userNameReg.equals("")) {
                actionErrors.add("userNameReg", new ActionMessage("error.userNameReg.null"));
            }
            if(passwordReg == null || passwordReg.equals("")) {
                actionErrors.add("passwordReg", new ActionMessage("error.passwordReg.null"));
            }
            if(repeatPasswordReg == null || repeatPasswordReg.equals("")) {
                actionErrors.add("repeatPasswordReg", new ActionMessage("error.repeatPasswordReg.null"));
            }
            if(!passwordReg.equals(repeatPasswordReg)) {
                actionErrors.add("passwordsMachReg", new ActionMessage("error.passwordsMachReg.null"));
            }
        return actionErrors;
    }
}