package by.gsu.epamlab.constants;

public class ConstantsSQL {
	public static final String SELECT_LOGIN_PASSWORD_SQL = "SELECT * FROM web.data where login=? and password=?";
	public static final String INSERT_LOGIN_PASSWORD_SQL = "Insert into web.data (login,password) values (?,?);";
	public static final int LOGIN_COLUMN = 1;
	public static final int PASSWORD_COLUMN = 2;
	
}	
