package com.pack;

public class TY {

	public static void main(String[] args) {
		int arr[]= {1,2,3,3,4,5,7,13,45,15,17,2,3} ;
		
		for(int i=0;i< arr.length;i++){
			
			boolean strCheck = false;
	           for(int j=i; j< arr.length;j++){
		            if(arr[i]==arr[j]) {
			          strCheck = true;
		            	break;
				}
			}
	           if(!strCheck){
	        	   System.out.println(arr[i]+ " ");
	           }

		}


}
}