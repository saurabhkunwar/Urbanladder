package com.urbanladder.utils;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Base {
    public static WebDriver driver = null;

    public static void getBrowser() {
        if (driver != null) {
            return; // Prevent re-initialization
        }

        Properties prop = PropertyReader.readProperty();
        if (prop == null) {
            throw new RuntimeException("ERROR: Failed to load properties file. Exiting test.");
        }

        String browser = prop.getProperty("Browser");
        String url = prop.getProperty("URL");

        if (browser == null || url == null) {
            throw new RuntimeException("ERROR: Missing Browser or URL in config.properties.");
        }

        System.out.println("Launching browser: " + browser);
        System.out.println("Navigating to URL: " + url);
 
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("ERROR: Unknown browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.get(url);
    }
}
