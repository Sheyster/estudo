package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.modelo.Produto;

public class ProdutosDAO {

	Connection connection;

	public ProdutosDAO(Connection connection) {
		this.connection = connection;
	}

	public void salva(Produto produto) throws SQLException {
		String sql = "insert into Produto(nome, descricao) values (?, ?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS)) {
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

}
