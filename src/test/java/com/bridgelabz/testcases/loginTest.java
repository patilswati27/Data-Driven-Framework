package com.bridgelabz.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bridgelabz.base.TestBase;

/**
 * @author swati 
 * Purpose: To get user credentials from excel file and login to the
 *         application
 */
public class loginTest extends TestBase {
	@Test
	public void loginTest() throws InterruptedException, IOException {
		FileInputStream fi = new FileInputStream(
				System.getProperty("user.dir") + "//src/test//resources//properties//properties//OR.properties");
		OR.load(fi);
		driver.findElement(By.xpath(OR.getProperty("bmlBtn_CSS"))).click();
		WebElement we = driver.findElement(By.xpath(OR.getProperty("addCustBtn_Xpath")));
		Assert.assertTrue(we.isDisplayed(), "Login not successful");// for validation to check whether element is
																	// present or not
		Thread.sleep(2000);
		log.debug("login successfully executed ");

	}

}
