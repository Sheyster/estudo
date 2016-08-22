package br.com.teste.hackerrank.DataStructures;

import java.util.Scanner;

public class SolutionArraysDS {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		int i;
		for (int arr_i = 0; arr_i < n; arr_i++) {
			arr[arr_i] = in.nextInt();
		}

		for (i = n - 1; i >= 0; i--) {
			System.out.printf("%d ", arr[i]);
		}

		// int ret[] = new int[arr.length];
		// int i = 0;
		// for (int j = arr.length; j > 0; j--) {
		// ret[i] = arr[j - 1];
		// i++;
		// }
		// i = 0;
		// for (int j = 0; j < ret.length; j++) {
		// arr[i] = ret[j];
		// i++;
		// }
		//
		// for (int j = 0; j < arr.length; j++) {
		// System.out.print(arr[j]);
		// }
	}

}
