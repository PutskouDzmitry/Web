package by.gsu.epamlab.ifaces;

import java.util.List;
import java.util.Map;

import by.gsu.epamlab.exception.DaoException;
import by.gsu.epamlab.exception.ValidationException;
import by.gsu.epamlab.model.beans.Task;

public interface TaskDAO {
	List<Task> getTasks(String login,String view) throws DaoException;
	void operationTask(String login, Map<String, String[]> parameterMap) throws DaoException, ValidationException;
}
