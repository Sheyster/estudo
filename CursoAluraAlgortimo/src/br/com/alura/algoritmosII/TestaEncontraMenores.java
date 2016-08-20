package br.com.alura.algoritmosII;

public class TestaEncontraMenores {

	public static void main(String[] args) {
		registros guilherme = new registros("Guilherme", 7);
		registros[] notas = { new registros("Andre", 4.0), new registros("Carlos", 8.5), new registros("Ana", 10), new registros("Jonas", 3.0),
				new registros("Juliana", 6.7), guilherme, new registros("Paulo", 9.0), new registros("Mariana", 5.0),
				new registros("Lucia", 9.3) };

		int quantidadeMenores = encontraMenores(guilherme, notas);
		System.out.println("Numero de menores = " + quantidadeMenores);
	}

	private static int encontraMenores(registros busca, registros[] notas) {
		int menores = 0;
		for (int atual = 0; atual < notas.length; atual++) {
			registros nota = notas[atual];
			if (nota.getValor() < busca.getValor()) {
				menores++;
			}
		}
		return menores;
	}

}
