import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class Practise {
	static WebDriver driver=   new FirefoxDriver();
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)   {
				
				 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

				 driver.get("https://oci-aut13-s12.na.ead.netapp.com/");
				 
				 
				 valuesendkeys("//input[@id='username']", "oadmin");                  // $$("input[name='userName']")
				 valuesendkeys("//input[@id='password']", "ugauga");                         //$$("input[name='password']")
				 
				 
				 
				
				 //driver.findElement(By.xpath("//input[@id='username']")).sendKeys("oadmin");          
				 //driver.findElement(By.xpath("//input[@id='password']")).sendKeys("ugauga");               
				                                                                                   
				                                                                           
				 clickByXpath("//button[@type='submit']"); //Clicking submit button                             //$$("button[type='submit']")
				 clickByXpath(".//*[@id='oci-navbar-admin']/a"); // 
				 clickByXpath(".//*[@id='admin-nav-settings']/a");
				  
//				 driver.findElement(By.xpath("//button[@type='submit']")).click();
//				driver.findElement(By.xpath(".//*[@id='oci-navbar-admin']/a")).click();
//				 driver.findElement(By.xpath(".//*[@id='admin-nav-settings']/a")).click();
			
				// driver.findElement(By.xpath("//a[contains(text(),'Notifications')]")).click();
				 driver.findElement(By.linkText("Notifications")).click();
				 driver.navigate().back();
				 //driver.findElement(By.linkText("Troubleshooting ")).click();
				 clickByXpath("//a[contains(text(),'Troubleshooting')]");
//				 driver.findElement(By.xpath("//a[contains(text(),'Troubleshooting')]")).click();
				 
				 
				 driver.findElement(By.id("login-dropdown")).click();
				
//				 driver.findElement(By.xpath("//a[@id='login-control-logout']")).click();
				 clickByXpath("//a[@id='login-control-logout']");
				 
				
				 
				
					 driver.close();
	}
	
	private static void valuesendkeys(String xpathExpression,String valuetobeenter) {
		WebElement ele = driver.findElement(By.xpath(xpathExpression));
		ele.sendKeys(valuetobeenter);
	}
	
	private static void clickByXpath(String xpathExpression){
		driver.findElement(By.xpath(xpathExpression)).click();
	}
	
}
