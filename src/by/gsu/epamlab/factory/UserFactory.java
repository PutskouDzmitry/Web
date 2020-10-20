package by.gsu.epamlab.factory;

import java.util.ResourceBundle;

import by.gsu.epamlab.exception.InitException;
import by.gsu.epamlab.ifaces.UserDAO;
import by.gsu.epamlab.model.impl.UserImpl;


public class UserFactory {
	private enum DataSourse {
        DB {
        	UserDAO getSourse(ResourceBundle rb) throws InitException{
                return new UserImpl(rb);
            }
        };
	 
        abstract UserDAO getSourse(ResourceBundle rb)throws InitException;
    }
 
    private static UserDAO sourse;

	public static void init(ResourceBundle rb) throws InitException {
		final String FACTORY = "factory.user";
        DataSourse enumSourse = DataSourse.valueOf(rb.getString(FACTORY).toUpperCase());
        sourse = enumSourse.getSourse(rb);
	}
	
	public static UserDAO getClassFromFactory() {
		return sourse;
	}
}
