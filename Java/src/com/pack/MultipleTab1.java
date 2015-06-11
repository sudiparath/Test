package com.pack;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class MultipleTab1 {
	static WebDriver driver= new FirefoxDriver();

	public static void main(String args[]) throws Exception 
	{
     
	  
		  driver.get("https://oci-mohammaf01.na.ead.netapp.com/uiserver/login.html#");
		 
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		  driver.manage().window().maximize();
		  
		  inputfor1stmachine("input[id=username]","oadmin");
		  inputfor1stmachine("input[id=password]","ugauga");
		  
		 
		   System.out.println("Driver before opening new tab::: " + driver);
		   Thread.sleep(5000);
		  
		  
		  Robot r = new Robot(); 
          r.keyPress(KeyEvent.VK_CONTROL); 
          r.keyPress(KeyEvent.VK_T); 
          r.keyRelease(KeyEvent.VK_CONTROL); 
          r.keyRelease(KeyEvent.VK_T);
          Thread.sleep(5000);

		  driver.get("https://oci-qa07-s12r2.na.ead.netapp.com/uiserver/login.html#");
		  driver.manage().window().maximize();
		  System.out.println("driver after opening new tab::: " + driver);
		    Thread.sleep(5000);
		    testfor2ndmachine("input[id=username]","oadmin");
		    testfor2ndmachine("input[id=password]","ugauga");
		    driver.findElement(By.cssSelector("button[id=login-submit]")).click();
		    
		    
		    System.out.println("before ctrl + t");
		    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
		    Thread.sleep(10 * 1000);
		    System.out.println("after ctrl + t");
		  /*   driver.switchTo().defaultContent();
		     Thread.sleep(2000);
	
	        driver.findElement(By.cssSelector("button[id=login-submit]")).click();//1st link 
	        System.out.println("login successfully");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//a[@href='#admin/troubleshooting']")).click();
		 
		  
		    
		    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
		    System.out.println("navigated to 2nd tab");
		    driver.switchTo().defaultContent();
		    Thread.sleep(2000);
		     driver.findElement(By.cssSelector("//a[@href='#admin/troubleshooting']")).click();*/


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
