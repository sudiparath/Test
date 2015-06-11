package com.com.pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class NewTest {
 static WebDriver driver =new FirefoxDriver();
     
     private static final String  USNAMEXPATH="input[id=username]" ;
     private static final String  pswdnameXpath="input[id=password]";
     private static final String  clickxpath="button[id=login-submit]";
     private static final String  usvalue="oadmin";
     private static final String pswdvalue="ugauga";
    // private static final String troubleshoot="//a[@href='#admin/troubleshooting']";
     
  @Test
   public void ExecutionSessionOne() {
	  WebDriver driver= new FirefoxDriver();
	  driver.get("https://oci-mohammaf01.na.ead.netapp.com/uiserver/login.html#");
	  inputforallthemachine(USNAMEXPATH,usvalue);
	  inputforallthemachine(pswdnameXpath,pswdvalue);
	  buttontobeclick(clickxpath);
	  
	  }
  
  @Test
   public void ExecutionSessionTwo(){
	  WebDriver driver= new FirefoxDriver();
	  driver.get("https://oci-qa07-s12r2.na.ead.netapp.com/uiserver/login.html#");
	  inputforallthemachine(USNAMEXPATH,usvalue);
	  inputforallthemachine(pswdnameXpath,pswdvalue);
	  buttontobeclick(clickxpath);
	    
  }
  
  @Test
  
    public void ExecutionSessionThree(){
	  WebDriver driver= new FirefoxDriver();
	  driver.get("https://oci-qa05-s12r2.nane.netapp.com/uiserver/login.html#");
	  inputforallthemachine(USNAMEXPATH,usvalue);
	  inputforallthemachine(pswdnameXpath,pswdvalue);
	  buttontobeclick(clickxpath);
	      
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
