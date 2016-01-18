package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.jdbc.modelo.Produto;

public class TestaProdutoDAO {

	private static final String nome = "Mesa Azul";
	private static final String descricao = "Mesa com 4 pés";

	public static void main(String[] args) throws SQLException {

		Produto mesa = new Produto("Mesa Azul", "Mesa com 4 pés");

		try (Connection connection = new ConnectionPool().getConnection()) {
			ProdutosDAO dao = new ProdutosDAO(connection);
			dao.salva(mesa);
		}
	}

}
