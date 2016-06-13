package by.epamlab.ejbs.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import by.epamlab.ejbs.constants.ConstantsDB;
import by.epamlab.ejbs.exceptions.DBException;

public class ServiceDB {
	public static Connection getConnection() throws DBException {
		try {
			
			InitialContext initialContext = new InitialContext();
			DataSource dataSource = (DataSource)initialContext.lookup("java:/SqlDS");
			return dataSource.getConnection();
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
