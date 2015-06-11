import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Practise4 {
	  static WebDriver driver= new FirefoxDriver();

	public static void main(String[] args) {
		
		
		  
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 driver.get(" https://oci-aut13-s12.na.ead.netapp.com/dwh");
			 valuetobeenterforlogin("input[id=username]", "oadmin");  //login for username
			 valuetobeenterforlogin("input[id=password]", "ugauga");  //login for password
			 driver.findElement(By.xpath("//button[@type='submit']")).click();
			 
			 driver.manage().window().maximize();
			 driver.findElement(By.cssSelector("a[href='/dwh/faces/usermanager/list.jsp']")).click();
				
			 driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
			  List<WebElement> RowCollection =driver.findElements(By.xpath("//table[@id='userManagementTable']/tbody/tr"));
			   System.out.println("Numer of rows in this table: "+ RowCollection.size());
			   
			   
			
			   
	
			   		int rowIndex=0;
			   		
			   		boolean qaUserRowFound = false;
				   for(; rowIndex < RowCollection.size();rowIndex++)
				   {
					   List<WebElement> columnCollection = RowCollection.get(rowIndex).findElements(By.xpath("td"));
					   
					   for(int qaUserRowIndex = 0; qaUserRowIndex < columnCollection.size(); qaUserRowIndex++) {
						   String cellText = columnCollection.get(qaUserRowIndex).getText();
						   if(cellText.equals("QAUser")){
							   qaUserRowFound= true;
							   break;
						   }
					   }
					   if(qaUserRowFound) {
						   break;
					   }
				   }
				   
				   
				    System.out.println("qaUserRowIndex:: " + rowIndex);
				    
				    int guestCellIndex = 0;
				    boolean guestCellFound = false;
				    for(int colindex=0; colindex < RowCollection.size();colindex++)
					   {
						   System.out.println("@ RowIndex: " + colindex);
						   List<WebElement> ROWWCollection = RowCollection.get(colindex).findElements(By.xpath("td"));
						   System.out.println("ROWWCollection: " + ROWWCollection.size());
						   for(int guestRowIndex = 0 ;guestRowIndex < ROWWCollection.size(); guestRowIndex++) {
							   
							   String cellText = ROWWCollection.get(guestRowIndex).getText();
							   System.out.println(guestRowIndex + " cellText:: " + cellText);
							   if(cellText.equals("Guest")){
								   guestCellIndex = guestRowIndex;
								   guestCellFound= true;
								   break;
							   }
							   
						   }
						   if(guestCellFound){
								break;
							}
					   }
				    
				if(guestCellFound){
					guestCellIndex++;
				}
				
				int userCellIndex = 0;
				if(guestCellFound){
					userCellIndex = guestCellIndex+2;
				}
				int adminCellIndex = 0;
				if(guestCellFound){
					adminCellIndex = guestCellIndex+3;
				}
				   
				WebElement guestTableCell = RowCollection.get(rowIndex).findElements(By.xpath("td")).get(guestCellIndex);
				System.out.println("guestTableCell: "+ guestTableCell.getText());
				if(guestTableCell.getText().equals("X")){
					//test pass
				}
				
				WebElement userTableCell = RowCollection.get(rowIndex).findElements(By.xpath("td")).get(userCellIndex);
				System.out.println("userTableCell: " + userTableCell.getText());
				if(userTableCell.getText().equals("X")){
					//test pass
				}
				
				
				WebElement adminTableCell = RowCollection.get(rowIndex).findElements(By.xpath("td")).get(adminCellIndex);
				System.out.println("AdminTableCell: '" + adminTableCell.getText() + " '");
				 
				
				List<WebElement> qaUserTableCellDatas = RowCollection.get(rowIndex).findElements(By.xpath("td"));
				   
				   
				for(int tableData = 0; tableData < qaUserTableCellDatas.size(); tableData++){
					if(qaUserTableCellDatas.get(tableData).getText().equals("X")) {
						System.out.println("Table Cell Data: " + qaUserTableCellDatas.get(tableData).getText());
					}
				}
					   
					
					 
								
						  }
					   
				   
				   
				

	

	



	

	private static void valuetobeenterforlogin(String selectorexpression,String sendkeysoperation) {
	WebElement element=	driver.findElement(By.cssSelector(selectorexpression));
	       element.sendKeys(sendkeysoperation);
		
		
	}

	
}
