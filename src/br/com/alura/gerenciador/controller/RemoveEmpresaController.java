package br.com.alura.gerenciador.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.Banco;

public class RemoveEmpresaController implements Controller {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		banco.remove(id);
	
		return "redirect:listaEmpresa";
	}
}