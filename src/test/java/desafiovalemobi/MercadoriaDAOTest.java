package desafiovalemobi;


import java.util.List;

import desafiovalemobi.infrastructure.MercadoriaDAO;
import desafiovalemobi.model.Mercadoria;

public class MercadoriaDAOTest {
	
	private static void testInsert(){
		Mercadoria mercadoria = new Mercadoria();
		mercadoria.setCodigo(6);
		mercadoria.setNome("testeNome");
		mercadoria.setPreco(10.50);
		mercadoria.setQuantidade(10);
		mercadoria.setTipoMercadoria("testeTipoMercadoria");
		mercadoria.setTipoNegocio("testTipoNegocio");
		
		MercadoriaDAO dao = new MercadoriaDAO();
		
		long afRows = dao.insert(mercadoria);
		System.out.println(afRows);
	}
	private static void testupdate(){
		Mercadoria mercadoria = new Mercadoria();
		mercadoria.setCodigo(3);
		mercadoria.setNome("testeupdate");
		mercadoria.setPreco(10.50);
		mercadoria.setQuantidade(10);
		mercadoria.setTipoMercadoria("testeTipoMercadoria");
		mercadoria.setTipoNegocio("testTipoNegocio");
		
		MercadoriaDAO dao = new MercadoriaDAO();
		
		long afRows = dao.update(mercadoria);
		System.out.println(afRows);
	}
	private static void testdelete(){
		Mercadoria mercadoria = new Mercadoria();
		mercadoria.setCodigo(3);
		mercadoria.setNome("testeupdate");
		mercadoria.setPreco(10.50);
		mercadoria.setQuantidade(10);
		mercadoria.setTipoMercadoria("testeTipoMercadoria");
		mercadoria.setTipoNegocio("testTipoNegocio");
		
		MercadoriaDAO dao = new MercadoriaDAO();
		
		long afRows = dao.delete(mercadoria);
		System.out.println(afRows);
	}
	private static void testSelectById(){
		MercadoriaDAO dao = new MercadoriaDAO();
		Mercadoria mercadoria = dao.selectById(4);
		System.out.println(mercadoria.toString());
	}
	private static void testSelectBynome(){
		MercadoriaDAO dao = new MercadoriaDAO();
		List<Mercadoria> resultado = dao.selectByName("test");
		for(Mercadoria mercadoria: resultado){
		System.out.println(mercadoria.toString());
		}
	}
	private static void testSelectAll(){
		MercadoriaDAO dao = new MercadoriaDAO();
		List<Mercadoria> resultado = dao.selectAll();
		for(Mercadoria mercadoria: resultado){
			System.out.println(mercadoria.toString());
		}
	}
	
	

	public static void main(String[] args) {
		//testInsert();
		//testupdate();
		//testdelete();
		//testSelectById();
		//testSelectBynome();
		testSelectAll();
	}
}
