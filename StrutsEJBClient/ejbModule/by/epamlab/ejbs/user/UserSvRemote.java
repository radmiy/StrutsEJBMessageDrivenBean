package by.epamlab.ejbs.user;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;

import by.epamlab.beans.user.User;

public interface UserSvRemote extends EJBObject {
	public User getUser(String login, byte[] password) throws RemoteException;
	public User setUser(String login, byte[] password) throws RemoteException;
}
