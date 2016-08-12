package br.com.teste.hackerrank.Advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SolutionIIIJavaLambdaExpressions {

	public static void main(String[] args) throws IOException {
		MyMath ob = new MyMath();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		PerformOperation op;
		boolean ret = false;
		String ans = null;
		while (T-- > 0) {
			String s = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(s);
			int ch = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (ch == 1) {
				op = ob.is_odd();
				ret = ob.checker(op, num);
				ans = (ret) ? "ODD" : "EVEN";
			} else if (ch == 2) {
				op = ob.is_prime();
				ret = ob.checker(op, num);
				ans = (ret) ? "PRIME" : "COMPOSITE";
			} else if (ch == 3) {
				op = ob.is_palindrome();
				ret = ob.checker(op, num);
				ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

			}
			System.out.println(ans);
		}
	}
}

interface PerformOperation {
	boolean check(int a);
}

class MyMath {
	public static boolean checker(PerformOperation p, int num) {
		return p.check(num);
	}

	public PerformOperation is_odd() {
		return a -> a % 2 == 1 ? true : false;
	}

	public PerformOperation is_prime() {
		return a -> {
			for (int i = 2; i < a / 2; i++) {
				if (a % i == 0) {
					return false;
				}
			}
			return true;
		};
	}

	public PerformOperation is_palindrome() {
		return a -> {
			String str = Integer.toString(a);
			int n = str.length();
			for (int i = 0; i < n / 2; i++) {
				if (str.charAt(i) != str.charAt(n - i - 1)) {
					return false;
				}
			}
			return true;
		};
	}
}