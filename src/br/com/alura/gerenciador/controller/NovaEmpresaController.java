package br.com.alura.gerenciador.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class NovaEmpresaController implements Controller {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Empresa empresa = new Empresa(request.getParameter("nome"));

		String dataAbertura = request.getParameter("dataAbertura");
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			empresa.setDataAbertura(sdf.parse(dataAbertura));
		} catch (ParseException pe) {
			throw new ServletException(pe);
		}
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		//Application or context scope - Inicia quando a aplicação é colocada em serviço e finaliza quando a aplicação é desligada ou reiniciada.
//		req.getServletContext().setAttribute("empresa", empresa);
		
		//Session scope - Inicia quando um cliente(browser window) estabelece uma conexão e finaliza quando a window é fechada.
		request.getSession().setAttribute("empresa", empresa);
		
		//Request scope - Inicia no momento em que uma requisição HTTP é feita e finaliza quando a resposta HTTP é entregue.
//		request.setAttribute("", null);
		
		//Redirecionamento client-side
		//Não pode conter "/"
		
		return "redirect:listaEmpresas";
	}
}