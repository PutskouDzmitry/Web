package by.gsu.epamlab.model.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.gsu.epamlab.constants.ConstantsSQL;
import by.gsu.epamlab.enums.Views;
import by.gsu.epamlab.exception.DaoException;
import by.gsu.epamlab.ifaces.TaskDAO;
import by.gsu.epamlab.model.beans.Task;
import by.gsu.epamlab.model.service.PoolConnection;

public class TaskImpl implements TaskDAO{

	
	@Override
	public List<Task> getTasks(String login, String view) throws DaoException {
		final int ID_LOGIN = 1;
		final int ID_TASK = 2;
		final int DES_POS = 3;
		final int DATE_POS = 4;
		
		List<Task> tasks = new ArrayList<Task>();
		
		try (Connection cn = PoolConnection.getConnection(); PreparedStatement ps = cn.prepareStatement(Views.valueOf(view.toUpperCase()).getSqlStr())) {
			ps.setString(ID_LOGIN, login);
			try (ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					int idTask = rs.getInt(ID_TASK);
					String des = rs.getString(DES_POS);
					Date date = rs.getDate(DATE_POS);
					tasks.add(new Task(idTask, des, date));
				}
			}
		} catch (SQLException e) {
			throw new DaoException(ConstantsSQL.ERROR_WITH_DATABASE, e);
		}
		return tasks;
	}

}
