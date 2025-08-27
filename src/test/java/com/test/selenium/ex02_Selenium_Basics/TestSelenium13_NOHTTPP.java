package com.test.selenium.ex02_Selenium_Basics;

import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium13_NOHTTPP {
    public static void main(String[] args) {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("bing.com"); // HTTPS is important.
//        driver.get("https://bing.com"); // HTTPS is important.
        driver.quit();
    }
}
