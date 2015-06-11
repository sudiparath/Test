package com.pack;
public class Question3 {

		  public static void main (String[] args) { 

		     int[] testarray = {1,2,3,3,2,2,4,4,5,4};
		     int count = 0;
		     int bigCount = 10;

		      for (int i=0; i < testarray.length; i++) {
		        for (int j=0; j < testarray.length; j++) {
		          if(testarray[j] == testarray[i]) {
		             count++;
		        }
		    }
		        if(count > bigCount) {
		          bigCount = count;
		       
				testarray[i] = bigCount;
		      }
		    }
		 System.out.println("num of elements and occurences: " + bigCount);
		  }
		}


	