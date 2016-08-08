package br.com.teste.hackerrank.introdution;

import java.util.Locale;
import java.util.Scanner;

public class SolutionStdinandStdoutII {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in).useLocale(Locale.US);

		int i = scan.nextInt();
		double d = scan.nextDouble();
		// precisa desta parte para poder pegar o valor no proximo nextLine
		scan.nextLine();
		String s = scan.nextLine();

		// Write your code here.
		System.out.println("String: " + s);
		System.out.println("Double: " + d);
		System.out.println("Int: " + i);
	}

}
