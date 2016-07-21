package br.com.manipulacaostring;

import java.util.HashSet;
import java.util.Set;

public class TesteStringS2 {

	public static void main(String[] args) {

		String input = "abcde";
		long tempoInicial = System.currentTimeMillis();
		boolean teste = elementoUnico(input);
		long tempoFinal = System.currentTimeMillis();
		System.out.println("Executado em = " + (tempoFinal - tempoInicial)
				+ " ms");
		System.out.println(teste);
		
		System.out.println(elemento(input));
	}

	private static boolean elementoUnico(String input) {
		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j < input.length(); j++) {
				if (input.charAt(i) == input.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean elemento(String input){
		int x = input.length();
		Set<Character> tes = new HashSet<Character>();
		for (int i = 0; i < input.length(); i++) {
			tes.add(input.charAt(i));
		}
		int y = tes.size();
		if(x != y){
			return false;
		}
		
		return true;
	}

}
