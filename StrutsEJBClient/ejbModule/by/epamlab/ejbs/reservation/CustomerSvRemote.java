package by.epamlab.ejbs.reservation;

import java.util.List;

import javax.ejb.EJBObject;

import by.epamlab.beans.reservation.ObjectElement;

public interface CustomerSvRemote extends EJBObject {
	public List<ObjectElement> getCustomer(String params) throws java.rmi.RemoteException;
}
