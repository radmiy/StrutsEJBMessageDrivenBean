package by.epamlab.ejbs.reservation;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import by.epamlab.beans.reservation.ObjectElement;
import by.epamlab.ejbs.utils.XmlParser;

public class FareFamilySvBean implements SessionBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4641415111946881413L;

	@Override
	public void ejbActivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ejbPassivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ejbRemove() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSessionContext(SessionContext arg0) throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	public void ejbCreate() throws EJBException {
	
		
	}
	
	public List<ObjectElement> getFareFamily(String params) {
		XmlParser xmlParser = new XmlParser();
		String nameElement = "FareFamily";
		return xmlParser.getElement(nameElement, params);
	}
}
