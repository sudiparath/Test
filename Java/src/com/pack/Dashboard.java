package com.pack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Dashboard {

	public static void main(String[] args) {
		
		
		WebDriver driver= new FirefoxDriver();
		driver.get("https://oci-aut15-s12.nane.netapp.com/uiserver/login.html#dashboard/1");
		
		driver.findElement(By.id("//input[@id='username']")).sendKeys("oadmin");
		driver.findElement(By.id("//input[@id='password']")).sendKeys("ugauga");
		
		driver.findElement(By.id("//button[@id='login-submit']")).click();
		
		//driver.findElement(By.cssSelector("div a:nth-child(2) span"));
		
	List<WebElement> ele=driver.findElements(By.id("//div[@id='navbar']"));
		for(int i=0;i<ele.size();i++){
			System.out.println(i +" ::: " + ele.get(i).getText());
			
			if(ele.get(i).getText().contains("NetApp_Corp_IT_New")){
				
				
			WebElement ele2=driver.findElement(By.cssSelector("div a:nth-child(2) span"));
			
			
			}
			
			
			
		}
		

	}

}
