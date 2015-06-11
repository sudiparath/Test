package com.pack;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TripleTab {
     static WebDriver driver =new FirefoxDriver();
     
     private static final String  USNAMEXPATH="input[id=username]" ;
     private static final String  pswdnameXpath="input[id=password]";
     private static final String  clickxpath="button[id=login-submit]";
     private static final String  usvalue="oadmin";
     private static final String pswdvalue="ugauga";
     private static final String troubleshoot="//a[@href='#admin/troubleshooting']";
     
	public static void main(String[] args) throws Throwable {
		
		  driver.get("https://oci-mohammaf01.na.ead.netapp.com/uiserver/login.html#");
		 
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		  driver.manage().window().maximize();
		  
		  
		
		  
		  inputforallthemachine(USNAMEXPATH,usvalue);
		  inputforallthemachine(pswdnameXpath,pswdvalue);
		  buttontobeclick(clickxpath);
		  
		  
		    String multiplewindowhandle=driver.getWindowHandle();
		    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "n");
		    ArrayList<String> multipletab= new ArrayList<String>(driver.getWindowHandles());
		   
		    
		    
		    String childwindow=multipletab.get(1);
		    WebDriver childDriver = driver.switchTo().window(childwindow);
		    childDriver.get("https://oci-qa07-s12r2.na.ead.netapp.com/uiserver/login.html#");
		    childDriver.manage().window().maximize();
		    Thread.sleep(2000);
		    
		          inputforallthemachine(USNAMEXPATH,usvalue);
				  inputforallthemachine(pswdnameXpath,pswdvalue);
				  buttontobeclick(clickxpath);
		    
		    String childDriverHandler = childDriver.getWindowHandle();
		    childDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "n");
		    ArrayList<String> multipletab2= new ArrayList<String>(childDriver.getWindowHandles());
		   
		    
		    
		    String subchildwindow= multipletab2.get(1);
		    WebDriver subchildDriver=driver.switchTo().window(subchildwindow);
		    subchildDriver.get("https://oci-qa05-s12r2.nane.netapp.com/uiserver/login.html#");
		    subchildDriver.manage().window().maximize();
		    Thread.sleep(5000);
		    
		    
		      inputforallthemachine(USNAMEXPATH,usvalue);
			  inputforallthemachine(pswdnameXpath,pswdvalue);
			  buttontobeclick(clickxpath);
           
		    
		    String subchildDriverHandler=subchildDriver.getWindowHandle();
		    subchildDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "n");
		    ArrayList<String> multipletab3= new ArrayList<String> (subchildDriver.getWindowHandles());
		  
		                         
		              
		    driver.switchTo().window(multiplewindowhandle);
		    Thread.sleep(2000);
		    troubleshooter(troubleshoot);
		  
	       
	        
	        driver.switchTo().window(childDriverHandler);
	        Thread.sleep(2000);
	        troubleshooter(troubleshoot);
          
            
            
           driver.switchTo().window(subchildDriverHandler);
           Thread.sleep(2000);
           troubleshooter(troubleshoot);
     
       
		    
		  
	
	}
	private static void troubleshooter(String troubleLink) {
		WebElement troublelink=driver.findElement(By.xpath(troubleLink));
		troublelink.click();
		
	}
	private static void buttontobeclick(String cssselectoralllinks) {
		WebElement eleall=driver.findElement(By.cssSelector(cssselectoralllinks));
		eleall.click();
		
	}
	
	private static void inputforallthemachine(String cssselectorpath,String inputtobeenter) {
	WebElement webele= driver.findElement(By.cssSelector(cssselectorpath));
	webele.sendKeys(inputtobeenter);
		
	}

}
