package br.com.teste.hackerrank.introdution;

import java.util.Scanner;

public class SolutionIIILoopsI {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		for (int i = 1; i <= 10; i++) {
			System.out.println(N + " x " + i + " = " + (N * i));
		}

		// Close scanner
		in.close();
	}

}
