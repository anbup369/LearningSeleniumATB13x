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

public class Test_1_Dynamic_Loading_ExplicitWait {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new FirefoxDriver();
    }

    @Test
    @Description("Example 1: Element on page that is hidden")

    public void test1_positive() {
        try {
            driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
            driver.findElement(By.cssSelector("#start button")).click(); //intentionally disabled

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));//This step will pass, even though this element is hidden, since presenceOfElementLocated is used
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));//This step will fail for visibilityOfElementLocated, since  this element is hidden(not visible)
            String expectedText = "Hello World!";
            String actualText = driver.findElement(By.id("finish")).getText();
            System.out.println("Loaded Text 1: " + actualText);
            Assert.assertEquals(actualText, expectedText, "Text did not match!");

        } catch (TimeoutException e) {
            System.err.println("Timeout waiting for element visibility: " + e.getMessage());
            Assert.fail("Element did not become visible in time");

        } catch (NoSuchElementException e) {
            System.err.println("Element not found: " + e.getMessage());
            Assert.fail("Required element not found on the page");

        } catch (AssertionError e) {
            System.err.println("Assertion failed: " + e.getMessage());
            throw e; // rethrow to let TestNG mark the test as failed

        } catch (Exception e) {
            System.err.println("Unexpected exception occurred: " + e.getMessage());
            Assert.fail("Test failed due to unexpected exception");
        }
    }

    @Test
    public void test2_negative() {
        try {
            driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//            driver.findElement(By.cssSelector("#start button")).click(); //intentionally disabled

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));//This step will pass, even though this element is hidden, since presenceOfElementLocated is used
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));//This step will fail for visibilityOfElementLocated, since  this element is hidden(not visible)
            String expectedText = "Hello World!";
            String actualText = driver.findElement(By.id("finish")).getText();
            System.out.println("Loaded Text 1: " + actualText);
            Assert.assertEquals(actualText, expectedText, "Text did not match!");

        } catch (TimeoutException e) {
            System.err.println("Timeout waiting for element visibility: " + e.getMessage());
            Assert.fail("Element did not become visible in time");

        } catch (NoSuchElementException e) {
            System.err.println("Element not found: " + e.getMessage());
            Assert.fail("Required element not found on the page");

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
