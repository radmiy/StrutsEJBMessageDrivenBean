package by.epamlab.model.impl;

import by.epamlab.beans.user.Role;
import by.epamlab.beans.user.User;
import by.epamlab.model.exceptions.DaoException;

import java.util.HashMap;
import java.util.Map;

import by.epamlab.constants.Constants;
import by.epamlab.utilits.Security;
import by.epamlab.ifaces.IUserDAO;

public class UserImplMem implements IUserDAO {
	private static Map<User, byte[]> users = new HashMap<User, byte[]>();
	
	static {
		final String ADMIN_LOGIN = "user";
		users.put(new User(ADMIN_LOGIN, Role.ADMIN.name()), Security.criptPass("user"));
	}
	
	@Override
	public User getUser(String login, byte[] password) {
		try {
		checkLoginPassword(login, password);
		User user = new User(login);
		if(users.containsKey(user)) {
			byte[] passwordUser = users.get(user);
			if(password.equals(passwordUser)) {
				for(User userTemp : users.keySet()) {
					if(user.equals(userTemp)) {
						return userTemp;
					}
				}
			}else {
				throw new DaoException(Constants.ERROR_USER_PASSWORD);
			}
		}
		throw new DaoException(Constants.ERROR_USER);
		}catch (DaoException err) {
			err.printStackTrace();
			return null;
		}
	}

	@Override
	public User setUser(String login, byte[] password) {
		try {
		checkLoginPassword(login, password);
		synchronized (User.class) {
			User user = new User(login);
			if(!users.containsKey(user)) {
				users.put(user, password);
				return user;
			}
			throw new DaoException(Constants.ERROR_USER_EXIST);
		}
		}catch (DaoException err) {
			err.printStackTrace();
			return null;
		}
	}
	
	private void checkLoginPassword(String login, byte[] password) throws DaoException {
		if (login == null || password == null) {
			throw new DaoException(Constants.ERROR_NULL);
		}

		login = login.trim();
		if (Constants.KEY_EMPTY.equals(login)) {
			throw new DaoException(Constants.ERROR_EMPTY);
		}
	}
}
