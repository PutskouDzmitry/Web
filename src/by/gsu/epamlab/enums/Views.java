package by.gsu.epamlab.enums;

import java.util.EnumSet;

import by.gsu.epamlab.constants.ConstantsSQL;

public enum Views {
	SOMEDAY(ConstantsSQL.SQL_SOMEDAY_TASK, 
			EnumSet.of(Operations.ADD, Operations.FIX, Operations.REMOVE)),
	TODAY(ConstantsSQL.SQL_TODAY_TASK,
			EnumSet.of(Operations.ADD, Operations.FIX, Operations.REMOVE)),
	TOMORROW(ConstantsSQL.SQL_TOMORROW_TASK,
			EnumSet.of(Operations.ADD, Operations.FIX, Operations.REMOVE)),
	FIXED(ConstantsSQL.SQL_FIXED_TASK,
			EnumSet.of(Operations.UNFIX, Operations.REMOVE)),
	RECYCLE(ConstantsSQL.SQL_RECYCLE_TASK,
			EnumSet.of(Operations.DELETE, Operations.DELETE_ALL, Operations.RESTORE));

	private String sqlStr;
	private EnumSet<Operations> op;
	
	Views(String sqlStr, EnumSet<Operations> op) {
		this.sqlStr = sqlStr;
		this.op = op;
	}

	public EnumSet<Operations> getOperations() {
		return op;
	}
	
	public String getSqlStr() {
		return sqlStr;
	}
}
