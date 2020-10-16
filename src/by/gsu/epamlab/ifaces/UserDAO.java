package by.gsu.epamlab.ifaces;

import java.util.Optional;

import by.gsu.epamlab.exception.DaoException;
import by.gsu.epamlab.model.beans.User;

public interface UserDAO {
	Optional<User> getUser(String login, String password) throws DaoException;
	Optional<User> addAndGetUser(String login, String password) throws DaoException;

}
