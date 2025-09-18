package com.test.selenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class CommonToAll {

    public WebDriver driver;

    //  Browser Launchers
    public WebDriver launchChrome() {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        return driver;
    }

    public WebDriver launchFirefox() {
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("signon.rememberSignons", false); // disables password saving prompt

        driver = new FirefoxDriver(options);
        return driver;
    }

    public WebDriver launchEdge() {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        EdgeOptions options = new EdgeOptions();
        options.setExperimentalOption("prefs", prefs);

        driver = new EdgeDriver(options);
        return driver;
    }

    //  Common Actions
    public void openBrowser(WebDriver driver, String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void closeBrowser(WebDriver driver) {
        try {
            Thread.sleep(5000); // optional wait before closing
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    public WebElement findElementByPartialText(WebDriver driver, String text) {
        return driver.findElement(By.partialLinkText(text));
    }
}