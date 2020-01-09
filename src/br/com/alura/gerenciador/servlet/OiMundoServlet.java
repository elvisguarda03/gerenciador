package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Modifica o comportamento padrão do Tomcat e instancia essa servlet no momento em que ele for iniciado.
//@WebServlet(value = "/oi", loadOnStartup = 1)
public class OiMundoServlet extends HttpServlet {
	private static final long serialVersionUID = -398178193117594167L;

//	Servlet viverá enquanto o container(Tomcat) viver. Singleton.
//	Tomcat é um middleware
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html>");
		writer.println("<body>");
		
		writer.println("Oi mundo, parabéns vc escreveu o primeiro servlet");
		
		writer.println("</body>");
		writer.println("</html");
		
		System.out.println("O servlet OiMundoServlet foi chamado.");
	}
}
