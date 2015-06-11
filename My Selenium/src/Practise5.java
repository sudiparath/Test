import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Practise5 {
     static WebDriver driver= new FirefoxDriver();
	public static void main(String[] args) {
		
		  
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 driver.get(" https://oci-aut13-s12.na.ead.netapp.com/dwh");
			 valuetobeenterforlogin("input[id=username]", "oadmin");  //login for username
			 valuetobeenterforlogin("input[id=password]", "ugauga");  //login for password
			 driver.findElement(By.xpath("//button[@type='submit']")).click();
			 
			 driver.manage().window().maximize();
			 driver.findElement(By.cssSelector("a[href='/dwh/faces/usermanager/list.jsp']")).click();
				boolean rowfound=false;
			 driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
			 List<WebElement> RowCollection= driver.findElements(By.xpath("//table[@id='userManagementTable']/tbody/tr"));
			  System.out.println("the row size is::::::: " + RowCollection.size());
			   int index=1;
			    while(index < RowCollection.size()){
			             WebElement tablerow =RowCollection.get(index);
			            List<WebElement> columnname= tablerow.findElements(By.xpath("td"));
			            System.out.println("the columndata size::::: "+ columnname.size());
			            int tablenameindex=0;
			            for(int tablecolumnindex=0; tablecolumnindex<columnname.size(); tablecolumnindex++)
			            {
			            	String tablecolumndata=columnname.get(tablecolumnindex).getText();
			            	if(tablecolumndata.equals("qauser"))
			            	{
			            		rowfound=true;
			            		for(;tablenameindex >columnname.size()-1;tablenameindex++)
			            		{
			            			if(columnname.get(tablenameindex).getText().equals("edit"))
			            			{
			            				break;
			            			}
			            		}
			            	}
			            }
			            
			          if(rowfound) 
			          {
			        	  System.out.println("the tablenameindex is:::" + tablenameindex);
			        	WebElement editelement=  columnname.get(tablenameindex).findElement(By.cssSelector("a"));
			        	editelement.click();
			        	break;
			          }
			          index++;
			            
			            
			            
			            
			            
			            
			    }
			  
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
	

	}
	private static void valuetobeenterforlogin(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

}
