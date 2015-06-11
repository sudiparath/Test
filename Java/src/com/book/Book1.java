package com.book;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Book1 {
	
	public static void main(String[] args) {
		
		WebDriver driver =new FirefoxDriver();

		WebElement gmailLink= driver.findElement(By.linkText("GMAIL"));
		
		assertEquals("https://www.google.co.in/",gmailLink.getAttribute("href"));
	}

	private static void assertEquals(String string, String attribute) {
		// TODO Auto-generated method stub
		
	}

}
