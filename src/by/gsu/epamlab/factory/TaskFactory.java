package by.gsu.epamlab.factory;

import java.util.ResourceBundle;

import by.gsu.epamlab.exception.InitException;
import by.gsu.epamlab.ifaces.TaskDAO;
import by.gsu.epamlab.model.impl.TaskImpl;

public class TaskFactory {
	private enum DataSource {
        DB {
        	TaskDAO getSourse(ResourceBundle rb) throws InitException{
                return new TaskImpl();
            }
        };
	 
        abstract TaskDAO getSourse(ResourceBundle rb) throws InitException;
    }
 
    private static TaskDAO sourse;

	public static void init(ResourceBundle rb) throws InitException{
		final String FACTORY = "factory.task";
        DataSource enumSource = DataSource.valueOf(rb.getString(FACTORY).toUpperCase());
        sourse = enumSource.getSourse(rb);
	}
	
	public static TaskDAO getClassFromFactory() {
		return sourse;
	}
}
