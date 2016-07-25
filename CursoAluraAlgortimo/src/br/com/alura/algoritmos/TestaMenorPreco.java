package br.com.alura.algoritmos;

public class TestaMenorPreco {

	public static void main(String[] args) {

		// Produto produtos[] = new Produto[5];
		// produtos[0] = new Produto("Lamborghini", 1000000);
		// produtos[1] = new Produto("Jipe", 46000);
		// produtos[2] = new Produto("Brasilia", 16000);
		// produtos[3] = new Produto("Smart", 46000);
		// produtos[4] = new Produto("Fusca", 17000);

		Produto produtos[] = { new Produto("Lamborghini", 1000000), new Produto("Jipe", 46000),
				new Produto("Brasilia", 16000), new Produto("Smart", 46000), new Produto("Fusca", 17000) };

		int maisBarato = buscarMenor(produtos);

		int maisCaro = buscarMaior(produtos);

		System.out.println(produtos[maisBarato].getNome() + ", valor R$ " + produtos[maisBarato].getValor());

		System.out.println(produtos[maisCaro].getNome() + ", valor R$ " + produtos[maisCaro].getValor());
	}

	private static int buscarMenor(Produto[] produtos) {
		int maisBarato = 0;

		for (int atual = 0; atual < produtos.length; atual++) {
			if (produtos[atual].getValor() < produtos[maisBarato].getValor()) {
				maisBarato = atual;
			}
		}
		return maisBarato;
	}

	private static int buscarMaior(Produto[] produtos) {
		int maisCaro = 0;

		for (int atual = 0; atual < produtos.length; atual++) {
			if (produtos[atual].getValor() > produtos[maisCaro].getValor()) {
				maisCaro = atual;
			}
		}
		return maisCaro;
	}

}
