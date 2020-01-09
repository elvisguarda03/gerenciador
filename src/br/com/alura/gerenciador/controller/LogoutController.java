package br.com.alura.gerenciador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Destroi o cookie - Invalida a sess�o excluindo a mesma da mem�ria.
		request.getSession().invalidate();
		
		return "redirect:loginForm";
	}
}
