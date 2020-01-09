package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/gerenciador/")
public class AuthenticationFilter implements Filter {

//	O Tomcat oferece a implementação desses dois métodos, portanto não é necessário utilizá-los 
//	se o servlet container for o mesmo.
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	// Um filter pode parar o fluxo da requisição.
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		HttpSession session = request.getSession();

		String action = "";
		
		try {
			action = request.getRequestURI().split("/")[2];
		
			if (isProtected(action, session.getAttribute("userLogged"))) {
				response.sendRedirect("loginForm");
				return;
			}
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			response.sendRedirect("loginForm");
			return;
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
	
	private final boolean isProtected(String action, Object attribute) {
		return !(action.equals("loginForm") || action.equals("login") || action.equals("empresas")) 
				&& Objects.isNull(attribute);
	}
}