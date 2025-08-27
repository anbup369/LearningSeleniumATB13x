package com.test.selenium.ex02_Selenium_Basics;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium14_Close_VS_quit {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
//        driver.switchTo().newWindow(WindowType.TAB);//WindowType requires selenium 4.x(not available in selenium 3.x)?
        // Open a new tab using JavaScript
        wait_secs(2000);
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.bing.com','_blank');");//Available in selenium 3.x , works with selenium 4.x as well
//        driver.get("https://bing.com");

        // Now switch to the new tab   //Not needed for selenium 4.x since we can use switchTo()
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }


        // Write the code
        // Wait
        wait_secs(5000);

        driver.close();

       // Close - will close the current tab, not the session (not the all tabs)
//        // session id != null



//        driver.quit();
        // It will close all the tabs. - session id == null



    }

    private static void wait_secs(int sec) {
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
