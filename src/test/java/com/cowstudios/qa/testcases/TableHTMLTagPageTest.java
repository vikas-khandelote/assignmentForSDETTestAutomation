package com.cowstudios.qa.testcases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cowStudios.qa.base.TestBase;
import com.cowStudios.qa.pages.TableHTMLTagPage;
import com.cowStudios.qa.util.TestUtil;

public class TableHTMLTagPageTest extends TestBase{
	
	// create object of TableHTMLTagPage to asses the methods
	TableHTMLTagPage tableHTMLTagPage;
//	TestUtil testUtil;
//	String expectedTableData ;
//	TestBase testBase;

	// constructor : by using super keyword we asses the super/parent class constructor
	public TableHTMLTagPageTest() 
	{
		super();
	}
	

	@BeforeMethod
	public void setUp() 
	{
		initialization();
		tableHTMLTagPage = new TableHTMLTagPage(); // tableHTMLTagPage object to accses all methods fo this class
	//	testBase =new TestBase();
	}
	
	
	
	@Test(priority=1)
	public void tableHTMLTagPageTitle()
	{
	  String title = tableHTMLTagPage.verifyTableHTMLTagPageTitle();
	  Assert.assertEquals(title, "Table HTML Tag - JavaScript Created");
	}
	
	// this test call hard coded value 
/*	@Test(priority=2, dataProvider="testData")
	public void verifyText()
	{
		tableHTMLTagPage.clickOnDataTabelBtn();
		
	}*/
	

	

	@DataProvider(name = "testData")
	public Object[][] testData() {
	    try {
	        JSONParser parser = new JSONParser();
	        // Load JSON data from file
	        Object obj = parser.parse(new FileReader("F:\\Eclipse1\\workspace\\AssignmentForSDETTestAutomation"
	                + "\\src\\test\\resources\\testdata.json"));
	        
	        JSONObject jsonObject = (JSONObject) obj;
	        JSONArray tableDataArray = (JSONArray) jsonObject.get("form info");
	        
	        Object[][] testDataArray = new Object[tableDataArray.size()][3];
	        
	        for (int i = 0; i < tableDataArray.size(); i++) {
	            JSONObject dataObject = (JSONObject) tableDataArray.get(i);
	            testDataArray[i][0] = dataObject.get("name");
	            testDataArray[i][1] = dataObject.get("age");
	            testDataArray[i][2] = dataObject.get("gender");
	        }
	  //      return testDataArray; // by using this we can pass json test data in one by one. 
	        
	 //       When retrieving the age from the test data array, you need to cast it to Long instead of long since 
	 //       it's stored as an Object. Then, you can extract the primitive long value from the Long object.
	        return new Object[][] { { testDataArray } };
	        
	    } catch (FileNotFoundException e) {
	        // Handle file not found exception
	        e.printStackTrace();
	    } catch (IOException e) {
	        // Handle IO exception
	        e.printStackTrace();
	    } catch (ParseException e) {
	        // Handle parsing exception
	        e.printStackTrace();
	    }
	    // Return null if there's an error
	    return null;
	}
	
	
	@Test(priority=1, dataProvider = "testData")
	public void testDataComparisonWithJSON(Object[][] testDataArray) {
	    try {
	        for (Object[] testData : testDataArray) {
	            String name = (String) testData[0];
	            Long ageObject = (Long) testData[1];
	            long age = ageObject.longValue(); // Extract the long value from the Long object
	            String gender = (String) testData[2];

	            // Perform actions using test data
	            
	      //      WebElement inputTextbox = waitForElementToBeClickable(By.xpath("//textarea[@id='jsondata']"));
	         //   testBase.waitForElementToBeClickable(inputTextbox);
	      //      inputTextbox.click();
	           Thread.sleep(3000);
	            tableHTMLTagPage.clickOnDataTabelBtn(name + " " + age + " " + gender);

	        
	            // Capture actual data from the application or system
	            
	         //   String actualData = ((TableHTMLTagPage) tableHTMLTagPage).getDataFromTable(); 
	            // String actualData = tableHTMLTagPage.getDataFromTable();

	         //    Expected data from the file
	       //      String expectedData = name + " " + age + " " + gender;
	             
	       //      String actualData1 = tableHTMLTagPage.getDataFromTable();

	            // Add assertions to compare data in UI table with test data
	            // For example:
	      //       Assert.assertEquals(actualData1, expectedData);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


	
	
	
/*
	        
	@Test(dataProvider = "testData")
	public void testDataComparisonWithJSON(String name, long age, String gender) {
	    try {
	        // Perform actions using test data
	        tableHTMLTagPage.clickOnDataTabelBtn(name + " " + age + " " + gender);
	        
	     // Capture actual data from the application or system
   //         String actualData = ((Object) tableHTMLTagPage).getDataFromTable(); // Assuming this method retrieves data from the UI table
            
            // Expected data from the file
  //          String expectedData = name + " " + age + " " + gender;

	        // Add assertions to compare data in UI table with test data
	        // For example:
	        // String actualData = loginPage.getDataFromTable();
	  //      Assert.assertEquals(actualData, name + " " + age + " " + gender);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	    
	
*/
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	


}
