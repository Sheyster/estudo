package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.CategoriasDAO;
import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class TestaCategorias {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionPool().getConnection()) {
			List<Categoria> categorias = new CategoriasDAO(connection).listaComProdutos();

			for (Categoria categoria : categorias) {
				for (Produto produto : categoria.getProdutos()) {
					System.out.println(categoria.getNome() + " - " + produto.getNome());
				}
			}
		}
	}
}
