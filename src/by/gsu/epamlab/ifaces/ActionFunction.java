package by.gsu.epamlab.ifaces;

import java.sql.SQLException;
import java.util.Map;

import by.gsu.epamlab.exception.ValidationException;

public interface ActionFunction {
	void getTask(String login, Map<String,String[]> paramMap,String query) throws ValidationException, SQLException;
}
