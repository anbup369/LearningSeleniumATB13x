package com.test.selenium.ex02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium11_Change_Driver {
    public static void main(String[] args) {
        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://google.com");
        WebDriver chromedriver = driver1;

        driver1 = new FirefoxDriver();
        driver1.get("https://google.com");

        chromedriver.quit();
        driver1.quit();

    }
}
