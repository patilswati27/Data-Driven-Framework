package com.bridgelabz.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.bridgelabz.base.TestBase;
import com.bridgelabz.utilities.TestUtil;

/**
 * @author swati
 * purpose:To get data from excel file and process it to open
 * account
 * 
 */
public class openAccount extends TestBase {
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")

	public void openAccount(Hashtable<String, String> data) throws InterruptedException {
		Click("openAccount_Xpath");
		select("customer_CSS", data.get("Customer"));
		select("currency_CSS", data.get("Currency"));
		Click("process_CSS");
		Alert a = wait.until(ExpectedConditions.alertIsPresent());
		a.accept();

	}

}
