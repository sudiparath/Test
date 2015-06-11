package com.pack;


public class Pallindrome {

	public static void main(String[] args) {
		Pallindrome proc = new Pallindrome();
		proc.display(121);
	}

	public void display(int n) {
		/*
		 * Scanner scn = new Scanner(System.in);
		 * System.out.println("enter a number :: " ); int n=scn.nextInt();
		 */

		int revnum = reverse(n);

		if (revnum == n) {
			System.out.println("its a pallindrome :: ");
		} else {
			System.out.println("its not a pallindrome ::");
		}
	}

	private int reverse(int n) {
		int revnum = 0;
		while (n > 0) {
			int m = n % 10;
			revnum = (revnum * 10 + m);
			n = n / 10;
		}

		return revnum;
	}

}
