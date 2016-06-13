package by.epamlab.ejbs.reservation;

import javax.ejb.EJBHome;

public interface ResComponentSvHome extends EJBHome {
	public by.epamlab.ejbs.reservation.ResComponentSvRemote create()
			  throws javax.ejb.CreateException,
				java.rmi.RemoteException;

}
