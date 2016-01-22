package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.ProdutosDAO;
import br.com.alura.jdbc.modelo.Produto;

public class TestaProdutoDAO {

	private static final String nome = "Mesa Vermelha";
	private static final String descricao = "Mesa com 4 pés";

	public static void main(String[] args) throws SQLException {

		Produto mesa = new Produto(nome, descricao);

		try (Connection connection = new ConnectionPool().getConnection()) {
			ProdutosDAO dao = new ProdutosDAO(connection);
			// dao.salva(mesa);

			List<Produto> produtos = dao.lista();

			for (Produto produto : produtos) {
				System.out.println(produto);
			}
		}
	}

}
