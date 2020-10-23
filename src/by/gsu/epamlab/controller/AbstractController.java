package by.gsu.epamlab.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.epamlab.constants.ConstantsJSP;

/**
 * Servlet implementation class AbstractController
 */
@WebServlet("/AbstractController")
public class AbstractController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(TaskController.class.getName());
       
	public void forwardWithValidation(HttpServletRequest request, HttpServletResponse response, String message, String location) throws ServletException, IOException {
		request.setAttribute(ConstantsJSP.ERROR, message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(location);
		rd.forward(request, response);
	}
	
	public void forwardWithDao(HttpServletRequest request, HttpServletResponse response, Throwable e, String location) throws ServletException, IOException {
		LOGGER.log(Level.SEVERE, e.toString(), e);	
		request.setAttribute(ConstantsJSP.ERROR, e.getMessage());
		RequestDispatcher rd = getServletContext().getRequestDispatcher(location);
		rd.forward(request, response);
	}
	
	public void redirectToMain(HttpServletRequest request, HttpServletResponse response, String param) throws IOException {
		response.sendRedirect(request.getContextPath() + param);
	}
	
	public void forwardWithUrl(HttpServletRequest request, HttpServletResponse response, String param) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(param);
		rd.forward(request, response);
		
	}

}
