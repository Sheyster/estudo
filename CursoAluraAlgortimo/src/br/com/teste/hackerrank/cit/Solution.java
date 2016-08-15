package br.com.teste.hackerrank.cit;
public class Solution {

	public static void main(String[] args) {
		String a = "Vem pra";
		String b = "CI&T";

		// int tamanhoA = a.length();
		// int tamanhoB = b.length();
		String retorno = mergeStrings(a, b);

		System.out.println(retorno);
	}

	private static String mergeStrings(String a, String b) {
		StringBuilder r = new StringBuilder();
		int i;
		for (i = 0; i < a.length(); i++) {
			if (a.length() > i) {
				r.append(a.charAt(i));
			}
			if (b.length() > i) {
				r.append(b.charAt(i));
			}
		}

		if (b.length() > i) {
			for (int j = i; j < b.length(); j++) {
				r.append(b.charAt(j));
			}
		}
		if (a.length() > i) {
			for (int j = i; j < a.length(); j++) {
				r.append(a.charAt(j));
			}
		}

		return r.toString();
	}

}
