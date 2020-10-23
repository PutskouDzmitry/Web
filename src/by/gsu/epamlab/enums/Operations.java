package by.gsu.epamlab.enums;

import by.gsu.epamlab.constants.ConstantsSQL;
import by.gsu.epamlab.ifaces.ActionFunction;
import by.gsu.epamlab.model.utils.ActionImpl;

public enum Operations {
	
	ADD(ConstantsSQL.SQL_INSERT_DAY,ActionImpl::addTask), FIX(ConstantsSQL.SQL_FIXED_QUERY,ActionImpl::operateTask), REMOVE(ConstantsSQL.SQL_REMOVE_QUERY,ActionImpl::operateTask), 
	UNFIX(ConstantsSQL.SQL_UNFIXED_QUERY,ActionImpl::operateTask), DELETE(ConstantsSQL.DELETE_QUERY,ActionImpl::operateTask), DELETE_ALL(ConstantsSQL.DELETE_ALL_QUERY,ActionImpl::deleteAllTask), 
	RESTORE(ConstantsSQL.SQL_RESTORE_QUERY,ActionImpl::operateTask);
	
	private String sqlStr;
	private ActionFunction actFunction;
	
	
	Operations(String sqlStr, ActionFunction actFunction) {
		this.sqlStr = sqlStr;
		this.actFunction = actFunction;
	}
	
	public ActionFunction getActFunction() {
		return actFunction;
	}
	
	public String getSqlStr() {
		return sqlStr;
	}
}
