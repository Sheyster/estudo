package br.com.alura.algoritmos;

public class TestaOrdenacao {

	public static void main(String[] args) {
		Produto produtos[] = { new Produto("Lamborghini", 1000000), new Produto("Jipe", 46000),
				new Produto("Brasilia", 16000), new Produto("Smart", 46000), new Produto("Fusca", 17000) };

		// selectionSort(produtos);
		insertionSort(produtos);

		for (Produto produto : produtos) {
			System.out.println("Nome " + produto.getNome() + " valor " + produto.getValor());
		}

	}

	private static void insertionSort(Produto[] produtos) {
		for (int atual = 0; atual < produtos.length; atual++) {
			int analise = atual;
			while (analise > 0 && produtos[analise].getValor() < produtos[analise - 1].getValor()) {
				Produto produtoAnalise = produtos[analise];
				Produto produtoAnaliseMeno1 = produtos[analise - 1];
				produtos[analise] = produtoAnaliseMeno1;
				produtos[analise - 1] = produtoAnalise;
				analise--;
			}
		}
	}

	// Quando utilizamos somente um "for" dentro de outro "for" como no caso do
	// "selectionSort" que tem o seu for de elementos e utiliza o "buscaMenor"
	// que contem outro "for", podemos chamar de "quadratico"
	private static void selectionSort(Produto[] produtos) {
		// A questão de utilizar "produtos.length - 1" é porque não precisa
		// ordenar o último elemento já que ele é o ultimo e o maior
		for (int atual = 0; atual < produtos.length - 1; atual++) {
			int menor = buscarMenor(produtos, atual, produtos.length);
			Produto produtoAtual = produtos[atual];
			Produto produtoMenor = produtos[menor];
			produtos[atual] = produtoMenor;
			produtos[menor] = produtoAtual;
		}
	}

	// Quando utilizamos somente um for como no caso desta busca podemos chamar
	// de "linear"
	private static int buscarMenor(Produto[] produtos, int inicio, int ultimo) {
		int maisBarato = inicio;

		for (int atual = inicio; atual < ultimo; atual++) {
			if (produtos[atual].getValor() < produtos[maisBarato].getValor()) {
				maisBarato = atual;
			}
		}
		return maisBarato;
	}

}
