package by.gsu.epamlab.constants;

public class ConstantsSQL {
	public static final String SELECT_LOGIN_PASSWORD_SQL = "SELECT * FROM web.data where login=? and password=?";
	public static final String INSERT_LOGIN_PASSWORD_SQL = "Insert into web.data (login,password) values (?,?);";
	public static final int LOGIN_COLUMN = 1;
	public static final int PASSWORD_COLUMN = 2;
	public static final String ERROR_WITH_DATABASE = "Error with database";
	public final static String SQL_TODAY_TASK = "SELECT * FROM web.task where login = ? and date <= CURRENT_DATE();";
	public final static String SQL_TOMORROW_TASK = "SELECT * FROM web.task where login = ? and date = CURRENT_DATE()+1";
	public final static String SQL_SOMEDAY_TASK = "SELECT * FROM web.task where login = ? and date > CURRENT_DATE()+1";
	public final static String SQL_FIXED_TASK = "Select * from web.fixed where login = ?";
	public final static String SQL_RECYCLE_TASK = "Select * from web.recycle where login = ?";
}	
