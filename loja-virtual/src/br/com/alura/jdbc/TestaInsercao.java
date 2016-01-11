package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();

		boolean resultado = statement
				.execute(
						"insert into produto (nome, descricao) values ('Notebook', 'Notebook i5')",
						Statement.RETURN_GENERATED_KEYS);

		ResultSet resultSet = statement.getGeneratedKeys();

		System.out.println("O resultado foi: " + resultado);

		while (resultSet.next()) {
			System.out.println(resultSet.getString("id"));
		}

		resultSet.close();
		statement.close();
		connection.close();
	}

}
