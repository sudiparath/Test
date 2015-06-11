package com.pack;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrokenLinks {

	public static void main(String[] args) {
		WebDriver driver= new FirefoxDriver();
		driver.get("https://www.google.co.in/?gfe_rd=cr&ei=_1lcVZL5JuzI8Ae43oG4DA");
	     List<WebElement> ele=driver.findElements(By.tagName("a"));
	     System.out.println("size:::" + ele.size());
	     boolean isvalid=false;
	     for(int i=0;i < ele.size();i++){
	    	 System.out.println(ele.get(i).getAttribute("href"));
	   isvalid	= getResonsecode(ele.get(i).getAttribute("href"));
	    if(isvalid){
	    	System.out.println("valid links"+ ele.get(i).getAttribute("href"));
	    }else{
	    	System.out.println("invalid links" + ele.get(i).getAttribute("href"));
	    }
	     }
	     }
	     
	 private static boolean getResonsecode(String urlString) {
		boolean isValid= false;
		
		try{
			URL url= new URL(urlString);
			HttpURLConnection  h= (HttpURLConnection) url.openConnection();
			h.setRequestMethod("GET");
			h.connect();
			System.out.println(h.getResponseCode());
			if(h.getResponseCode() >= 404){
				isValid=true;
			}
		  }catch(Exception e){
				
			}
			return isValid;
			
			
				
		}
}
