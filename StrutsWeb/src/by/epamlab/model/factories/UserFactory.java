package by.epamlab.model.factories;

import by.epamlab.ifaces.IUserDAO;
import by.epamlab.model.impl.UserImplDB;
import by.epamlab.model.impl.UserImplMem;

@SuppressWarnings("unused")
public class UserFactory {
	public static IUserDAO getImplFromFactory() {
//		return new UserImplMem();
		return new UserImplDB();
	}

}
