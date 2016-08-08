package br.com.teste.hackerrank.DataStructures;

import java.util.Scanner;

public class SolutionIIStackLIFO {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String input = sc.next();
			// Complete the code
			while (input.length() != (input = input.replaceAll("\\(\\)|\\[\\]|\\{\\}", "")).length())
				;
			System.out.println(input.isEmpty());
		}
	}

}
