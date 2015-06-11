package com.pack;

import java.util.HashMap;
import java.util.Map.Entry;

public class Qu {

	public static void main(String[] args) {
	
		int arr[]= {1,2,3,3,4,5,7,13,45,15,17,2,3} ;
		Qu q = new Qu();
		q.displayRepeatedNumber(arr);
	}
	
	
	public void displayRepeatedNumber(int[] arr){
		boolean isCounted = false;
		int[] occurredElement = new int[arr.length];
		for(int i=0;i< arr.length;i++){
			int count=0;
			for(int j=i; j< arr.length;j++){
			
				if(arr[i]==arr[j]) {
					count++;
					isCounted = true;
					break;
				}
			}
			
			if(!isCounted){
	        	   System.out.println(arr[i]+ " ");
	           }

			/*if(!repeatedCount.containsKey(arr[i]))
				repeatedCount.put(arr[i], 1);
			else
				repeatedCount.put(arr[i], repeatedCount.get(arr[i]) + 1);*/
			if(count > 1 && isCounted) {
				
				System.out.println(arr[i] + "\toccours\t" + count + "times");
			}
			
			/*for (int index = 0; index < repeatedCount.size(); index++) {
				if (repeatedCount != null) {
					int key = repeatedCount.get(index);
					if (key > 1)
						System.out.println(repeatedCount.get(index));
					// }
				}
			}*/
			
			isCounted = false;
		}
	}

}