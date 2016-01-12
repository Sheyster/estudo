package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		Connection connection = Database.getConnection();
		String nome = "Notebook";
		String descrição = "Dell´s";

		String sql;
		sql = "insert into produto (nome, descricao) values (?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setString(0, nome);
		statement.setString(1, descrição);

		ResultSet resultSet = statement.getGeneratedKeys();

		while (resultSet.next()) {
			System.out.println(resultSet.getString("id"));
		}

		resultSet.close();
		statement.close();
		connection.close();
	}

}
