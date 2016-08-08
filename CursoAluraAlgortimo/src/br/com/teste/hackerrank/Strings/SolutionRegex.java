package br.com.teste.hackerrank.Strings;

import java.util.Scanner;

public class SolutionRegex {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String IP = in.next();
			System.out.println(IP.matches(new myRegex().pattern));
		}
	}

}

class myRegex {
	String from0To255 = "(25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])";
	public String pattern = String.format("%s.%s.%s.%s", from0To255, from0To255, from0To255, from0To255);
}