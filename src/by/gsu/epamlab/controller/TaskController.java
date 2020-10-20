package by.gsu.epamlab.controller;

import java.io.IOException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gsu.epamlab.constants.ConstantsJSP;
import by.gsu.epamlab.exception.DaoException;
import by.gsu.epamlab.factory.TaskFactory;
import by.gsu.epamlab.ifaces.TaskDAO;
import by.gsu.epamlab.model.beans.Task;



@WebServlet("/task")
public class TaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(TaskController.class.getName());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession();
			String login = (String) session.getAttribute(ConstantsJSP.USER_NAME_ATTR);
			String view = request.getParameter(ConstantsJSP.VIEW_KEY);
			TaskDAO taskDao = TaskFactory.getClassFromFactory();
			List<Task> task = taskDao.getTasks(login, view);
			request.setAttribute(ConstantsJSP.LIST_KEY, task);
			request.setAttribute(ConstantsJSP.VIEW_KEY, view);
			RequestDispatcher rd = request.getRequestDispatcher(ConstantsJSP.MAIN_PAGE);
			rd.forward(request, response);
		} catch(DaoException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
			request.setAttribute(ConstantsJSP.ERROR, e);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(ConstantsJSP.START_PAGE);
			rd.forward(request, response);
		}
	}
	
}
