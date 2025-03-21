package com.urbanladder.stepdefinitions;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.urbanladder.utils.Base;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks {
    static WebDriver driver;
    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    static Base base = new Base(); 

    @BeforeAll()
    public static void beforeAll() {
        try {
            sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            // Initialize browser only once
        
            driver = Base.driver;
            base.getBrowser();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterAll()
    public static void afterAll() {
        extent.flush();
    }

    @Before()
    public void before() {
        test = extent.createTest("Test Scenario");
    }

    @After()
    public void after() {
//        if (driver != null) {
//            driver.quit();
//            driver = null; 
//        }
    }
}
