package by.epamlab.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm extends ActionForm {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2339072467622221437L;
	private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password; 
    }
    
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors actionErrors = new ActionErrors();
        if (userName == null || userName.equals("") || password == null || password.equals("")) {
            if(userName == null || userName.equals("")) {
                actionErrors.add("userName", new ActionMessage("error.userName.null"));
            }
            if(password == null || password.equals("")) {
                actionErrors.add("password", new ActionMessage("error.password.null"));
            }
        }
        return actionErrors;
    }
}