package by.gsu.epamlab.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
import by.gsu.epamlab.exception.ValidationException;
import by.gsu.epamlab.factory.TaskFactory;
import by.gsu.epamlab.ifaces.TaskDAO;

/**
 * Servlet implementation class ActionController
 */
@WebServlet("/action")
public class ActionController extends AbstractController{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String login = (String) session.getAttribute(ConstantsJSP.USER_NAME_ATTR);
			String view = (String) request.getParameter(ConstantsJSP.VIEW_KEY);
			TaskDAO task = TaskFactory.getClassFromFactory();
			task.operationTask(login, request.getParameterMap());
			redirectToMain(request, response, ConstantsJSP.MAIN_PAGE_VIEW+view);
		} catch (ValidationException e) {
			forwardWithValidation(request, response, ConstantsJSP.ERROR_MG, ConstantsJSP.MAIN_PAGE);
		} catch (DaoException e) {
			forwardWithDao(request, response, e, ConstantsJSP.START_PAGE);
		}
	}

}
