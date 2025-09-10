package com.test.selenium.ex04_Selenium_XPATH;

import com.test.selenium.utils.CommonToAll;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


// Test Case: Login and Logout Verification using XPath locators(using Xpath)

public class TestSelenium20_MiniProject extends CommonToAll {

    @Owner("")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify login is working")
    @Test
    public void test_OHRM_login() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // Open the OrangeHRM login page
        openBrowser(driver, "https://awesomeqa.com/hr/web/index.php/auth/login");

        Thread.sleep(3000); // Wait for page to load

        // Locate username input field using XPath
        WebElement input_username = driver.findElement(By.xpath("//input[@name='username']"));
        // Alternative XPath: //input[@placeholder='Username']

        // Locate password input field using XPath
        WebElement input_password = driver.findElement(By.xpath("//input[@placeholder='Password']"));

        // Locate login button using XPath
        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Login']"));

        // Enter login credentials and submit
        input_username.sendKeys("admin");
        input_password.sendKeys("Hacker@4321");
        button.click();

        Thread.sleep(3000); // Wait for dashboard to load

        // Verify successful login by checking header text
        WebElement h6 = driver.findElement(By.xpath("//h6[text()='PIM']"));
        Assert.assertEquals(h6.getText(), "PIM", "Login failed: Expected header text 'PIM'");

        // Locate user dropdown menu
        WebElement dropdown = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
        // HTML reference: <p class="oxd-userdropdown-name">Site Owner</p>
        dropdown.click();

        Thread.sleep(3000); // Wait for dropdown to expand

        // Locate logout link using XPath with partial href and class match
        WebElement logout = driver.findElement(By.xpath("//a[contains(@href, 'logout') and contains(@class, 'oxd-userdropdown-link')]"));
        logout.click();

        // Verify redirection to login page after logout
        Assert.assertTrue(driver.getCurrentUrl().contains("auth/login"), "Logout failed: URL does not contain 'auth/login'");

        Thread.sleep(3000); // Wait for login page to load

        // Verify login logo is displayed after logout
        WebElement login_logo = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']"));
        // HTML reference: <div class="orangehrm-login-branding"><img ... /></div>
        Assert.assertTrue(login_logo.isDisplayed(), "Login logo is not visible after logout");

        // Close browser session
        driver.quit();
    }
}