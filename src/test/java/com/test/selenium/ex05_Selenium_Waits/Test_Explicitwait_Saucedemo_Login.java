package com.test.selenium.ex05_Selenium_Waits;

import com.test.selenium.utils.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

/*
Accepted usernames are:

standard_user
locked_out_user
problem_user
performance_glitch_user
error_user
visual_user

Password for all users:
secret_sauce
 */
public class Test_Explicitwait_Saucedemo_Login {
    CommonToAll utils = new CommonToAll();

    @Test
    public void TestLogin_Page_standard_user() {
        WebDriver driver = utils.launchChrome();
        utils.openBrowser(driver, "https://www.saucedemo.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

// Wait for username field to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys("standard_user");

// Wait for password field
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("secret_sauce");

// Wait for login button to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();

        //  Verify redirection to login page after logout
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Logout failed: URL does not contain 'https://www.saucedemo.com/inventory.html'");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='inventory_container'])[2]")));
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@id='inventory_container'])[2]")).isDisplayed());
        driver.quit();

    }
}
