package br.com.alura.algoritmosII;

public class TestaEncontraMenores {

	public static void main(String[] args) {
		Nota guilherme = new Nota("Guilherme", 7);
		Nota[] notas = { new Nota("Andre", 4.0), new Nota("Carlos", 8.5), new Nota("Ana", 10), new Nota("Jonas", 3.0),
				new Nota("Juliana", 6.7), guilherme, new Nota("Paulo", 9.0), new Nota("Mariana", 5.0),
				new Nota("Lucia", 9.3) };

		int quantidadeMenores = encontraMenores(guilherme, notas);
		System.out.println("Numero de menores = " + quantidadeMenores);
	}

	private static int encontraMenores(Nota busca, Nota[] notas) {
		int menores = 0;
		for (int atual = 0; atual < notas.length; atual++) {
			Nota nota = notas[atual];
			if (nota.getValor() < busca.getValor()) {
				menores++;
			}
		}
		return menores;
	}

}
