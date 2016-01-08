/**
 * 
 */
package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author eltonf
 *
 */
public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/loja-virtual", "sa", "");

		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("select * from Produto");
		ResultSet resultSet = statement.getResultSet();

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String nome = resultSet.getString("nome");
			String descricao = resultSet.getString("descricao");

			System.out.println(id);
			System.out.println(nome);
			System.out.println(descricao);
		}

		resultSet.close();
		statement.close();
		connection.close();
	}
}
