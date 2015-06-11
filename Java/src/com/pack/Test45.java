package com.pack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test45 {

	public static void main(String[] args) throws IOException {
		
   File  f2= new File("C:\\Users\\Sudipa\\Desktop\\RunCommands.txt");
   
   FileReader  fr1=null;
          try {
			fr1=new FileReader(f2);
			int ch;
			while((ch=fr1.read())!=-1){
				System.out.print((char)ch);
			
			}
			
		} catch (Exception e) {
		
		System.out.println(e);
		}
          finally{
        	  try{
        		  fr1.close();
        	  }catch(Exception e){
        		  
        	  }
          }
         /* FileWriter out = new FileWriter(f2);
          BufferedWriter writer = new BufferedWriter(out);

          String data = "Backup_NetApp_Corp_IT_New_V6-2-0_B629.gz";

          writer.write(data);
          */
	}
	//String newdb="C:\\Users\\Sudipa\\Desktop\\RunCommands.txt";
	//String finaldb= f2.replace("Backup_NetApp_Corp_IT_New_V6-2-0_B629.gz", "autopolicy_iscsi_V5_1_1_B248.gz");

}
