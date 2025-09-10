package com.test.selenium.ex04_Selenium_CSS_SELECTOR;

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

//  Test Case: Login and Logout Verification for OrangeHRM(using CSS selector)

public class TestSelenium20a_MiniProject extends CommonToAll {

    @Owner("")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify login is working")
    @Test
    public void test_OHRM_login() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        //  Open the OrangeHRM login page
        openBrowser(driver, "https://awesomeqa.com/hr/web/index.php/auth/login");

        Thread.sleep(3000); //  Wait for page to load

        //  Locate username input field using CSS selector
        WebElement input_username = driver.findElement(By.cssSelector("input[name='username']"));
        // Alternative XPath: //input[@name='username'] or //input[@placeholder='Username']

        //  Locate password input field using CSS selector
        WebElement input_password = driver.findElement(By.cssSelector("input[placeholder='Password']"));
        // Alternative XPath: //input[@placeholder='Password']

        //  Locate login button using CSS selector
        WebElement button = driver.findElement(By.cssSelector("button.orangehrm-login-button"));
        // Alternative XPath: //button[normalize-space()='Login']

        //  Enter credentials and submit login form
        input_username.sendKeys("admin");
        input_password.sendKeys("Hacker@4321");
        button.click();

        Thread.sleep(3000); //  Wait for dashboard to load

        //  Verify successful login by checking dashboard header
        WebElement h6 = driver.findElement(By.cssSelector("h6.oxd-topbar-header-breadcrumb-module"));
        // Preferred XPath: //h6[text()='PIM']
        Assert.assertEquals(h6.getText(), "PIM", "Login failed: Expected header text 'PIM'");

        //  Locate user dropdown menu
        WebElement dropdown = driver.findElement(By.cssSelector("p.oxd-userdropdown-name"));
        // HTML Reference: <p class="oxd-userdropdown-name">Site Owner</p>
        dropdown.click();

        Thread.sleep(3000); //  Wait for dropdown to expand

        //  Locate logout link using partial href match
        WebElement logout = driver.findElement(By.cssSelector("a.oxd-userdropdown-link[href*='logout']"));
        // Alternative CSS: a.oxd-userdropdown-link[href='/hr/web/index.php/auth/logout']
        logout.click();

        //  Verify redirection to login page after logout
        Assert.assertTrue(driver.getCurrentUrl().contains("auth/login"), "Logout failed: URL does not contain 'auth/login'");

        Thread.sleep(3000); //  Wait for login page to load

        //  Verify login logo is displayed after logout
        WebElement login_logo = driver.findElement(By.cssSelector("div.orangehrm-login-branding"));
        // HTML Reference: <div class="orangehrm-login-branding"><img ... /></div>
        Assert.assertTrue(login_logo.isDisplayed(), "Login logo is not visible after logout");

        //  Close browser session
        driver.quit();
    }
}