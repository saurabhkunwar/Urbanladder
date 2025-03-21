package com.urbanladder.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;


public class Reports {
	
	public static void generateReport(WebDriver driver, ExtentTest test, Status status,String stepMessage){
		if (status.equals(Status.PASS)) {
			test.log(status, stepMessage);
		}else if (status.equals(Status.FAIL)) {
			String screenShotName = captureScreenshot(driver, stepMessage);
			test.log(status, stepMessage, MediaEntityBuilder.createScreenCaptureFromPath(screenShotName).build());
		}
		
		 
	}

	public static String captureScreenshot(WebDriver driver, String errorMessage) {
	    String userDir = System.getProperty("user.dir");
	    String sanitizedErrorMessage = errorMessage.replaceAll("[^a-zA-Z0-9.-]", "_"); // Remove invalid chars
	    Date date = new Date();
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	    String dateTime = df.format(date);
	    String fileName = userDir + File.separator + "screenshots" + File.separator + sanitizedErrorMessage + "_" + dateTime + ".png";

	    
	    File screenshotDir = new File(userDir + File.separator + "screenshots");
	    if (!screenshotDir.exists()) {
	        screenshotDir.mkdirs();
	    }

	    TakesScreenshot scrShot = (TakesScreenshot) driver;
	    File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
	    File destFile = new File(fileName);

	    try {
	        FileUtils.copyFile(srcFile, destFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return fileName;
	}

	

}
