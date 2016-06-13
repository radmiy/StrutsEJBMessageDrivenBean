package by.epamlab.ifaces;

import by.epamlab.beans.user.User;

public interface IUserDAO {
	public User getUser(String name, byte[] password);
	
	public User setUser(String name, byte[] password);
}
