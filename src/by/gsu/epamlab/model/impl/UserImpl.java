package by.gsu.epamlab.model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import by.gsu.epamlab.constants.ConstantsSQL;
import by.gsu.epamlab.exception.DaoException;
import by.gsu.epamlab.exception.InitException;
import by.gsu.epamlab.ifaces.UserDAO;
import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.model.service.PoolConnection;

public class UserImpl implements UserDAO{

	public UserImpl(ResourceBundle rb) throws InitException {
		final String NAME = "db.name";
		final String USER = "db.user";
		final String PASSWORD = "db.password";
		String url = rb.getString(NAME);
		String user = rb.getString(USER);
		String password = rb.getString(PASSWORD);
		PoolConnection.init(url, user, password);
	}

	@Override
	public Optional<User> getUser(String login, String password) throws DaoException {
		final String ERROR_CONN = "Error with connection";
		try (Connection cn = PoolConnection.getConnection(); PreparedStatement ps = cn.prepareStatement(ConstantsSQL.SELECT_LOGIN_PASSWORD_SQL)) {
			Optional<User> optUser = Optional.empty();
			ps.setString(ConstantsSQL.LOGIN_COLUMN, login);
			ps.setString(ConstantsSQL.PASSWORD_COLUMN, password);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					optUser = Optional.of(new User(rs.getString(ConstantsSQL.LOGIN_COLUMN),rs.getString(ConstantsSQL.PASSWORD_COLUMN)));
				}
			}
			return optUser;
		} catch(SQLException e) {
			throw new DaoException(ERROR_CONN);
		}
	}

	@Override
	public Optional<User> addAndGetUser(String login, String password) throws DaoException {
		final String ERROR = "This login or password don't correct";
		try(Connection cn = PoolConnection.getConnection(); PreparedStatement ps = cn.prepareStatement(ConstantsSQL.INSERT_LOGIN_PASSWORD_SQL)) {
			Optional<User> user = getUser(login, password);
			synchronized (this) {
				if(!user.isPresent()) {
					ps.setString(ConstantsSQL.LOGIN_COLUMN, login);
					ps.setString(ConstantsSQL.PASSWORD_COLUMN, password);
					ps.executeUpdate();
					user = Optional.of(new User(login,password));
				}
				else {
					user = Optional.empty();
				}
			} 
			return user;
		} catch (SQLException e) {
			throw new DaoException(ERROR,e);
		} 
	}
}
