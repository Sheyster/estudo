/**
 * 
 */
package br.com.alura.designpatterns.cap1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.alura.designpatterns.cap1.factory.ConnectionFactory;

/**
 * @author eltonf
 *
 */
public class TesteConnection {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();

		PreparedStatement pst = connection.prepareStatement("select * from ");
		pst.executeQuery();
	}

}
