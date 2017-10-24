package online.shixun.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import online.shixun.model.Account;

@WebFilter("/*")
public class Filter implements javax.servlet.Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		Account account = (Account) session.getAttribute("account");
		String path = httpRequest.getServletPath();

		if (account != null || path.indexOf("/login.html") != -1 || path.indexOf("/register.html") != -1
				|| path.indexOf("resources") != -1 || path.indexOf("/user_doLogin") != -1
				|| path.indexOf("/user_usernameIsRepeat") != -1 || path.indexOf("/user_doRegistered") != -1) {
			chain.doFilter(request, response);
		} else {
			httpResponse.sendRedirect("/FinancialElves/login.html");
		}

	}

	@Override
	public void destroy() {

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
