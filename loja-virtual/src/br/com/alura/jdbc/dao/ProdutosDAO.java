package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class ProdutosDAO {

	Connection connection;

	public ProdutosDAO(Connection connection) {
		this.connection = connection;
	}

	public void salva(Produto produto) throws SQLException {
		String sql = "insert into Produto(nome, descricao) values (?, ?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getDescricao());

			stmt.execute();

			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) {
					int id = rs.getInt("id");
					produto.setId(id);
				}
			}

		}
	}

	public List<Produto> lista() throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();
		String sql = "select * from produto";

		try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.execute();
			transformaResultadoEmProdutos(produtos, stmt);
		}

		return produtos;
	}

	private void transformaResultadoEmProdutos(List<Produto> produtos, PreparedStatement stmt) throws SQLException {
		try (ResultSet rs = stmt.getResultSet()) {
			while (rs.next()) {
				Produto produto = new Produto(rs.getString(2), rs.getString(3));
				produto.setId(rs.getInt(1));
				produtos.add(produto);
			}
		}
	}

	public List<Produto> busca(Categoria categoria) throws SQLException {
		List<Produto> produtos = new ArrayList<>();
		String sql = "select * from produto p where p.categoria_id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, categoria.getId());
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					Produto produto = new Produto(rs.getString(2), rs.getString(3));
					produto.setId(rs.getInt(1));
					produtos.add(produto);
				}
			}
		}

		return produtos;
	}

}
