package by.epamlab.ejbs.reservation;

import javax.ejb.EJBHome;

public interface FareFamilySvHome extends EJBHome {
	public by.epamlab.ejbs.reservation.FareFamilySvRemote create()
			  throws javax.ejb.CreateException,
				java.rmi.RemoteException;

}
