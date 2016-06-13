package by.epamlab.tags;

import by.epamlab.ifaces.IReservationDAO;
import by.epamlab.beans.reservation.ObjectElement;
import by.epamlab.model.exceptions.DaoException;
import by.epamlab.model.factories.ReservationFactory;

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TryCatchFinally;
import java.util.ArrayList;
import java.util.List;

public class ReservationTags extends BodyTagSupport implements TryCatchFinally {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5423022932487102448L;
	private String element;
    public void setElement(String element) {
        this.element = element;
    }

    public void setAttributes(String... attributes) {
    }

    public int doAfterBody() throws JspException {
        String params = bodyContent.getString();
        bodyContent.clearBody();
        List<ObjectElement> objectElementList = new ArrayList<>();

        IReservationDAO reservationDAO = ReservationFactory.getImplFromFactory();
        try {
            objectElementList = reservationDAO.getElement(element, params);

        }catch (DaoException e) {
            e.printStackTrace();
        }

        if(objectElementList != null) {
        	pageContext.setAttribute(element, objectElementList.get(0), PageContext.PAGE_SCOPE);
        }
        return SKIP_BODY;
    }

    public void doCatch(Throwable t) {
        System.out.println("An error occurred with the message"
                + t.getMessage());
    }

    public void doFinally() {
    }

    public void release() {

    }
}
