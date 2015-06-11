import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Practise3 {
       static WebDriver driver= new FirefoxDriver();
	public static void main(String[] args) throws InterruptedException {

		try{
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get(" https://oci-aut13-s12.na.ead.netapp.com/dwh");
		 valuetobeenterforlogin("input[id=username]", "oadmin");  //login for username
		 valuetobeenterforlogin("input[id=password]", "ugauga");  //login for password
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 
		 driver.manage().window().maximize();
		 
		//navigate to usermanagement
		 driver.findElement(By.cssSelector("a[href='/dwh/faces/usermanager/list.jsp']")).click();
		
		 driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		  //navigate to Add new user
		/* driver.findElement(By.xpath("//*[contains(text(),'Add New User')]")).click();
		
		 //Filling the following fields with data
		 datatobefilled("//input[@name='userName']","QAUser");
		 datatobefilled("//input[@name='email']", "netappuser@gmail.com");
		 datatobefilled("//input[@name='password']", "Netapp123");
		 datatobefilled("//input[@name='confirmPassword']", "Netapp123");
		 datatobefilled("//input[@value='guest']", "Guest");
		 datatobefilled("//input[@value='rebusinessconsumer']", "Business Consumer");
	
		 driver.findElement(By.xpath("//input[@value='Add']")).click();//clicking on add button
		
		// driver.findElement(By.cssSelector("a[href='/dwh/faces/usermanager/list.jsp']")).click(); 
		 
	// WebElement eleTable= driver.findElement(By.xpath("//table[@id='userManagementTable']"));
    // System.out.println("the table element is ::::" + eleTable);
*/	
	  //tablerowdeleteoption();
	  editElement();
	  
	  
	  
	  
	  
	  
	  
	  
	  
	 
	   } catch(NoSuchElementException nsee){
				System.out.println(nsee.getMessage());
			}finally{
				Thread.sleep(5000);
				if(driver != null) {
					driver.close();
					driver.quit();
				}
			}
  }

      
	
	
	private static void editElement() {
		 List<WebElement> RowCollection =driver.findElements(By.xpath("//table[@id='userManagementTable']/tbody/tr"));
		   System.out.println("Numer of rows in this table: "+ RowCollection.size());
		   
		   int index = 1;
		   
		   boolean rowFound = false;
		   
		   while(index < RowCollection.size()) {
			   
			   WebElement tableRow = RowCollection.get(index);
			   
				 List<WebElement> tableColumnData = tableRow.findElements(By.xpath("td"));
				 
				 System.out.println("TableColumnData size: " + tableColumnData.size());
				 
				 int tablenameIndex = 1;
				 for(int tableCellIndex = 0 ; tableCellIndex < tableColumnData.size() ; tableCellIndex++) {
						 String tableCellData = tableColumnData.get(tableCellIndex).getText();
						 if(tableCellData.equals("QAUser"))
						 {
							 rowFound = true;
							 for(; tablenameIndex < tableColumnData.size() - 1; tablenameIndex++){
								if(tableColumnData.get(tablenameIndex).getText().equals("Edit")){
									break;
								}
							 }
							 
						 }
				 }
				 
				 
				 if(rowFound) {
					 System.out.println("tablenameIndex: " + tablenameIndex);
					 WebElement editElement = tableColumnData.get(tablenameIndex).findElement(By.cssSelector("a"));
					 editElement.click();
					 
					 driver.findElement(By.xpath("//input[@value='user']")).click();
					 driver.findElement(By.xpath("//input[@type='submit']")).click();
					
					 break;
				 }
				 index++;
		   }	 
	}
	
	 List<WebElement> RowCollection =driver.findElements(By.xpath("//table[@id='userManagementTable']/tbody/tr"));
	  // System.out.println("Numer of rows in this table: "+ RowCollection.size());
	   
	   
		int rowIndex=0;
		
		boolean qaUserRowFound = false ;
		{
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
	   
	
	 
				
		  
	   
	
	
	
	
	
	



/*
	private static void tablerowdeleteoption() {
		// TODO Auto-generated method stub
		  List<WebElement> RowCollection =driver.findElements(By.xpath("//table[@id='userManagementTable']/tbody/tr"));
		   System.out.println("Numer of rows in this table: "+ RowCollection.size());
		   
		   int index = 1;
		   
		   boolean rowFound = false;
		   
		   while(index < RowCollection.size()) {
			   
			   WebElement tableRow = RowCollection.get(index);
			   
				 List<WebElement> tableColumnData = tableRow.findElements(By.xpath("td"));
				 
				 System.out.println("TableColumnData size: " + tableColumnData.size());
				 
				 int tableDeleteIndex = 1;
				 for(int tableCellIndex = 0 ; tableCellIndex < tableColumnData.size() ; tableCellIndex++) {
						 String tableCellData = tableColumnData.get(tableCellIndex).getText();
						 if(tableCellData.equals("QAUser"))
						 {
							 rowFound = true;
							 for(; tableDeleteIndex < tableColumnData.size() - 1; tableDeleteIndex++){
								if(tableColumnData.get(tableDeleteIndex).getText().equals("Delete")){
									break;
								}
							 }
						 }
				 }
				 
				 if(rowFound) {
					 System.out.println("TableDeleteIndex: " + tableDeleteIndex);
					 WebElement deleteElement = tableColumnData.get(tableDeleteIndex).findElement(By.cssSelector("a#del10"));
					 deleteElement.click();

					 Alert alert = driver.switchTo().alert();
					 alert.accept();
					 
					 break;
				 }
				 
				index++;
		   }
	}

*/

















	private static void  datatobefilled(String xpathexpression,String texttobeenter) {
		 WebElement ele=driver.findElement(By.xpath(xpathexpression));
		  ele.sendKeys(texttobeenter);
		 
		
		  
	}
	
	
	
	
	private static void valuetobeenterforlogin(String selectorexpression,String sendkeysoperation) {
	WebElement element=	driver.findElement(By.cssSelector(selectorexpression));
	       element.sendKeys(sendkeysoperation);
		
		
	}

}
