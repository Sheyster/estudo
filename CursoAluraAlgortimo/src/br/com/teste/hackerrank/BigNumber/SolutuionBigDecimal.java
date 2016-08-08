package br.com.teste.hackerrank.BigNumber;

import java.math.BigDecimal;
import java.util.Scanner;

public class SolutuionBigDecimal {

	public static void main(String[] args) {
		// Input
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BigDecimal t1, b1, b2, a1, a2;
		String b;
		String[] s = new String[n + 2];
		for (int i = 0; i < n; i++) {
			s[i] = sc.next();
		}
		sc.close();
		// Write your code here
		for (int i = 0; i < n - 1; i++) {
			b1 = new BigDecimal(s[i + 1]);
			b2 = new BigDecimal(s[i]);
			if (b1.compareTo(b2) == 1) {
				b = s[i + 1];
				s[i + 1] = s[i];
				s[i] = b;
				for (int j = i; j >= 1; j = j - 1) {
					a1 = new BigDecimal(s[j]);
					a2 = new BigDecimal(s[j - 1]);

					if (a1.compareTo(a2) == 1) {
						b = s[j];
						s[j] = s[j - 1];
						s[j - 1] = b;
					}
				}
			}
		}
		// Output
		for (int i = 0; i < n; i++) {
			System.out.println(s[i]);
		}
	}

}
