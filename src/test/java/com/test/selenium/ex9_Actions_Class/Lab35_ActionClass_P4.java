package com.test.selenium.ex9_Actions_Class;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Lab35_ActionClass_P4 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
        driver.manage().window().maximize();

         Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,1000).perform();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(2000);

        driver.quit();
    }
}
