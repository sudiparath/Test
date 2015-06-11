package com.pack;



import java.awt.Frame;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Selenium1 {
	  static WebDriver driver=   new FirefoxDriver();
	//static  WebDriver driver=new ChromeDriver();
	  
	  public static void main(String[] args) {
	
		  try{
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		/* System.setProperty("webdriver.chrome.driver", 
		            "C://Program Files (x86)//Google//Chrome//Application//chrome.exe");
		 */
		 driver.get("https://oci-aut13-s12.na.ead.netapp.com/reporting");
		 clickbysendkeys("//input[@id='CAMUsername']","oadmin");
		 clickbysendkeys("//input[@id='CAMPassword']","ugauga");
         driver.findElement(By.xpath("//input[@id='cmdOK']")).click();
         
      /*  clicktonexttab("Public Folders");
        try {
			Thread.sleep(1000 * 5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
       clicktonexttab("My Folders");*/
        //clicktonexttab("//a[@href='/reporting/servlet/Gateway?b_action=xts.run&m=portal/cc.xts&m_tab=i97FE6234617A45098D7066B471A05C18&m_folder=i97FE6234617A45098D7066B471A05C18&m_folder2=p-iFA3CB182D0024D3EA2FE8260AE8CFAB0']");
	   // clicktonexttab("//div[@id='selectedTab']");
	    
	  
		
//	       List<WebElement>  allcolumns=driver.findElements(By.tagName("td")) ;  
//	       for (WebElement cells : allcolumns) {
//	    	   System.out.println(cells);
//			
//		}
         //selectTab("Public Folders");
         //selectTab("My Folders");
//         driver.findElement(By.cssSelector("table[role='presentation']")).click();
         try {
 			Thread.sleep(1000 * 10);
 		} catch (InterruptedException e) {
 			e.printStackTrace();
 		}
         
                 
	             driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id^='CVIFrameparent']")));
	             
	             /*List<WebElement> allrows = driver.findElements(By.cssSelector("table tr:nth-child(2) table td:nth-child(2) table:nth-child(2) tr td:nth-child(2)"));
	             for(WebElement row : allrows){
	            	 System.out.println("row element:: " + row);
	            	 String linkText = row.findElement(By.cssSelector("div span a")).getText();
//	            	 String usedText = row.findElement(By.cssSelector("td:nth-child(4)")).getText();
	            	 
	            	 System.out.println("Link Text:: " + linkText + " <=>" + usedText);
	            	 
	             }*/
	          /*   
	            List<WebElement> alrows=driver.findElements(By.cssSelector("table tr:nth-child(2) table td:nth-child(2) table:nth-child(2) tr td:nth-child(2) a"));
	            List<WebElement> allcols =driver.findElements(By.cssSelector("table tr:nth-child(2) table td:nth-child(2) table:nth-child(2) tr td:nth-child(4)"));
	            System.out.println("row size:::" + alrows.size() + " col size:: " + allcols.size());
	                           
	          
	            
	            
	            for (int index = 0 ; index < alrows.size(); index++) {
	            	WebElement row = alrows.get(index);
	            	System.out.println(index + " ::: " + row.getText());
//	            	for(int col = 4; col < allcols.size(); ){
	            		System.out.println(allcols.get(4).getText());
//	            		col = col+4;
//	            	}
	            	
	            	if(row.getText().equals("")){
	            			row.click();
	            	}
				}*/
	            
	           /* 
	             List<WebElement> alrows=driver.findElements(By.cssSelector("table tr:nth-child(2) td:nth-child(2) table"));
	             System.out.println("roe size:::" + alrows.size());
	             for(int row = 0; row < alrows.size(); row++) {
//	            	 System.out.println(row + " <> " +alrows.get(row).getText());
	            	 if(alrows.get(row).getText().contains("Data Centers Time to Full")) {
	            		 
	            		 List<WebElement> firstRow = alrows.get(row).findElements(By.cssSelector("tr:nth-child(2) img"));
	            		 System.out.println("==>> "+ firstRow.size());
	            		 
	            		 	for(WebElement firstRowChild : firstRow){
	            		 		System.out.println(row + " <<>> '" + firstRowChild.getAttribute("src")+ "'");
	            		 		firstRowChild.click();
	            		 	}
	            	 }
	             }     
		  */ 
	             driver.findElements(By.cssSelector("table tr:nth-child(2) td:nth-child(2) table"));
	             /*
	             findElement(By.cssSelector("tr:nth-child(2) img")  [data center time to pull]
	            		 findElement(By.cssSelector("tr:nth-child(2) td:nth-child(3) span img")  [top 10 application]
	            		 findElements(By.cssSelector("table tr:nth-child(1) td:nth-child(2) img")   [orphaned capacity]*/
	             
	             
	             List<WebElement> righttable=driver.findElements(By.cssSelector("table tr:nth-child(2) td:nth-child(2) table"));
	            		 for(int i=0;i<righttable.size();i++){
	            	 List<WebElement> allimages = righttable.get(i).findElements(By.cssSelector("tr:nth-child(2) img"));
	            		System.out.println("::::" + allimages.size());
	            		
	            		for (WebElement alltableimg : allimages) {
							System.out.println( ":::" + alltableimg.getAttribute("src") + "'");
						}
	            		
	            		 }
	            		
		  }
	            		 
	            		 
	          /*  		 
	             System.out.println("row size::::" + halftablerow.size() );
	             for(int row = 0; row < halftablerow.size(); row++) {
          
	           if(halftablerow.get(row).getText().contains("Data Centers Time to Full")) {
	            		 
	             for(int i = 0;i < halftablerow.size(); i++) {
	             System.out.println(i + ":::::::" + halftablerow.get(i).getText());
	           
	             WebElement firsttableimage=  halftablerow.findElement(By.cssSelector("tr:nth-child(2) img"));
	             System.out.println("==>" + firsttableimage.size());
	             for(WebElement  firsttable : firsttableimage){
	            	 System.out.println(i + ":::" + firsttable.getAttribute("src"));
	            	 firsttable.click();
	             }
	             
	             else{
	            	 
	             }
	             
	             if(halftablerow.get(row).getText().contains("Top 10 Applications")) {
	            	  List<WebElement> secondtableimag = halftablerow.get(i).findElement(By.cssSelector("tr:nth-child(2) td:nth-child(3) img"));
	 	             System.out.println("==>" + secondtableimag.size());
	 	             
	             
	            	 for(WebElement  secondttable : secondtableimag){
		            	 System.out.println(i + ":::" + secondttable.getAttribute("src"));
		            	 secondttable.click();
		             }
	             }
	             
	           
	             if(halftablerow.get(row).getText().contains("Orphaned CapacitY")) {
	  	          
	            	 List<WebElement> thirdtableimage= halftablerow.get(i).findElements(By.cssSelector("table tr:nth-child(1) td:nth-child(2) img"));		 
	             
	            	 System.out.println("==>" + thirdtableimage.size());
	            
	            	 
		             
		             for(WebElement  thirdttable : thirdtableimage){
		            	 System.out.println(i + ":::" + thirdttable.getAttribute("src"));
		            	 thirdttable.click();
		            
		               
		             }
		            
		             
		             
		            	 
		             }
	          */
	             
	             
	           
	             
	            
//	    WebElement img= driver.findElement(By.cssSelector("table tr:nth-child(2) td:nth-child(2) table tr:nth-child(2)  td:nth-last-of-type(2)"));
	    /*WebElement img= driver.findElement(By.cssSelector("table tr:nth-child(2) td:nth-child(2) table tr:nth-child(2) "));
	                System.out.println("image exits:::" + img.getAttribute("src"));
	                */
	               //String expectedvalue="oci-aut13-s12.na.ead.netapp.com/reporting/servlet/Gateway/repository/sid/cm/oid/i8AB62A68259B4B0681BEF692E024B173/images/img22";
	               
	            
//		  }
		  
		 
		/* 
		 List<WebElement> anchorelement= driver.findElements(By.xpath("//a[@class='tabAnchor']"));
		for (WebElement newelement : anchorelement)
		{
			System.out.println("the value is::"+ newelement.getText() );
			if(newelement.getText().equals("Public Folders")){
				System.out.println("in if:: " );
				newelement.click();
			} else if(newelement.getText().equals("My Folders")){
				newelement.click();
			}
			try {
				Thread.sleep(1000 * 5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/
		
	                                 
		  
		catch(NoSuchElementException nse)
		{
			System.out.println(nse.getMessage());
		}finally
		{
			if(driver!=null){
				driver.close();
		}
			
		}
	}
	
	
	private static void selectTab(String tabName) {
//		 WebElement divTag= driver.findElement(By.id("tabWindow"));
		    
//		   WebElement table = divTag.findElement(By.id("tabs"));
//		 WebElement table = driver.findElement(By.cssSelector("tabWindow tabs"));
		   
		    List<WebElement>  allrows= driver.findElements(By.cssSelector("tabWindow tabs tr"));
		    System.out.println("Row size:: "+ allrows.size());
		              for (WebElement row : allrows) {
		            	  System.out.println(row);
		            	  
		            	  System.out.println("row childs:: " + (row.findElements(By.tagName("td"))).size());
						for (WebElement tableData : row.findElements(By.tagName("td"))) {
							WebElement cell = tableData.findElement(By.tagName("div"));
							String cellData = cell.getText();
							if (cellData != null && !cellData.isEmpty()) {
								System.out.println("CellData:: " + cellData);
								if (cellData.equals(tabName)) {
									if (!cell.getCssValue("id").equals("selectedTab")) {
										WebElement anchorTag = cell.findElement(By.tagName("a"));
										anchorTag.click();
										 try {
												Thread.sleep(1000 * 10);
											} catch (InterruptedException e) {
												e.printStackTrace();
											}
										  break;
									}
								}
							}

						}
		            	  }
						
					}
			
		
		
		
	


	private static void clicktonexttab(String tabName) {
		WebElement ele= driver.findElement(By.xpath("//a[contains(text(), '" + tabName +"')]"));
		ele.click();
	
	
	
		
	}

    private static void clickbysendkeys(String xpathvalue,String texttobeenter) {
		WebElement ele = driver.findElement(By.xpath(xpathvalue));
		ele.sendKeys(texttobeenter);
		
	}

}
