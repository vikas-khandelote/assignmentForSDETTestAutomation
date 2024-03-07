package com.cowStudios.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cowStudios.qa.base.TestBase;



public class TableHTMLTagPage extends TestBase{
	
	
	 
	// PageFactory or Object Repository 
	
	@FindBy(xpath="//summary[text()=\"Table Data\"]")
	WebElement datatablebtn;
	
	@FindBy(xpath="//p//textarea[@id='jsondata']")
	WebElement inputTextbox;
	
	@FindBy(xpath="//button[@id=\"refreshtable\"]")
	WebElement refreshtablebtn;
	
	
	// constructor or Initilazition of page objects
	
		public TableHTMLTagPage()
		{
			// this.wait = new WebDriverWait(driver, 10);
			PageFactory.initElements(driver, this);
			
		}
		
	 // Action performe on loginpage
		
		public String verifyTableHTMLTagPageTitle()
		{
			return driver.getTitle();
		}	
		
		
		
		
		public void clickOnDataTabelBtn(String data) throws InterruptedException {
			// TODO Auto-generated method stub
			
			datatablebtn.click();
			Thread.sleep(3000);
			inputTextbox.clear();
			Thread.sleep(3000);
			inputTextbox.sendKeys(data);
			refreshtablebtn.click();
			
		}
		
		
		
		public String getDataFromTable() {
	        // Logic to retrieve data from the UI table
			
	        return "Actual data from UI table"; // Replace this with the actual data retrieval logic
	    }
	    
		
	/*	
		public void clickOnDataTabelBtn(String data) {
			datatablebtn.click();
			inputTextbox.clear();
			inputTextbox.sendKeys(data);
//				inputTextbox.sendKeys("[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, {\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, {\"name\":\r\n"
//			+ "\"Sara\", \"age\" : 42, \"gender\": \"female\"}, {\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, {\"name\":\r\n"
//		+ "\"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]");  

		} */

		


	
	
	
	
	
	
	
/*	
	 public String getTableData() {
	        StringBuilder tableData = new StringBuilder();

	        // Locate the table element
	        WebElement table = driver.findElement(By.id("table_id"));
	        

	        // Find all rows in the table
	        java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));

	        // Loop through each row
	        for (WebElement row : rows) {
	            // Find all columns (cells) in the row
	            java.util.List<WebElement> cells = row.findElements(By.tagName("td"));

	            // Loop through each cell and append its text to the tableData StringBuilder
	            for (WebElement cell : cells) {
	                tableData.append(cell.getText()).append("\t"); // Assuming tab separation, adjust as needed
	            }

	            // Add a new line after each row
	            tableData.append("\n");
	        }

	        return tableData.toString();
	    }
*/
}	
