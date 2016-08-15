package br.com.teste.hackerrank.cit;

public class SolutionII {

	public static void main(String[] args) {
		int vectores[] = { 1, 2, 3, 4, 5 };

		int retorn[] = ordernar(vectores);

		for (int i = 0; i < retorn.length; i++) {
			System.out.println(retorn[i]);
		}
	}

	private static int[] ordernar(int[] input) {
		int aux = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				if (input[i] <= input[j]) {
					aux = input[i];
					input[i] = input[j];
					input[j] = aux;
				}
			}
		}

		int merg[] = new int[input.length];

		int max = input.length;
		int aux2 = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = max; j > i;) {
				if (j == i) {
					break;
				}
				if (i < input.length) {
					merg[aux2] = input[i];
				}
				aux2 = aux2 + 1;
				if (aux2 < input.length) {
					merg[aux2] = input[j - 1];
					max--;
					aux2++;
				}
				break;
			}
		}

		return merg;

	}
}
