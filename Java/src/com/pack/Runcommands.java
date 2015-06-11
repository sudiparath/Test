package com.pack;

import java.io.File;

public class Runcommands {

	 
		String servername;
		int level;
		String mode;
		String os;
		String DBNAME;
		 
	 public Runcommands(String servername,int level,String mode,String os,String DBNAME){
		 
		 this.servername=servername;
		 this.level=level;
		 this.mode=mode;
		 this.os=os;
		 this.DBNAME=DBNAME;
			
		}
	 void display(){
		 System.out.println("the server name is :::: " + servername );
		 System.out.println("the level is ::: " + level);
		 System.out.println("the mode is ::: "+mode );
		 System.out.println("the os is ::::"+ os);
		 System.out.println("the dbname is ::: "+ DBNAME);
	 }
	 public static void main(String[] args){
		Runcommands  rc1= new Runcommands("oci-automation.com", 1, "CAC", "NonWindows", "autopolicy_iscsi_V5_1_1_B248.gz");
		
		File runCommandsFile = new File("C:\\Users\\Sudipa\\Desktop\\RunCommands.txt");
		
		
	 }
	 
	 
	 
	}


