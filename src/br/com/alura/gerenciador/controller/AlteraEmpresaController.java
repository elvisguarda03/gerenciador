package br.com.alura.gerenciador.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class AlteraEmpresaController implements Controller {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String paramId = request.getParameter("id");
		String nome = request.getParameter("nome");
		String dataAbertura = request.getParameter("dataAbertura");

		Integer id = Integer.valueOf(paramId);

		Banco banco = new Banco();

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date data = sdf.parse(dataAbertura);

			Optional<Empresa> optional = banco.findById(id);
			if (optional.isPresent()) {
				Empresa empresa = optional.get();
				empresa.setDataAbertura(data);
				empresa.setNome(nome);

				return "redirect:listaEmpresa";
			}

			request.getSession().setAttribute("error", "Empresa inexistente!");

			return "redirect:listaEmpresa";
		} catch (ParseException pe) {
			throw new RuntimeException("Data inválida!");
		}
	}
}