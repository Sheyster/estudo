package br.com.manipulacaostring;

public class TesteStringS2 {

	public static void main(String[] args) {

		String input = "abcbe";
		long tempoInicial = System.currentTimeMillis();
		boolean teste = elementoUnico(input);
		long tempoFinal = System.currentTimeMillis();
		System.out.println("Executado em = " + (tempoFinal - tempoInicial)
				+ " ms");
		System.out.println(teste);
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

}
