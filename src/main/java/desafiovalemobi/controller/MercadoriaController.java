package desafiovalemobi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desafiovalemobi.infrastructure.MercadoriaDAO;
import desafiovalemobi.model.Mercadoria;

@WebServlet("/mercadoriacontroller.do")
public class MercadoriaController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		System.out.println("chamou!!");	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Mercadoria mercadoria = new Mercadoria();
		MercadoriaDAO dao = new MercadoriaDAO();
		
		mercadoria.setCodigo(Integer.parseInt(req.getParameter("codigo")));
		mercadoria.setNome(req.getParameter("nome"));
		mercadoria.setPreco(Double.parseDouble(req.getParameter("preco")));
		mercadoria.setQuantidade(Integer.parseInt(req.getParameter("quantidade")));
		mercadoria.setTipoMercadoria(req.getParameter("tipo"));
		mercadoria.setTipoNegocio(req.getParameter("negocio"));
		
		dao.insert(mercadoria);
		
		resp.getWriter().println("Mercadoria registrada no sistema com sucesso!");
	}
	
}
