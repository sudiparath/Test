package com.pack;

import java.util.ArrayList;

public class Emptyyy {

	public static void main(String args[]) {

		ArrayList<Integer> returnedDivisiors = divisors(186);
		for (int i = 0; i < returnedDivisiors.size(); i++) {
			System.out.println(returnedDivisiors.get(i));
		}
	}

	public static ArrayList<Integer> divisors(int s) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 1; i <= s / 2; i++) {
			if (s % i == 0) {
				arr.add(i);
				// System.out.println(i + ",");
			}
		}
		
		return arr;
	}

}
