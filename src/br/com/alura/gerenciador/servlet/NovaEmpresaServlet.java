//package br.com.alura.gerenciador.servlet;
//
//import java.io.IOException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import br.com.alura.gerenciador.dao.Banco;
//import br.com.alura.gerenciador.model.Empresa;
//
//@WebServlet("/novaEmpresa")
//public class NovaEmpresaServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Empresa empresa = new Empresa(req.getParameter("nome"));
//
//		String dataAbertura = req.getParameter("dataAbertura");
//		
//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//			Date data = sdf.parse(dataAbertura);
//			
//			empresa.setDataAbertura(data);
//		} catch (ParseException pe) {
//			throw new ServletException(pe);
//		}
//		
//		Banco banco = new Banco();
//		banco.adiciona(empresa);
//		
//		//Application or context scope - Inicia quando a aplicação é colocada em serviço e finaliza quando a aplicação é desligada ou reiniciada.
////		req.getServletContext().setAttribute("empresa", empresa);
//		
//		//Session scope - Inicia quando um cliente(browser window) estabelece uma conexão e finaliza quando a window é fechada.
//		req.getSession().setAttribute("empresa", empresa);
//		
//		//Request scope - Inicia no momento em que uma requisição HTTP é feita e finaliza quando a resposta HTTP é entregue.
//		req.setAttribute("", null);
//		
//		//Redirecionamento client-side
//		//Não pode conter "/"
//		resp.sendRedirect("listaEmpresas");
//	}
//}