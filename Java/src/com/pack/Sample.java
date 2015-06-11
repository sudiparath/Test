package com.pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sample {

	 public static void main(String[] args) 
	 {
	  
	   
	    WebDriver driver=new FirefoxDriver();
	    driver.get("http://viewer:m1ntm0j1t0@vmw2.qa.sharedemos.com/");
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    System.out.println("START");
	    int count =driver.findElements(By.xpath("//div[@class='row sortable']/div")).size();
	    System.out.println(count);
	    for(int i=1;i<=count;i++)
	    {
	    System.out.println("enter"); 
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//div[@class='row sortable']/div[i]//div[@class='title']")).click();
	    System.out.println("stop");
	    driver.navigate().back();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    }
	 }
}