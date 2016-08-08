package br.com.teste.hackerrank.introdution;

import java.util.Scanner;

public class SolutionVIEndOfFile {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i = 0;
		while (scan.hasNext()) {
			i++;
			System.out.println(i + " " + scan.nextLine());
		}
	}

}
