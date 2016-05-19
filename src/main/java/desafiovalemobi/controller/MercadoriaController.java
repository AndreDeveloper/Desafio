package desafiovalemobi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desafiovalemobi.infrastructure.MercadoriaDAO;
import desafiovalemobi.model.Mercadoria;

@WebServlet("/mercadoriacontroller.do")
public class MercadoriaController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MercadoriaDAO dao = new MercadoriaDAO();
		if (req.getParameter("acao").equals("tab")) {
			List<Mercadoria> lista = dao.selectAll();
			req.setAttribute("lista", lista);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/listaMercadoria.jsp");
			dispatcher.forward(req, resp);
		} else if (req.getParameter("acao").equals("del")) {
			Mercadoria m = new Mercadoria();
			m.setCodigo(Integer.parseInt(req.getParameter("id")));
			dao.delete(m);
			resp.sendRedirect("mercadoriacontroller.do?acao=tab");
		} else if (req.getParameter("acao").equals("alt")) {
			Mercadoria mercadoria = dao.selectById(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("mercadoria", mercadoria);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formAlterar.jsp");
			dispatcher.forward(req, resp);
		} else if (req.getParameter("acao").equals("home")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/index.jsp");
			dispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MercadoriaDAO dao = new MercadoriaDAO();
		if (req.getParameter("acao").equals("save")) {
			Mercadoria mercadoria = new Mercadoria();

			mercadoria.setCodigo(Integer.parseInt(req.getParameter("codigo")));
			mercadoria.setNome(req.getParameter("nome"));
			mercadoria.setPreco(Double.parseDouble(req.getParameter("preco")));
			mercadoria.setQuantidade(Integer.parseInt(req.getParameter("quantidade")));
			mercadoria.setTipoMercadoria(req.getParameter("tipo"));
			mercadoria.setTipoNegocio(req.getParameter("negocio"));

			dao.insert(mercadoria);
			
			String confirm = "done";
			req.setAttribute("confirmacao", confirm);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/index.jsp");
			dispatcher.forward(req, resp);

		} else if (req.getParameter("acao").equals("edit")) {
			Mercadoria mercadoria = new Mercadoria();
			mercadoria.setCodigo(Integer.parseInt(req.getParameter("id")));
			mercadoria.setNome(req.getParameter("nome"));
			mercadoria.setPreco(Double.parseDouble(req.getParameter("preco")));
			mercadoria.setQuantidade(Integer.parseInt(req.getParameter("quantidade")));
			mercadoria.setTipoMercadoria(req.getParameter("tipo"));
			mercadoria.setTipoNegocio(req.getParameter("negocio"));

			dao.update(mercadoria);
			resp.sendRedirect("mercadoriacontroller.do?acao=tab");
		}

	}

}
