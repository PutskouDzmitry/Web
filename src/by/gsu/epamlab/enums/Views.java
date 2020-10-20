package by.gsu.epamlab.enums;

import by.gsu.epamlab.constants.ConstantsSQL;

public enum Views {
	SOMEDAY(ConstantsSQL.SQL_SOMEDAY_TASK),
	TODAY(ConstantsSQL.SQL_TODAY_TASK),
	TOMORROW(ConstantsSQL.SQL_TOMORROW_TASK),
	FIXED(ConstantsSQL.SQL_FIXED_TASK),
	RECYCLE(ConstantsSQL.SQL_RECYCLE_TASK);

	private String sqlStr;
	
	Views(String sqlStr) {
		this.sqlStr = sqlStr;
	}

	public String getSqlStr() {
		return sqlStr;
	}
}
