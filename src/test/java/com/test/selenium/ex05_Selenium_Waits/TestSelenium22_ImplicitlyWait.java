package com.test.selenium.ex05_Selenium_Waits;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/*
Implicit Wait has only one configuration and applies globally to all element searches

It tells the WebDriver to wait for a certain amount of time before throwing a NoSuchElementException
if the element is not immediately found

Syntax in Java:
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

- This means every findElement() call will wait up to 10 seconds for the element to appear in the DOM.
- If the element is found sooner, it proceeds immediately.
- If not found within the time, it throws an exception.
-  It only waits for presence in the DOM

How It Works Behind the Scenes
- Selenium polls the DOM repeatedly (every 500 milliseconds by default).
- As soon as the element is found, it stops polling and moves on.
- If the element isn’t found within the timeout, it throws an exception.

This behavior makes implicit wait useful for handling elements that may appear
 with slight delays, without unnecessarily slowing down your test if everything loads quickly.

 */

public class TestSelenium22_ImplicitlyWait {

    private ChromeDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void Test_with_Implicitwait_enabled() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        implicitwait_Check();
    }

    @Test
    public void Test_with_Implicitwait_disabled() {
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        implicitwait_Check();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void implicitwait_Check() {
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");

        for (int i = 0; i < 5; i++) {
            try {
                driver.findElement(By.id("adder")).click();
                String id_value = "box" + i;
                WebElement element = driver.findElement(By.id(id_value));
                Assert.assertTrue(element.isDisplayed());
            } catch (Exception e) {
                System.out.println("Element not found: " + e.getMessage());
            }
        }
    }
}