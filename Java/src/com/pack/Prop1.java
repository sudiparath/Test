package com.pack;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;


public class Prop1 {

	public static void main(String[] args) {
		
		Properties prop= new Properties();
		OutputStream output= null;
		try{
		//output= new FileOutputStream("RunCommands.properties");
		prop.load(new FileInputStream("C:\\Users\\Sudipa\\Desktop\\RunCommands.properties"));
	String servername=	prop.getProperty("servername");
	String level= prop.getProperty("level");
		String os=prop.getProperty("os");
		String mode=prop.getProperty("mode");
		String dbname=prop.getProperty("dbname");
	
		
		System.out.println("the servername is" + servername );
		System.out.println("the level is " + level);
		System.out.println("the os is "+ os);
		System.out.println("the mode is "+ mode);
		System.out.println("the dbname is" + dbname);
		
		prop.setProperty("dbname","bshdfyggdf" );
		    String s3=prop.getProperty("dbname");
		    System.out.println(s3);
		   
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	

}