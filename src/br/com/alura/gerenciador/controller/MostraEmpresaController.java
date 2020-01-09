package br.com.alura.gerenciador.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class MostraEmpresaController implements Controller {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		Banco banco = new Banco();

		Optional<Empresa> optional = banco.findById(id);
		if (optional.isPresent()) {
			request.setAttribute("empresa", optional.get());

			return "forward:formAlteraEmpresa.jsp";
		}

		return "redirect:listaEmpresa";
	}
}