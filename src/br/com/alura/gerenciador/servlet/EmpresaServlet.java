package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.dao.Banco;
import br.com.alura.gerenciador.model.Empresa;

@WebServlet("/empresas")
public class EmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Empresa> empresas = new Banco().getEmpresas();

		String header = request.getHeader("Accept");

		PrintWriter writer = response.getWriter();
		
		if (header.contains("xml")) {
			XStream xstream = new XStream();
			xstream.alias("empresa", Empresa.class);
			
			String xml = xstream.toXML(empresas);

			response.setContentType("application/xml");
			write(writer, xml);
		} else if (header.contains("json")) {
			Gson gson = new Gson();
			String json = gson.toJson(empresas);
			
			response.setContentType("application/json");
			write(writer, json);
		} else {
			response.setContentType("application/json");
			write(writer, "{message: \"No content\"}");
		}
	}
	
	private void write(PrintWriter writer, String format) {
		writer.print(format);
	}
}