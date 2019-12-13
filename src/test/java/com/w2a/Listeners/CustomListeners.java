package com.w2a.Listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Test;
import com.w2a.utilities.TestUtil;


public class CustomListeners extends com.w2a.base.TestBase implements ITestListener {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		System.setProperty("org.uncommons.reportng.escape-output","false");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//extent report generation
		test.log(LogStatus.FAIL,arg0.getName().toUpperCase()+"fail");
		test.log(LogStatus.FAIL,test.addScreenCapture(TestUtil.screenshotName));
		
		//reportng report
		Reporter.log("Click to see Screenshot");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+" height=200 width=200></img></a>");
		rep.endTest(test);
	    rep.flush();
		
	}

	public void onTestSkipped(ITestResult arg0) {
		test.log(LogStatus.SKIP,arg0.getName().toUpperCase());

		rep.endTest(test);
		rep.flush();
		
	}

	public void onTestStart(ITestResult arg0) {
		test = rep.startTest(arg0.getName().toUpperCase());
		if(!TestUtil.isTestRunnable(arg0.getName(),excel)) {
		  throw new SkipException("Skiping the test "+arg0.getName().toUpperCase() );
		}
		
	}

	public void onTestSuccess(ITestResult arg0) {
		test.log(LogStatus.PASS,arg0.getName().toUpperCase()+"PASS");
	    rep.endTest(test);
	    rep.flush();
		
	}

}
