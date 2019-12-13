package com.w2a.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

	
	public class openAccount extends TestBase {
		@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
		
		 public void openAccount(Hashtable<String,String> data) throws InterruptedException{
		 Click("openAccount_Xpath");
		 select("customer_CSS",data.get("Customer"));
		 select("currency_CSS",data.get("Currency"));
		 Click("process_CSS");
		 Alert a=wait.until(ExpectedConditions.alertIsPresent());
		 a.accept();
	
		 
		}
		
	}
	

