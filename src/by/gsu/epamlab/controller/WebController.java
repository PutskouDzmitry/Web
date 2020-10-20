package by.gsu.epamlab.controller;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import by.gsu.epamlab.constants.ConstantsJSP;
import by.gsu.epamlab.exception.InitException;
import by.gsu.epamlab.factory.TaskFactory;
import by.gsu.epamlab.factory.UserFactory;

/**
 * Servlet implementation class WebController
 */
@WebServlet(
		urlPatterns = {"/web"}, 
		initParams = { 
			@WebInitParam(name = ConstantsJSP.PROPERTY_NAME, value = ConstantsJSP.PROPERTY_VALUE)
		}, 
		loadOnStartup = 1
	)
public class WebController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger LOGGER = Logger.getLogger(WebController.class.getName());
	
	@Override
	public void init(ServletConfig sc) throws ServletException {
		super.init(sc);
		try {
			String prName = sc.getInitParameter(ConstantsJSP.PROPERTY_NAME);
			ResourceBundle rb = ResourceBundle.getBundle(prName);
			UserFactory.init(rb);
			TaskFactory.init(rb);
		} catch (InitException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
			throw new ServletException();
		}
		
		
	}

}
