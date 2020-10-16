package by.gsu.epamlab.controller;

import java.io.IOException;
import java.util.Optional;
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
import by.gsu.epamlab.factory.UserFactory;
import by.gsu.epamlab.ifaces.UserDAO;
import by.gsu.epamlab.model.beans.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/log")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String ERROR = "Wrong login or password";
		try {
			HttpSession session = request.getSession();
			String login = request.getParameter(ConstantsJSP.LOGIN_PARAM);
			String password = request.getParameter(ConstantsJSP.PASSWORD_PARAM);
			UserDAO userDAO = UserFactory.getClassFromFactory();
			Optional<User> optUser = userDAO.getUser(login, password);
			User user = optUser.orElseThrow(() -> new ValidationException(ERROR));
			session.setAttribute(ConstantsJSP.USER_ATTR, user);
			session.setAttribute(ConstantsJSP.USER_NAME_ATTR, user.getLogin());
			response.sendRedirect(request.getContextPath() + ConstantsJSP.MAIN_PAGE);
		} catch(DaoException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
			request.setAttribute(ConstantsJSP.ERROR,ConstantsJSP.ERROR_MG);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(ConstantsJSP.START_PAGE);
			rd.forward(request, response);
		} catch(ValidationException e) {
			request.setAttribute(ConstantsJSP.ERROR,e);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(ConstantsJSP.LOGIN_PAGE);
			rd.forward(request, response);
		}
	}

}
