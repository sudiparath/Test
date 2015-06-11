package com.pack;

public class NewProject {

	public static void main(String[] args) {
	
		NewProject np= new NewProject();
		np.dispaly();
		
}
	
	public void dispaly(){
		int c ,k;
		System.out.println("enter  number of rows\n");
		/*for(c=1;c<=4;c++){
			for(k=1;k<=c;k++)
				System.out.print("* ");
			System.out.println("\n");
		}*/
		
		/*for(int i=4;i>0;i--){
			for(int j=1;j<=i;j++){
				System.out.print("* ");
			}
				System.out.println("\n");
			}*/
		
		int totalWidth = 8;
		for (int row = 1; row <= totalWidth; row++) {
		    for (int col = 1; col <= totalWidth; col++) {
		      if (col <= totalWidth - row) {
		        System.out.print(" ");
		      }else {
		        System.out.print("*");
		      }
		    }
		    System.out.println();
		  }
		
		  
		
		
		
		
		}
	
	}


