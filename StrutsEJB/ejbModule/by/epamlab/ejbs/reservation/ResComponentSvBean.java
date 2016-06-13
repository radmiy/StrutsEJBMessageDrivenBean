package by.epamlab.ejbs.reservation;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import by.epamlab.beans.reservation.ObjectElement;
import by.epamlab.ejbs.utils.XmlParser;

public class ResComponentSvBean implements SessionBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4641415111946881412L;

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
	
	public List<ObjectElement> getResComponent(String params, String code, String componentTypeCode) {
		XmlParser xmlParser = new XmlParser();
		String nameElement = "Reservation";
		List<ObjectElement> result = xmlParser.getElement(nameElement, params);
		if(code != null && !componentTypeCode.equals("")) {
			for(int indexReservation = result.size() - 1; indexReservation >= 0; indexReservation--) {
				ObjectElement reservation = result.get(indexReservation);
				if(!code.equals("") && !reservation.getAttributes().get("Code").equals(code)) {
					result.remove(indexReservation);
					continue;
				}else
				{
					if(reservation.getContent() != null) {
						List<ObjectElement> content = reservation.getContent().get("");
						if(componentTypeCode != null && !componentTypeCode.equals("") && content != null) {
							for(int indexResComp = content.size() -1; indexResComp >= 0; indexResComp--) {
								ObjectElement resComp = content.get(indexResComp);
								if(!resComp.getAttributes().get("ComponentTypeCode").equals(componentTypeCode)) {
									content.remove(indexResComp);
								}
							}
						}
					}
				}
			}
		}
		
		return result;
	}
}
