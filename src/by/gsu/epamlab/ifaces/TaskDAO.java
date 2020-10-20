package by.gsu.epamlab.ifaces;

import java.util.List;

import by.gsu.epamlab.exception.DaoException;
import by.gsu.epamlab.model.beans.Task;

public interface TaskDAO {
	List<Task> getTasks(String login,String view) throws DaoException;
}
