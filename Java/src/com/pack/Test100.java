package com.pack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Test100 {

	private static final String new_db = "dbname=autopolicy_iscsi_V5_1_1_B248.gz";

	public static void main(String[] args) throws IOException {

		FileReader fr2 = new FileReader(
				"C:\\Users\\Sudipa\\Desktop\\RunCommands.txt");
		BufferedReader br = new BufferedReader(fr2);
		
		String s1;
		ArrayList<String> arr = new ArrayList<String>();
		while ((s1 = br.readLine()) != null) {
			arr.add(s1);
		}
		for (int i = 0; i < arr.size(); i++) {
			String value = arr.get(i);
		
			if (value.contains("dbname")) {
				System.out.println(value);
				arr.remove(i);
			}
		}
		arr.add(new_db);

		for (int i = 0; i < arr.size(); i++) {
			System.out.println(i + ":::" + arr.get(i));
		}
		// System.out.print("Total number of lines"+count);

		fr2.close();
	}
}
