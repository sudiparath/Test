package com.pack;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Practise1 {
     
	static String[] appurls= {"https://www.google.co.in/?gfe_rd=cr&ei=n1hkVYbyH6vv8wej7oCIBg" ,"https://mail.google.com/" ,"https://www.facebook.com/"};
	public static void main(String[] args) {
		for(String url:appurls){
			System.out.println("url ::::" + url);
			Worker worker= new Worker(url);
			worker.start();
			
		}
 }
	public static  class Worker extends Thread{
		String url;
		public Worker(String url){
			this.url=url;
			}
		
		@Override
		public void run(){
			WebDriver driver= new FirefoxDriver();
			System.out.println("driver opened");
			 try {
				 System.out.println("within try");
				URL u= new URL(this.url);
				HttpURLConnection httpconnection= (HttpURLConnection)u.openConnection();
				System.out.println("sendding get request");
				httpconnection.setRequestMethod("GET");
				System.out.println("Connecting");
				httpconnection.connect();
				System.out.println("connected and getting content");
				System.out.println(httpconnection.getURL());
				int responsecode=httpconnection.getResponseCode();
				System.out.println("responsecode" + responsecode);
				if(responsecode!=200){
				String content=	httpconnection.getContentType();
				System.out.println("content:::" + content);
				String headerlocation= httpconnection.getHeaderField("Location");
				System.out.println("headerlocation" + headerlocation);
				driver.get(headerlocation);
				}else if(driver!=null){
					driver.get(url);
				}
				
				
				
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			 finally {
					if(driver != null){
						driver.close();
						driver.quit();
					}
			
			
		}
		
		
		
		
		
		
		
	}
	}
}
