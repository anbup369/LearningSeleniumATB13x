package com.test.selenium.ex05_Selenium_Waits;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

// Step 1 - Find the EMAIL ID and enter the admin@admin.com.
// Step 2 - Find the Password  and enter the 1234.
// Step 3 - Find the Submit  and click on the button.
// Step 4 - Wait some time.
// Step 5 - Verify the message error message.

public class TestSelenium23_ExplicitWait {
    // Locators - Find the Web elements
    // Open the URL .app.vwo.com/#/login](https://app.vwo.com/#/login)
    //Find the Email id** and enter the email as admin@admin.com
    //Find the pass input box** and enter password as admin.
    //Find and Click on the submit button
    // Wait - Thread.sleep - Replace with EW
    //Verify that the error message is shown "Your email, password, IP address or location did not match"

    @Description("TC#1 - Verify that with invalid login, error message is displayed!")
    @Owner(" ")
    @Test
    public void test_vwo_login_invalid_login() {
        WebDriver driver = null;

        try {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");

            driver = new ChromeDriver(chromeOptions);
            driver.get("https://app.vwo.com");

            // Maximize the window
//        driver.manage().window().maximize();

            final String TEST_EMAIL = "admin@admin.com";
            final String TEST_PASSWORD = "12345";
            final String EXPECTED_ERROR_MESSAGE = "Your email, password, IP address or location did not match";


            // Step 1 - Find the EMAIL ID and enter the admin@admin.com.
            // <input open Tag
            // type="email"
            // class="text-input W(100%)"
            // name="username"
            // id="login-username"
            // data-qa="hocewoqisi"
            // data-gtm-form-interact-field-id="0"
            // > close Tag

            WebElement email_input_box = driver.findElement(By.id("login-username"));
            email_input_box.sendKeys(TEST_EMAIL);

            // Step 2 - Find the Password  and enter the 1234.
            // <input open Tag
            // type="password"
            // class="text-input W(100%)"
            // name="password"
            // id="login-password"
            // data-qa="jobodapuxe"
            // > close Tag

            WebElement password_input_box = driver.findElement(By.name("password"));
            password_input_box.sendKeys(TEST_PASSWORD);

            // 3. Find the submit button and click on it.
            // <button
            // type="submit"
            // id="js-login-btn"
            // class="btn btn--positive btn--inverted W(80%) H(48px) Fz(16px)"
            // onclick="login.login(event)"
            // data-qa="sibequkica"
            // >

            WebElement button_submit = driver.findElement(By.id("js-login-btn"));
            button_submit.click();

//        // Step 4 - Wait some time.

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            // Max Time - 5
            // Condition visibility of element
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("notification-box-description")));


            // Step 5 - Verify the message error message.
            // <div
            // class="notification-box-description"
            // data-qa="rixawilomi">
            // Your email, password, IP address or location did not match</div>
            WebElement error_message = driver.findElement(By.className("notification-box-description"));
            System.out.println("Error Message: " + error_message.getText());

            // Step 6, we have added the TestNG assertion to verify.
            Assert.assertEquals(error_message.getText(), EXPECTED_ERROR_MESSAGE);

        } catch (Exception e) {
            System.out.println("\nElement not found: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit(); // Always closes browser
            }
        }

    }

}
