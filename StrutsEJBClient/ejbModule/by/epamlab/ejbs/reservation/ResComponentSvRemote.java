package by.epamlab.ejbs.reservation;

import java.util.List;

import javax.ejb.EJBObject;

import by.epamlab.beans.reservation.ObjectElement;

public interface ResComponentSvRemote extends EJBObject {
	public List<ObjectElement> getResComponent(String params, String code, String componentTypeCode) throws java.rmi.RemoteException;
}
