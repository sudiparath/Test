package com.pack;

public class NewProject2 {

	public static void main(String[] args) {
		active();
		//NewProject2.pyramid6(6);
	}
	
	public static void active(){
		int c, k;
		System.out.println("enter  number of rows\n");
		for (c = 1; c <= 5; c++) {
			for (k = 5; k > c; k--) 
				System.out.print(" ");
			{
			for (int j = 1; j <= c; j++)
				System.out.print("* ");
		
		}
		System.out.println("\n ");
	}
		/*
		int c, k;
		System.out.println("enter  number of rows\n");
		for (c = 4; c >0 ; c--) {
			for (k = 4-c; k > 0; k--) 
				System.out.print(" ");
			{
			for (int j =2*c-1; j > 0; j--)
				System.out.print("* ");
		
		}
		System.out.println("\n ");
	}
		*/
		
		/*private static void pyramid6(int length){
			  System.out.println("\n\n=== Program 6 ===\n");
			  for(int i = 0; i < length; i++) {
			   for(int j = 0 ; j < i; j++) {
			    System.out.print(" ");
			   }
			   for(int k = 0; k < (length - i); k++){
			    System.out.print(" *");
			   }
			   System.out.println();
			  }*/
			 }
	}


