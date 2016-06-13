package by.epamlab.ejbs.user;

import javax.ejb.EJBHome;
import javax.ejb.CreateException;
import java.rmi.RemoteException;

public interface UserSvHome extends EJBHome {
	public UserSvRemote create() throws CreateException, RemoteException;

}
