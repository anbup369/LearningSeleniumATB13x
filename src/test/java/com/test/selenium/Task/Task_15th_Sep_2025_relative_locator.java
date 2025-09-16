package com.test.selenium.Task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Task_15th_Sep_2025_relative_locator {

    WebDriver driver;

    // Locators
    By username = By.xpath("//input[@id='username']");
    By email = By.xpath("//input[@id='email']");
    By password = By.xpath("//input[@id='password']");
    By password2 = By.xpath("//input[@id='password2']");

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void test_using_relative_locator() {
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));

        driver.switchTo().frame("result");

        wait.until(ExpectedConditions.visibilityOfElementLocated(username));

        // Fill form with invalid data
        driver.findElement(username).sendKeys("iv");
        driver.findElement(email).sendKeys("invalid_email");
        driver.findElement(password).sendKeys("12345");
        driver.findElement(password2).sendKeys("1234");

        driver.findElement(By.xpath("//form//button[contains(text(),'Submit')]")).click();

        // Validate error messages using relative locators
        String error1 = driver.findElement(with(By.tagName("small")).below(username)).getText();
        System.out.println(error1);
        Assert.assertEquals(error1, "Username must be at least 3 characters");

        String error2 = driver.findElement(with(By.tagName("small")).below(email)).getText();
        System.out.println(error2);
        Assert.assertEquals(error2, "Email is not invalid");

        String error3 = driver.findElement(with(By.tagName("small")).below(password)).getText();
        System.out.println(error3);
        Assert.assertEquals(error3, "Password must be at least 6 characters");

        String error4 = driver.findElement(with(By.tagName("small")).below(password2)).getText();
        System.out.println(error4);
        Assert.assertEquals(error4, "Passwords do not match");
    }

    @Test
    public void test_using_xpath_Axes() {
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));

        driver.switchTo().frame("result");

        wait.until(ExpectedConditions.visibilityOfElementLocated(username));

        // Fill form with invalid data
        driver.findElement(username).sendKeys("iv");
        driver.findElement(email).sendKeys("invalid_email");
        driver.findElement(password).sendKeys("12345");
        driver.findElement(password2).sendKeys("1234");

        driver.findElement(By.xpath("//form//button[contains(text(),'Submit')]")).click();

        // Validate error messages using XPath axes
        String error1 = driver.findElement(By.xpath("//input[@id='username']/following-sibling::small")).getText();
        System.out.println(error1);
        Assert.assertEquals(error1, "Username must be at least 3 characters");

        String error2 = driver.findElement(By.xpath("//input[@id='email']/following-sibling::small")).getText();
        System.out.println(error2);
        Assert.assertEquals(error2, "Email is not invalid");

        String error3 = driver.findElement(By.xpath("//input[@id='password']/following-sibling::small")).getText();
        System.out.println(error3);
        Assert.assertEquals(error3, "Password must be at least 6 characters");

        String error4 = driver.findElement(By.xpath("//input[@id='password2']/following-sibling::small")).getText();
        System.out.println(error4);
        Assert.assertEquals(error4, "Passwords do not match");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}