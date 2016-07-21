/**
 * 
 */
package br.com.alura.threads.cap4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author eltonf
 *
 */
public class IncrementaVariavel implements Runnable {

	private static Integer total = 0;

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			synchronized (total) {
				total++;
				System.out.println(total);
			}
		}
	}

	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			es.execute(new IncrementaVariavel());
		}
		es.shutdown();
	}

}
