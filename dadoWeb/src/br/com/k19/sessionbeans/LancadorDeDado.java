/**
 * 
 */
package br.com.k19.sessionbeans;

import java.util.Map;
import java.util.concurrent.Future;

/**
 * @author TON
 *
 */
public interface LancadorDeDado {

	int lanca();
	
	Future<Map<Integer, Integer>> calculaFrequencia();
}
