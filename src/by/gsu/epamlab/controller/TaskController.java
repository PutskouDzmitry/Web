package by.gsu.epamlab.controller;

import java.io.IOException;

import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gsu.epamlab.constants.ConstantsJSP;
import by.gsu.epamlab.enums.Operations;
import by.gsu.epamlab.enums.Views;
import by.gsu.epamlab.exception.DaoException;
import by.gsu.epamlab.factory.TaskFactory;
import by.gsu.epamlab.ifaces.TaskDAO;
import by.gsu.epamlab.model.beans.Task;



@WebServlet("/task")
public class TaskController extends AbstractController {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String login = (String) session.getAttribute(ConstantsJSP.USER_NAME_ATTR);
			String view = request.getParameter(ConstantsJSP.VIEW_KEY);
			Set<Operations> operations = Views.valueOf(view.toUpperCase()).getOperations();
			TaskDAO taskDao = TaskFactory.getClassFromFactory();
			List<Task> task = taskDao.getTasks(login, view);
			request.setAttribute(ConstantsJSP.OPERATIONS, operations);
			request.setAttribute(ConstantsJSP.LIST_KEY, task);
			request.setAttribute(ConstantsJSP.VIEW_KEY, view);
			forwardWithUrl(request, response, ConstantsJSP.MAIN_PAGE);
		} catch(DaoException e) {
			forwardWithDao(request, response, e, ConstantsJSP.START_PAGE);
		}
	}
}
