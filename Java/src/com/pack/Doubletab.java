package com.pack;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Doubletab {
	static WebDriver driver= new FirefoxDriver();
	public static void main(String args[]) throws Exception 
	{
     
	  
		  driver.get("https://oci-mohammaf01.na.ead.netapp.com/uiserver/login.html#");
		 
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		  driver.manage().window().maximize();
		  
		  inputfor1stmachine("input[id=username]","oadmin");
		  inputfor1stmachine("input[id=password]","ugauga");
		  
		 
		   
		   Thread.sleep(5000);
		  
		   String windowHandle = driver.getWindowHandle();
	        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"n");
	        
	        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	        System.out.println(tabs.size());
	        String childWindow = tabs.get(1);
	        driver.switchTo().window(childWindow); 


		    driver.get("https://oci-qa07-s12r2.na.ead.netapp.com/uiserver/login.html#");
		    driver.manage().window().maximize();
		    Thread.sleep(5000);
		    testfor2ndmachine("input[id=username]","oadmin");
		    testfor2ndmachine("input[id=password]","ugauga");
		    driver.findElement(By.cssSelector("button[id=login-submit]")).click();
		    
		    driver.switchTo().window(windowHandle);
	        driver.findElement(By.cssSelector("button[id=login-submit]")).click();//1st link 
	        System.out.println("login successfully");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//a[@href='#admin/troubleshooting']")).click();
	        System.out.println("clicked troble");

		    Thread.sleep(5000);
		   driver.switchTo().window(childWindow); 
		   System.out.println("went to child window");
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//a[@href='#admin/troubleshooting']")).click();

            driver.close();
}

	private static void testfor2ndmachine(String cssname,String texttobeenter) {
	   WebElement ele2= driver.findElement(By.cssSelector(cssname));
	   ele2.sendKeys(texttobeenter);
	}

	private static void inputfor1stmachine(String cssname,String valuetobenter) {
	 WebElement ele= driver.findElement(By.cssSelector(cssname));
	 ele.sendKeys(valuetobenter);
		
	}
}