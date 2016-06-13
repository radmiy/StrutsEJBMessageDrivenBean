package by.epamlab.ejbs.reservation;

import javax.ejb.EJBHome;

public interface CustomerSvHome extends EJBHome {
	public by.epamlab.ejbs.reservation.CustomerSvRemote create()
			  throws javax.ejb.CreateException,
				java.rmi.RemoteException;

}
