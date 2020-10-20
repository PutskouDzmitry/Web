package by.gsu.epamlab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.epamlab.constants.ConstantsJSP;


@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute(ConstantsJSP.USER_ATTR);
		request.getSession().removeAttribute(ConstantsJSP.USER_NAME_ATTR);
		response.sendRedirect(getServletContext().getContextPath() + ConstantsJSP.START_PAGE);
	}
}
