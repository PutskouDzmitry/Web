package by.gsu.epamlab.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter({"/log", "/reg" , "/logout", "/web"})
public class TypedUrlFilter implements Filter {
	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		final String REFFER = "referer";
		HttpServletRequest httpRequest = (HttpServletRequest) request; 
		HttpServletResponse httpResponse = (HttpServletResponse) response; 
		String refferer = httpRequest.getHeader(REFFER);
		if (refferer == null) {
			httpResponse.sendRedirect(httpRequest.getContextPath());
			return;
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
