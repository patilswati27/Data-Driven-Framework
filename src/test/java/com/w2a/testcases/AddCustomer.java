package com.w2a.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class AddCustomer extends TestBase {
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
    public void AddCustomer(Hashtable<String,String> data) throws InterruptedException{
			if(!data.get("runmode").equals("y")){
			//if(!TestUtil.isTestRunnable("AddCustomer", excel))
		throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		
		Click("addCustBtn_Xpath");
		Type("firstname_Css",data.get("firstname"));
		Type("lastname_Css",data.get("lastname"));
 		Type("postcode_Css",data.get("postcode"));
		Click("addbtn_Xpath");
		Thread.sleep(2000);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertTrue(alert.getText().contains(data.get("alerttext")));
		alert.accept();
		
	/*public  void AddCustomerTest(String firstName,String lastName,String postCode,String alerttext) throws InterruptedException {
		//
		log.info("Add test");
		driver.findElement(By.cssSelector(OR.getProperty("addCustBtn_CSS"))).click();
		driver.findElement(By.cssSelector(OR.getProperty("firstname_Css"))).sendKeys(firstName);
		driver.findElement(By.cssSelector(OR.getProperty("lastname_Css"))).sendKeys(lastName);
		driver.findElement(By.cssSelector(OR.getProperty("postcode_Css"))).sendKeys(postCode);
		driver.findElement(By.cssSelector(OR.getProperty("addbtn_CSS"))).click();
		Alert a=wait.until(ExpectedConditions.alertIsPresent());//to handle alert pop up
		Assert.assertTrue(a.getText().contains("alerttext"));
		Thread.sleep(3000);
		a.accept();
		Thread.sleep(3000);*/
		
	}
		
}

