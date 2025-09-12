package com.test.selenium.ex05_Selenium_Waits;

import com.test.selenium.ex07_WaitHelper.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import com.test.selenium.utils.CommonToAll;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium25_Fluent_Wait_helpers extends CommonToAll {

    @Test
    public void testLoginErrorMessage() {
        final String TEST_EMAIL = "admin@admin.com";
        final String TEST_PASSWORD = "password@321";
        final String EXPECTED_ERROR_MESSAGE = "Your email, password, IP address or location did not match";

        WebDriver driver = null;

        try {
            // Set Chrome options for incognito and maximized window
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--incognito");
            chromeOptions.addArguments("--start-maximized");

            driver = new ChromeDriver(chromeOptions);
            driver.navigate().to("https://app.vwo.com");

            System.out.println("Page Title: " + driver.getTitle());

            // Validate page title and URL
            Assert.assertEquals(driver.getTitle(), "Login - VWO");
            Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");

            // Locate and fill in the email input box
            WebElement emailInputBox = driver.findElement(By.id("login-username"));
            emailInputBox.sendKeys(TEST_EMAIL);

            // Locate and fill in the password input box
            WebElement passwordInputBox = driver.findElement(By.name("password"));
            passwordInputBox.sendKeys(TEST_PASSWORD);

            // Click the login button
            WebElement buttonSubmit = driver.findElement(By.id("js-login-btn")); // Intentionally incorrect to trigger error
            buttonSubmit.click();

            // Fluent wait for error message visibility
            FluentWait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);

            WebElement error_message = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.className("notification-box-description"))
            );

            System.out.println("\nError Message: " + error_message.getText());

            // Verify the error message using TestNG assertion
            Assert.assertEquals(error_message.getText(), EXPECTED_ERROR_MESSAGE);

        } catch (Exception e) {
//            System.err.println("Test failed due to exception: " + e.getMessage());
//            e.printStackTrace();
            Assert.fail("Exception occurred during test execution.");
        } finally {
            // Ensure browser is closed even if driver initialization fails
            if (driver != null) {
                driver.quit();
            }
        }
    }
}