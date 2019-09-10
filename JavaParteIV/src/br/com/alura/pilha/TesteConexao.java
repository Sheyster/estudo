package br.com.alura.pilha;

public class TesteConexao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try (Conexao conexao = new Conexao();) {
			conexao.leDados();
		} catch (IllegalStateException ex) {
			System.out.println("Deu erro na conex�o!");
		}

		// ------------------------------
		// O c�digo abaixo funciona mas ficou um pouco complicade de ler, vamos tentar
		// melhora-lo
//		Conexao conexao = null;
//		try {
//			conexao = new Conexao();
//			conexao.leDados();
//		} catch (IllegalStateException ex) {
//			System.out.println("Deu erro na conex�o!");
//		} finally {
//			System.out.println("Finally");
//			if (conexao != null) {
//				conexao.close();
//			}
//		}

	}

}
