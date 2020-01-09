package br.com.alura.gerenciador.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.Banco;
import br.com.alura.gerenciador.model.Usuario;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("senha");
		
		Banco banco = new Banco();
		
		Optional<Usuario> record = banco.findByLoginAndSenha(login, password);
		if (!record.isPresent()) {
			return "redirect:loginForm";
		}
		
		request.getSession().setAttribute("userLogged", record.get());
		
		return "redirect:listaEmpresa";
	}
}
