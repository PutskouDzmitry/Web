package by.gsu.epamlab.enums;

public enum Views {
	SOMEDAY("SELECT * FROM web.task where login = ? and date > CURRENT_DATE()+1"),
	TODAY("SELECT * FROM web.task where login = ? and date <= CURRENT_DATE()"),
	TOMORROW("SELECT * FROM web.task where login = ? and date = CURRENT_DATE()+1"),
	FIXED("Select * from web.fixed where login = ?"),
	RECYCLE("Select * from web.recycle where login = ?");

	private String sqlStr;
	
	Views(String sqlStr) {
		this.sqlStr = sqlStr;
	}

	public String getSqlStr() {
		return sqlStr;
	}
}
