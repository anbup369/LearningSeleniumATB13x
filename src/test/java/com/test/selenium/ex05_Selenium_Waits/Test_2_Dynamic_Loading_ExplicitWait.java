package com.test.selenium.ex05_Selenium_Waits;
//Dynamic Loading

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test_2_Dynamic_Loading_ExplicitWait {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new FirefoxDriver();
    }


    @Test
    @Description("Example 2: Element rendered after the fact")
    public void test1() {
        try {
            driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
            driver.findElement(By.cssSelector("#start button")).click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

            String expectedText = "Hello World!";
            String actualText = driver.findElement(By.id("finish")).getText();
            System.out.println("Loaded Text 2: " + actualText);
            Assert.assertEquals(actualText, expectedText, "Text did not match!");

        } catch (TimeoutException e) {
            System.err.println("Element did not become visible in time: " + e.getMessage());
            Assert.fail("Timeout waiting for element visibility");

        } catch (NoSuchElementException e) {
            System.err.println("Element not found: " + e.getMessage());
            Assert.fail("Required element not found");

        } catch (AssertionError e) {
            System.err.println("Assertion failed: " + e.getMessage());
            throw e; // rethrow to let TestNG mark the test as failed

        } catch (Exception e) {
            System.err.println("Unexpected exception occurred: " + e.getMessage());
            Assert.fail("Test failed due to unexpected exception");
        }
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
