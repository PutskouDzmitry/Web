package by.gsu.epamlab.controller;

import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
 * Servlet implementation class RegistrateController
 */
@WebServlet("/reg")
public class RegistrateController extends AbstractController {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String ERROR = "This account already exists";
		try {
			HttpSession session = request.getSession();
			String login = request.getParameter(ConstantsJSP.LOGIN_PARAM);
			String password = request.getParameter(ConstantsJSP.PASSWORD_PARAM);
			UserDAO userDAO = UserFactory.getClassFromFactory();
			Optional<User> optUser = userDAO.addAndGetUser(login, password);
			User user = optUser.orElseThrow(() -> new ValidationException(ERROR));
			session.setAttribute(ConstantsJSP.USER_ATTR, user);
			session.setAttribute(ConstantsJSP.USER_NAME_ATTR, user.getLogin());
			redirectToMain(request, response, ConstantsJSP.PARAM_TODAY);
		} catch(DaoException e) {
			forwardWithDao(request, response, e, ConstantsJSP.START_PAGE);
		} catch(ValidationException e) {
			forwardWithValidation(request, response, e.getMessage(), ConstantsJSP.REG_PAGE);
		}
	}
}
