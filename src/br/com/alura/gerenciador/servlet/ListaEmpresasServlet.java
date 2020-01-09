//package br.com.alura.gerenciador.servlet;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import br.com.alura.gerenciador.dao.Banco;
//
//@WebServlet("/listaEmpresas")
//public class ListaEmpresasServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	//RequestDispatcher - Delega o fluxo da requisição para qualquer recurso disponível.
//	
//	//Dá suporte para métodos (Get e Post).
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setAttribute("empresas", new Banco().getEmpresas());
//		
//		//Redirecionamento Server-side
//		request.getRequestDispatcher("/listaEmpresa.jsp").forward(request, response);
//	}
//}