package com.test.selenium.ex02_Selenium_Basics;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestSelenium03 {

    @Test
    public void test_Selenium01() {

        // start and stop itself.
        //  If it was a Selenium 3, then we have to do this.

//        System.getProperty("webdriver.gecko.driver","/path/geckdriver");

//        Selenium 4.x downloads webdriver to "C:\Users\Windows\.cache\selenium\geckodriver\win64\"


        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://google.com");
        // You need to setup the Driver(browser)

//        driver.close();

    }
}
