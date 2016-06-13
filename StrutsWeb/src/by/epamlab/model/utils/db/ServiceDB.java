package by.epamlab.model.utils.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import by.epamlab.constants.ConstantsDB;
import by.epamlab.model.exceptions.DBException;

public class ServiceDB {
	private static Properties properties;
	
	private static Properties getProperties() {
		if(properties == null) {
			properties = new Properties();
			properties.setProperty("user", ConstantsDB.USER_NAME);
			properties.setProperty("password", ConstantsDB.USER_PASSWORD);
		}
		return properties;
	}
	
	public static Connection getConnection() throws DBException {
		try {
			Class.forName(ConstantsDB.DRIVER);
			return DriverManager.getConnection(ConstantsDB.URL+ConstantsDB.DB_NAME, getProperties());
		} catch (Exception e) {
			throw new DBException(e.getMessage());
		}
	}
	
	public static void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) throws DBException {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new DBException(ConstantsDB.ERROR_CLOSE);
		}
	}
	
	public static void closePreparedStatment(PreparedStatement preparedStatement) throws DBException {
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (SQLException e) {
			throw new DBException(ConstantsDB.ERROR_CLOSE);
		}
	}
}
