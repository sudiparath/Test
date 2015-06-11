

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class Practise2 {
	static WebDriver driver=   new FirefoxDriver();

	public static void main(String[] args) {

		
	
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 try{
		 driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		// driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("a");
		 //driver.findElement(By.xpath("//input[@name='password']")).sendKeys("a");
		 
		 
		 
	     driver.findElement(By.name("login")).click();
	     
	     clcikbysendkeys("//input[@name='userName']", "a");    // $$("input[name='userName']")
	     clcikbysendkeys("//input[@name='password']", "a");    //$$("input[name='password']")
		 
	    // driver.findElement(By.xpath("//input[@value='oneway']")).click();
	     
	     clickbyxpath("//input[@value='oneway']");             //$$("input[value='oneway']")
	     clickbyxpath("//input[@name='findFlights']");
	     
	     clickbyxpath("//select[@name='airline']");             //$$("select[name='airline']")
	     
//	     WebElement airLineWebElement = driver.findElement(By.xpath("//select[@name='airline']"));
		 Select oSelection1 = new Select(clcikbysendkeys("//select[@name='airline']"));
		 
		 oSelection1.selectByVisibleText("Blue Skies Airlines");
		// driver.findElement(By.xpath("//input[@name='findFlights']")).click();
		 
		 /**
		  * Table logic
		  */
		 //get the table element
         
		      readandverifyflighttable();
		 
		  clickbyxpath("//a[contains(text(),'SIGN-OFF')]");     //$$("a[href*='signoff']")   //$$("a[href='mercurysignoff.php']") //both will work.
		 clickbyxpath("//a[contains(text(),'Home')]");

        // driver.findElement(By.xpath("//a[contains(text(),'SIGN-OFF')]")).click();
	      //driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
	      
	      
		 } catch(NoSuchElementException nsee){
			 if(driver != null) {
				 driver.close();
			 }
		 } finally {
			 if(driver != null) {
				 driver.close();
			 }
		 }
		 
	}
	
	private static void clcikbysendkeys(String xpathvalue,String texttobeenter) {
		WebElement ele = driver.findElement(By.xpath(xpathvalue));
		ele.sendKeys(texttobeenter);
	}
	
	private static WebElement clcikbysendkeys(String xpathvalue) {
		return driver.findElement(By.xpath(xpathvalue));
	}

	
	
	private static void clickbyxpath(String xpathexpression) {
		 WebElement element = driver.findElement(By.xpath(xpathexpression));
		 element.click();
	}
	
	
	
	
	 private static void readandverifyflighttable()
	 {
		 List<WebElement> tableRowElements = driver.findElements(By.cssSelector("form table:first-of-type tr"));
		 HashMap<String, String> tableSelectedData = new HashMap<String, String>();
		 int index = 4;
		 String key ="";
		 String value = "";
		 while(index < tableRowElements.size()) {
			 WebElement tableRow = tableRowElements.get(index);
			 
			 List<WebElement> tableFlightData = tableRow.findElements(By.cssSelector("td"));
			 for(int tableCellIndex = 0 ; tableCellIndex < tableFlightData.size() - 2; tableCellIndex++) {
				 
				 if(tableCellIndex == 0){
					 List<WebElement> tableRadioData = tableRow.findElements(By.cssSelector("td input"));
					 	value = tableRadioData.get(tableCellIndex).getAttribute("value");
				 } else {
					 key = tableFlightData.get(tableCellIndex).getText();
				 }
			 }
			 	tableSelectedData.put(key, value);
			 index = index + 2;
		 }
		 
		 for(Map.Entry<String, String> entry : tableSelectedData.entrySet()) {
			 String actualKey = entry.getKey();
			 if(actualKey.equals("Blue Skies Airlines 361")) {
				String attributeValue =  driver.findElement(By.cssSelector("input[value='" + entry.getValue() + "']")).getAttribute("checked");
				System.out.println("AttributeValue: " + attributeValue) ;
			 }
		 }
	 }

    
}


	  

	


