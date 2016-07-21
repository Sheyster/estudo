/**
 * 
 */
package br.com.alura.threads.cap5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author eltonf
 *
 */
public class Principal {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		NotaFiscal[] notas = new NotaFiscal[10000];
		Random r = new Random(System.currentTimeMillis());

		for (int i = 0; i < 10000; i++) {
			notas[i] = new NotaFiscal(Math.abs(r.nextInt() % 1000));
		}

		ExecutorService es = Executors.newCachedThreadPool();
		List<Future<Integer>> resultados = new ArrayList<Future<Integer>>();

		for (int i = 0; i < 10000; i += 100) {
			SomaNotas somador = new SomaNotas(notas, i, i + 100);
			Future<Integer> resultado = es.submit(somador);
			resultados.add(resultado);
		}

		Long totalNotas = 0l;
		for (Future<Integer> resultado : resultados) {
			totalNotas += resultado.get();
		}

		System.out.println("O total das notas são: " + totalNotas);
		es.shutdown();
	}
}
