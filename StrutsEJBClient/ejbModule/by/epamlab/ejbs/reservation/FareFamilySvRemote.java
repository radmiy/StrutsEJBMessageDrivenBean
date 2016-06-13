package by.epamlab.ejbs.reservation;

import java.util.List;

import javax.ejb.EJBObject;

import by.epamlab.beans.reservation.ObjectElement;

public interface FareFamilySvRemote extends EJBObject {
	public List<ObjectElement> getFareFamily(String params) throws java.rmi.RemoteException;
}
