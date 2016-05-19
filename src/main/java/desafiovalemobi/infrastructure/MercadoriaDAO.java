package desafiovalemobi.infrastructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import desafiovalemobi.model.Mercadoria;

public class MercadoriaDAO {

	public long insert(Mercadoria mercadoria) {
		long idGerado = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = 
					"INSERT INTO `desafio`.`mercadoria` "
					+ "(`codigo`,"
					+ " `tipo_mercadoria`,"
					+ " `nome`, "
					+ " `quantidade`,"
					+ " `preco`,"
					+ " `tipo_negocio`) "
					+ "VALUES (?, ?, ?, ?, ?, ?);";

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, mercadoria.getCodigo());
			stmt.setString(2, mercadoria.getTipoMercadoria());
			stmt.setString(3, mercadoria.getNome());
			stmt.setInt(4, mercadoria.getQuantidade());
			stmt.setDouble(5, mercadoria.getPreco());
			stmt.setString(6, mercadoria.getTipoNegocio());
			
			stmt.executeUpdate();

			ResultSet r = stmt.getGeneratedKeys();
			r.next();

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return idGerado;
	}

	public int update(Mercadoria mercadoria) {
		int affectedRows = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = 
					"UPDATE `desafio`.`mercadoria` SET "
					+ "`codigo`=?, "
					+ "`tipo_mercadoria`=?, "
					+ "`nome`=?, "
					+ "`quantidade`=?, "
					+ "`preco`=?, "
					+ "`tipo_negocio`=? "
					+ "WHERE  `codigo`=?;";

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, mercadoria.getCodigo());
			stmt.setString(2, mercadoria.getTipoMercadoria());
			stmt.setString(3, mercadoria.getNome());
			stmt.setInt(4, mercadoria.getQuantidade());
			stmt.setDouble(5, mercadoria.getPreco());
			stmt.setString(6, mercadoria.getTipoNegocio());
			stmt.setInt(7, mercadoria.getCodigo());

			affectedRows = stmt.executeUpdate();

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}

	public int delete(Mercadoria mercadoria) {
		int affectedRows = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "DELETE FROM `desafio`.`mercadoria` WHERE  `codigo`=?;";

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, mercadoria.getCodigo());

			affectedRows = stmt.executeUpdate();

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}

	public Mercadoria selectById(int id) {
		Mercadoria mercadoria = new Mercadoria();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM mercadoria WHERE codigo = ?";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				mercadoria.setCodigo(rs.getInt("codigo"));
				mercadoria.setNome(rs.getString("nome"));
				mercadoria.setPreco(rs.getDouble("preco"));
				mercadoria.setQuantidade(rs.getInt("quantidade"));
				mercadoria.setTipoMercadoria(rs.getString("tipo_mercadoria"));
				mercadoria.setTipoNegocio(rs.getString("tipo_negocio"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mercadoria;
	}

	public List<Mercadoria> selectByName(String name) {
		List<Mercadoria> mercadorias = new ArrayList<Mercadoria>();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM mercadoria WHERE nome LIKE ?;";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, "%" + name + "%");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Mercadoria mercadoria = new Mercadoria();
				
				mercadoria.setCodigo(rs.getInt("codigo"));
				mercadoria.setNome(rs.getString("nome"));
				mercadoria.setPreco(rs.getDouble("preco"));
				mercadoria.setQuantidade(rs.getInt("quantidade"));
				mercadoria.setTipoMercadoria(rs.getString("tipo_mercadoria"));
				mercadoria.setTipoNegocio(rs.getString("tipo_negocio"));
				
				mercadorias.add(mercadoria);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mercadorias;
	}

	public List<Mercadoria> selectAll() {
		List<Mercadoria> mercadorias = new ArrayList<Mercadoria>();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM mercadoria;";
			PreparedStatement stmt = con.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Mercadoria mercadoria = new Mercadoria();
				
				mercadoria.setCodigo(rs.getInt("codigo"));
				mercadoria.setNome(rs.getString("nome"));
				mercadoria.setPreco(rs.getDouble("preco"));
				mercadoria.setQuantidade(rs.getInt("quantidade"));
				mercadoria.setTipoMercadoria(rs.getString("tipo_mercadoria"));
				mercadoria.setTipoNegocio(rs.getString("tipo_negocio"));
				
				mercadorias.add(mercadoria);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mercadorias;
	}
}
