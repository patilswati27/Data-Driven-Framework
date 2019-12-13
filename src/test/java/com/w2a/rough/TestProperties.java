package com.w2a.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 Properties config = new Properties();
		 FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src/test//resources//properties//properties//config.properties");
		 config.load(fis);
		 
		 Properties OR = new Properties();
		 FileInputStream fi=new FileInputStream(System.getProperty("user.dir")+"//src/test//resources//properties//properties//OR.properties");
	     OR.load(fi);
	     
	     System.out.println(config.getProperty("browser"));
	   //driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		 System.out.println(OR.getProperty("bmlBtn_CSS"));
	}

}
