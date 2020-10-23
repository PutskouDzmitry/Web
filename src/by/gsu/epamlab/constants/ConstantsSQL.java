package by.gsu.epamlab.constants;

public class ConstantsSQL {
	public static final String SELECT_LOGIN_PASSWORD_SQL = "SELECT * FROM web.data where login=? and password=?";
	public static final String INSERT_LOGIN_PASSWORD_SQL = "Insert into web.data (login,password) values (?,?);";
	public static final int LOGIN_COLUMN = 1;
	public static final int PASSWORD_COLUMN = 2;
	public static final String ERROR_WITH_DATABASE = "Error with database";
	public final static String SQL_TODAY_TASK = "SELECT * FROM web.task where login = ? and isFixed = 0 and isRecycle = 0 and date <= CURRENT_DATE();";
	public final static String SQL_TOMORROW_TASK = "SELECT * FROM web.task where login = ? and isFixed = 0 and isRecycle = 0 and date = CURRENT_DATE()+1";
	public final static String SQL_SOMEDAY_TASK = "SELECT * FROM web.task where login = ? and isFixed = 0 and isRecycle = 0 and date > CURRENT_DATE()+1";
	public final static String SQL_FIXED_TASK = "Select * from web.task where login = ? and isFixed = 1";
	public final static String SQL_RECYCLE_TASK = "Select * from web.task where login = ? and isRecycle = 1";
	public final static String SQL_INSERT_DAY = "insert into web.task (login,description,date,isFixed,isRecycle) values (?,?,?,0,0);";
	public final static String SQL_FIXED_QUERY = "update web.task set isFixed = 1, isRecycle = 0 where login = ? and idTask = ?";
	public final static String SQL_UNFIXED_QUERY = "update web.task set isFixed = 0  where login = ? and idTask = ?";
	public final static String SQL_REMOVE_QUERY = "update web.task set isRecycle = 1, isFixed = 0 where login = ? and idTask = ?";
	public final static String SQL_RESTORE_QUERY = "update web.task set isRecycle = 0, isFixed = 0 where login = ? and idTask = ?";
	public final static String DELETE_QUERY = "delete from web.task where login = ? and idTask = ?";
	public final static String DELETE_ALL_QUERY = "delete from web.task where login = ? and isRecycle = 1";
}	
