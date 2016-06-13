package by.epamlab.struts.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

public class LogoutForm extends ActionForm {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7071003024697874907L;

	@Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        request.getSession().invalidate();
        request.getSession().removeAttribute("user");
        return new ActionErrors();
    }
}