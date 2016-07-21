package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class CategoriasDAO {

	private Connection connection;

	public CategoriasDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Categoria> getLista() throws SQLException {
		System.out.println("Executando uma query");
		List<Categoria> categorias = new ArrayList<>();

		String sql = "select * from Categoria";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String nome = rs.getString("nome");
					Categoria categoria = new Categoria(id, nome);
					categorias.add(categoria);
				}
			}
		}
		return categorias;
	}

	public List<Categoria> listaComProdutos() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();
		Categoria ultima = null;
		String sql = "Select c.id as c_id, c.nome as c_nome, p.id as p_id, p.nome as p_nome, p.descricao as p_descricao from categoria c join produto p on p.categoria_id = c.id";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.execute();

			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					if (ultima == null || !ultima.getNome().equals(rs.getString("c_nome"))) {
						Categoria categoria = new Categoria(rs.getInt("c_id"), rs.getString("c_nome"));
						categorias.add(categoria);
						ultima = categoria;
					}
					Produto produto = new Produto(rs.getString("p_nome"), rs.getString("p_descricao"));
					produto.setId(rs.getInt("p_id"));
					ultima.adiciona(produto);
				}
			}
		}

		return categorias;
	}
}
