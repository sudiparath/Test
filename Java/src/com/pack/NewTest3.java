package com.pack;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewTest3  {
	
	private static final String MOHAMMAF_URL="http://oci-mohammaf01.na.ead.netapp.com";
	private static final String QA07_URL="http://oci-qa07-s12r2.na.ead.netapp.com";
	private static final String QA05_URL="http://oci-qa05-s12r2.nane.netapp.com";
     
	
//	private static final String MOHAMMAF_URL="https://www.google.co.in/?gfe_rd=cr&ei=hMdiVanLGerI8AefsIGwBQ";
//	private static final String QA07_URL="https://www.facebook.com/";
	
	 
	//private static final int MYTHREAD = 30;
	
	public static void main(String[] args){

		String[] hostList= {MOHAMMAF_URL,QA07_URL,QA05_URL};

		for (int i = 0; i < hostList.length; i++) {
 
			String url = hostList[i];
			MyRunnable thread = new MyRunnable(url);
			thread.start();
			
			

		}
		
		
	}
 
	public static class MyRunnable extends Thread {
		private final String url;
 
		MyRunnable(String url) {
			this.url = url;
		}
		
		
 
		@Override
		public void run() {
			WebDriver driver = new FirefoxDriver();
         System.out.println("in run method");
			String result = "";
			int code = 200;
			try {
				URL siteURL = new URL(url);
				System.out.println("Site url " + siteURL.getPath());
				HttpURLConnection connection = (HttpURLConnection) siteURL
						.openConnection();
				System.out.println("Setting request");
				connection.setRequestMethod("GET");
				System.out.println("openieng connection::" );
				System.out.println("Connected and getting content");
				System.out.println(connection.getURL());
				int responseCode = connection.getResponseCode();
				System.out.println("responseCode:: " + responseCode);
				String headerLocation = connection.getHeaderField("Location");
				System.out.println("status code:: " + code + " <<>> " + headerLocation);
				if (responseCode != 200) {
					String content = connection.getContentType();
					System.out.println("Content:: " + content);
					String headerLocation1 = connection
							.getHeaderField("Location");
					System.out.println("Header Location:: " + headerLocation1);
					driver.get(headerLocation1);
				} else if (driver != null) {
					driver.get(url);
				}
			
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
				System.out.println("finally block:::");
				
			}
			System.out.println(url + "\t\tStatus:" + result);
		}
	}
}