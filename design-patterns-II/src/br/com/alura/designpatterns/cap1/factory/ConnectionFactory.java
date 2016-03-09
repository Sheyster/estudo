/**
 * 
 */
package br.com.alura.designpatterns.cap1.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author eltonf
 *
 */
public class ConnectionFactory {
	public Connection getConnection() {
		String banco = System.getenv("tipoBanco");
		Connection conexao;

		try {
			if (banco.equals("mysql")) {
				conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/meuBanco", "teste", "123");
			} else {
				conexao = DriverManager.getConnection("jdbc:postgres://localhost:3306/meuBanco", "teste", "123");
			}

			return conexao;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
