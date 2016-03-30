/**
 * 
 */
package br.com.alura.threads.cap2;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author eltonf
 *
 */
public class BuscaNome implements Runnable {

	private String nomeArquivo;
	private String procurado;

	public BuscaNome(String procurado, String nomeArquivo) {
		this.procurado = procurado;
		this.nomeArquivo = nomeArquivo;
	}

	@Override
	public void run() {
		Scanner s;
		Properties properties;
		try {
			int numeroLinha = 1;
			properties = new Properties();
			properties.load(new FileInputStream("./properties/dados.properties"));
			s = new Scanner(new FileReader(nomeArquivo));
			while (s.hasNextLine()) {
				String line = s.nextLine();
				if (line.contains(procurado)) {
					System.out.println("Encontrado: " + nomeArquivo + " - " + numeroLinha + ": " + line);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
