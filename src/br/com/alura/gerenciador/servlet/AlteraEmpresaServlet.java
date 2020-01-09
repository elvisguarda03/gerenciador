//package br.com.alura.gerenciador.servlet;
//
//import java.io.IOException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Optional;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import br.com.alura.gerenciador.dao.Banco;
//import br.com.alura.gerenciador.model.Empresa;
//
//@WebServlet("/alteraEmpresa")
//public class AlteraEmpresaServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String paramId = request.getParameter("id");
//		Integer id = Integer.valueOf(paramId);
//
//		Banco banco = new Banco();
//
//		Optional<Empresa> optional = banco.findById(id);
//		optional.ifPresentOrElse(empresa -> {
//			request.setAttribute("empresa", empresa);
//
//			try {
//				RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
//				rd.forward(request, response);
//			} catch (ServletException | IOException e) {
//				e.printStackTrace();
//			}
//		}, () -> {
//			try {
//				response.sendRedirect("listaEmpresas");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		});
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String paramId = req.getParameter("id");
//		String nome = req.getParameter("nome");
//		String dataAbertura = req.getParameter("dataAbertura");
//
//		Integer id = Integer.valueOf(paramId);
//
//		Banco banco = new Banco();
//
//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//			Date data = sdf.parse(dataAbertura);
//
//			banco.findById(id).ifPresentOrElse(empresa -> {
//				empresa.setDataAbertura(data);
//				empresa.setNome(nome);
//				
//				try {
//					resp.sendRedirect("listaEmpresas");
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}, () -> {
//				req.getSession().setAttribute("error", "Empresa inexistente!");
//
//				try {
//					resp.sendRedirect("listaEmpresas");
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			});
//		} catch (ParseException pe) {
//			throw new RuntimeException("Data inválida!");
//		}
//	}
//}