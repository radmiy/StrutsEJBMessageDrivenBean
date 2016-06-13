package by.epamlab.model.impl;

import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

import by.epamlab.beans.user.User;
import by.epamlab.ejbs.user.UserSvHome;
import by.epamlab.ejbs.user.UserSvRemote;
import by.epamlab.ifaces.IUserDAO;
import by.epamlab.utilites.PropertiesUtil;

public class UserImplDB implements IUserDAO {
	@Override
	public User getUser(String login, byte[] password) {
		try {
			InitialContext context = PropertiesUtil.getInitialContext();
			Object ref = context.lookup("UserSv");
			UserSvHome home = (UserSvHome) PortableRemoteObject.narrow(ref, UserSvHome.class);
			UserSvRemote remote = home.create(); 
			return remote.getUser(login, password); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User setUser(String login, byte[] password) {
		try {
			InitialContext context = PropertiesUtil.getInitialContext();
			Object ref = context.lookup("UserSv");
			UserSvHome home = (UserSvHome) PortableRemoteObject.narrow(ref, UserSvHome.class);
			UserSvRemote remote = home.create(); 
			return remote.setUser(login, password); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
