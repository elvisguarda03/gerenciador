package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

//@WebFilter("/gerenciador/")
public class MonitoramentoFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long before = System.currentTimeMillis();
		
		String action = "";
		
		try {
			action = ((HttpServletRequest) request).getRequestURI().split("/")[2];
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			// Ignoring
		}
		
		//Executa a ação
		chain.doFilter(request, response);
	
		long after = System.currentTimeMillis();
		System.out.println("Tempo de execução da ação " + action + " -> " +  (after - before));
	}
}
