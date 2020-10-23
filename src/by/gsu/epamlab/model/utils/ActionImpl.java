package by.gsu.epamlab.model.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import by.gsu.epamlab.constants.ConstantsJSP;
import by.gsu.epamlab.exception.ValidationException;
import by.gsu.epamlab.model.service.PoolConnection;


public class ActionImpl {
	
	public static void addTask(String login, Map<String,String[]> paramMap, String query) throws SQLException {
		final int LOGIN_ID_POS = 1;
		final int DESCRIPTION_POS = 2;
		final int DATE_POS = 3;
		try (Connection cn = PoolConnection.getConnection();
			 PreparedStatement ps = cn.prepareStatement(query)) {
			 Date date = Date.valueOf(paramMap.get(ConstantsJSP.TYPE_DAY_KEY)[0]);
			 String description = paramMap.get(ConstantsJSP.TYPE_DESC_KEY)[0];
			 ps.setString(LOGIN_ID_POS, login);
			 ps.setString(DESCRIPTION_POS,description);
			 ps.setDate(DATE_POS, date);
			 ps.executeUpdate();
			
		}
	}

	
	public static void  operateTask(String login, Map<String,String[]> paramMap, String query) throws SQLException, ValidationException {
		final String VALID_ERR = "no selected tasks";
		final int LOGIN_ID_POS = 1;
		final int ID_TASK_POS = 2;
		try (Connection cn = PoolConnection.getConnection(); 
			 PreparedStatement ps = cn.prepareStatement(query)) {
			 Optional<String[]> optIds = Optional.ofNullable(paramMap.get(ConstantsJSP.TYPE_TASK_KEY));
			 int[] idsTask = Arrays.stream(optIds.orElseThrow(()-> new ValidationException(VALID_ERR))).mapToInt(Integer::parseInt).toArray();
			 for(int id: idsTask) {
				 ps.setString(LOGIN_ID_POS, login);
				 ps.setInt(ID_TASK_POS, id);
				 ps.executeUpdate();
			 }
		}
	}


	public static void deleteAllTask(String login, Map<String,String[]> paramMap, String query) throws SQLException {
		final int LOGIN_ID_POS = 1;
		try (Connection cn = PoolConnection.getConnection(); PreparedStatement ps = cn.prepareStatement(query)){
			ps.setString(LOGIN_ID_POS, login);
			ps.executeUpdate();
		}
	}

}
