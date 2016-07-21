package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		try (Connection connection = new ConnectionPool().getConnection()) {
			connection.setAutoCommit(false);

			String sql;
			sql = "insert into produto (nome, descricao) values (?, ?)";

			try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				adiciona("TV LCD", "32 polegadas", statement);
				adiciona("Blueray", "Full HDMI", statement);
				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
				connection.rollback();
				System.out.println("Roolback efetuado");
			}
		}
	}

	/**
	 * @param nome
	 * @param descrição
	 * @param statement
	 * @throws SQLException
	 */
	private static void adiciona(String nome, String descrição, PreparedStatement statement) throws SQLException {
		if (nome.equals("Blueray")) {
			throw new IllegalArgumentException("Problema ocorrido");
		}

		statement.setString(1, nome);
		statement.setString(2, descrição);

		try (ResultSet resultSet = statement.getGeneratedKeys()) {
			while (resultSet.next()) {
				System.out.println(resultSet.getString("id"));
			}
		}
	}

}
