package com.pack;


import java.awt.Robot;
import java.util.concurrent.TimeUnit;
import java.awt.event.KeyEvent; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Tab2 {

public static void main(String args[]) throws Exception{



WebDriver wd = new FirefoxDriver();
wd.get("http://www.gmail.com");

wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
wd.manage().window().maximize();

WebElement we=wd.findElement(By.id("Email"));
we.sendKeys("email id");
/*
we=wd.findElement(By.id("Passwd"));
we.sendKeys("password");

we= wd.findElement(By.name("PersistentCookie"));	// It will remove tick in stay signed in check box.

if(we.isSelected())
we.click();

we.submit();*/
Thread.sleep(5000);

Robot r = new Robot(); 
r.keyPress(KeyEvent.VK_CONTROL); 
r.keyPress(KeyEvent.VK_T); 
r.keyRelease(KeyEvent.VK_CONTROL); 
r.keyRelease(KeyEvent.VK_T);

Thread.sleep(5000);
wd.get("http://facebook.com");

Thread.sleep(5000);

we=wd.findElement(By.id("email"));	
we.sendKeys("emailid/phone");

we=wd.findElement(By.name("pass"));
we.sendKeys("password");
we.submit();	

}



}