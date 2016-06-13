package by.epamlab.ejbs.user;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import by.epamlab.beans.user.Role;
import by.epamlab.beans.user.User;
import by.epamlab.ejbs.constants.Constants;
import by.epamlab.ejbs.constants.ConstantsDB;
import by.epamlab.ejbs.exceptions.DBException;
import by.epamlab.ejbs.exceptions.DaoException;
import by.epamlab.ejbs.utils.ServiceDB;

public class UserSvBean implements SessionBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4641415111946881411L;

	@Override
	public void ejbActivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ejbPassivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ejbRemove() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSessionContext(SessionContext arg0) throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	public void ejbCreate() throws EJBException {
	
		
	}
	
	public User getUser(String login, byte[] password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
		
		try {
			final int IND_LOGIN = 1;
			connection = ServiceDB.getConnection();
			preparedStatement = connection.prepareStatement(ConstantsDB.SELECT_SQL);
			preparedStatement.setString(IND_LOGIN, login);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				try {
					String userLogin = resultSet.getString(ConstantsDB.USER_COLUMN_LOGIN);
					String userRole = resultSet.getString(ConstantsDB.USER_COLUMN_ROLE);
					byte[] userPass = resultSet.getBytes(ConstantsDB.USER_COLUMN_PASS);
					if(userPass != null && Arrays.equals(userPass, password)) {
						User user = new User(userLogin, userRole);
						return user;
					}
					throw new DaoException(Constants.ERROR_USER_PASSWORD);
				} catch (IllegalArgumentException e) {
					throw new DaoException(Constants.ERROR_LOAD_USER + e.getMessage());
				}
			} 
			return null;
		} catch (SQLException e) {
            throw new DaoException(ConstantsDB.QUERY_STRING + ConstantsDB.SELECT_SQL+ ConstantsDB.END_STRING + e);
		}  catch (DBException e) {
            throw new RuntimeException(e.getMessage());
		} finally {
			try {
				ServiceDB.closeConnection(connection, preparedStatement, resultSet);
			} catch (DBException e) {
				new DaoException(e.getMessage());
			}
		}
		}catch (DaoException err) {
			err.printStackTrace();
			return new User();
		}
	}
	
	public User setUser(String login, byte[] password) {
		final int IND_LOGIN = 1;
		final int IND_PASS = 2;
		final int IND_ROLE = 3;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			try {
				connection = ServiceDB.getConnection();
				preparedStatement = connection.prepareStatement(ConstantsDB.SELECT_USER_SQL);
				preparedStatement.setString(IND_LOGIN, login);
				
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					throw new DaoException(Constants.ERROR_USER_EXIST);
				} 
				
				preparedStatement = connection.prepareStatement(ConstantsDB.INSERT_USER_SQL);
				preparedStatement.setString(IND_LOGIN, login);
				preparedStatement.setBytes(IND_PASS, password);
				preparedStatement.setString(IND_ROLE, Role.USER.toString());
				preparedStatement.executeUpdate();
				
				return new User(login, Role.USER.name());
					
			} catch (SQLException e) {
	            throw new DaoException(ConstantsDB.QUERY_STRING + ConstantsDB.SELECT_SQL+ ConstantsDB.END_STRING + e);
			}  catch (DBException e) {
	            throw new RuntimeException(e.getMessage());
			} finally {
				try {
					ServiceDB.closeConnection(connection, preparedStatement, resultSet);
				} catch (DBException e) {
					new DaoException(e.getMessage());
				}
			}
		} catch (DaoException err) {
			err.printStackTrace();
			return new User();
		}
		
	}
}
