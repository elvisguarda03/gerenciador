package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.controller.Controller;

@WebServlet("/")
public class EntradaUnicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String BASE_PATH = "br.com.alura.gerenciador.controller.";

//	O Server Container(Tomcat) "esconde" a pasta WEB-INF e não permite que alguma requisição tenha acesso, 
//	pois há arquivos como o web.xml e os nossos JARs dentro desse diretório.

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String action = request.getRequestURI().split("/")[2];
			String fqn = BASE_PATH + 
					Character.toUpperCase(action.charAt(0)) + action.substring(1) + "Controller";
			
			Class<?> clazz = Class.forName(fqn);
			
			Controller controller = (Controller) clazz.getConstructor().newInstance();
			
			String name = controller.execute(request, response);
			String[] parts = name.split(":");

			if (parts[0].equals("forward")) {
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/" + parts[1]);
				rd.forward(request, response);
				
				return;
			} 
			
			response.sendRedirect(parts[1]);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
			response.sendRedirect("listaEmpresa");
		}
	}

//		if (action.contains("listaEmpresas")) {
//			ListaEmpresaController listaEmpresa = new ListaEmpresa();
//			name = listaEmpresa.findAll(request, response);
//		} else if (action.contains("mostraEmpresa")) {
//			MostraEmpresa mostraEmpresa = new MostraEmpresa();
//			name = mostraEmpresa.alterar(request, response);
//		} else if (action.contains("alteraEmpresa")) {
//			AlteraEmpresa alteraEmpresa = new AlteraEmpresa();
//			name = alteraEmpresa.alterar(request, response);
//		} else if (action.contains("removeEmpresa")) {
//			RemoveEmpresa removeEmpresa = new RemoveEmpresa();
//			name = removeEmpresa.remover(request, response);
//		} else if (action.contains("novaEmpresa")) {
//			NovaEmpresa novaEmpresa = new NovaEmpresa();
//			name = novaEmpresa.criar(request, response);
//		} else if (action.contains("novaEmpresaForm")) {
//			NovaEmpresaForm novaEmpresaForm = new NovaEmpresaForm();
//			name = novaEmpresaForm.criaEmpresa();
//		}
}