package br.com.teste.hackerrank.DataStructures;

import java.util.Scanner;

public class Solution1DArrayPart2 {

	static boolean didWinGame(String[] gameArray, int jumpLength, int currentPos, int lastJumpPos) {

		boolean didWin = false;

		int range = currentPos;

		while (range < gameArray.length - 1 && gameArray[range + 1].equals("0")) {
			range++;
		}
		if (range == gameArray.length - 1)
			return true;

		int lowRange = range;
		while (lowRange > lastJumpPos && gameArray[lowRange - 1].equals("0") && (lowRange + jumpLength) > range + 1) {
			lowRange--;
		}
		currentPos = lowRange;
		for (int i = currentPos; i <= range; i++) {
			if ((i + jumpLength) < gameArray.length && gameArray[i + jumpLength].equals("0") && jumpLength != 0) {
				didWin = didWinGame(gameArray, jumpLength, i + jumpLength, i);
			}

			if (didWin || (i + jumpLength) >= gameArray.length || (i + 1) >= gameArray.length) {
				didWin = true;
				break;
			}
		}

		return didWin;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numCases = sc.nextInt();
		for (int i = 0; i < numCases; i++) {
			int arraySize = sc.nextInt();
			int jumpLength = sc.nextInt();
			sc.nextLine();
			String[] gameArray = sc.nextLine().split(" ");
			if (didWinGame(gameArray, jumpLength, 0, 0)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	// public static void main(String[] args) {
	// Scanner subs = new Scanner(System.in);
	// int t = Integer.parseInt(subs.nextLine());
	// for (int i = 0; i < t; i++) {
	// int n = subs.nextInt();
	// int m = subs.nextInt();
	// subs.nextLine();
	// String[] items = subs.nextLine().split(" ");
	// int[] arr = new int[n];
	// for (int j = 0; j < n; j++)
	// arr[j] = Integer.parseInt(items[j]);
	// int cur_pos = 0;
	// boolean flag = true;
	//
	// while (flag) {
	//
	// if (cur_pos < 0 || arr[cur_pos] == 1) {
	// System.out.println("NO");
	// flag = false;
	// break;
	// }
	//
	// if (cur_pos + m > n - 1 || cur_pos == n - 1) {
	// System.out.println("YES");
	// flag = false;
	// break;
	// }
	//
	// arr[cur_pos] = 1;
	//
	//
	// if ((m > 0) && (arr[cur_pos + m] == 0))
	// cur_pos += m;
	// else if (arr[cur_pos + 1] == 0)
	// cur_pos++;
	// else if ((cur_pos > 0) && (arr[cur_pos - 1] == 0))
	// cur_pos--;
	//
	// }
	//
	// }
	// }
	//
	// public static boolean sol(int m,int[] a,int i) {
	// if(i<0||a[i]==1)
	// return false;
	// if(i==a.length-1)
	// return true;;
	// if(i+m>a.length-1)
	// return true;
	// a[i]=1;
	// return sol(m,a,i+1) || sol(m,a,i+m) || sol(m,a,i-1);
	// }
}
