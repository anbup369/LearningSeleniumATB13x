package com.test.selenium.ex04_Selenium_CSS_SELECTOR;

import com.test.selenium.utils.CommonToAll;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

// Test Case: Verify login and appointment page functionality on Katalon demo site (using CSS selectors)

public class TestSelenium21a_MiniProject_3 {

    @Owner("")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that with valid email and password, appointment page is loaded")
    @Test
    public void test_katalon_login() throws InterruptedException {

        // Launch browser using utility method that disables credential popups
        CommonToAll utils = new CommonToAll();
        WebDriver driver = utils.launchChrome();
        utils.openBrowser(driver, "https://katalon-demo-cura.herokuapp.com");
        driver.manage().window().maximize();

        // Click "Make Appointment" button on homepage
        WebElement make_appointment_btn = driver.findElement(By.cssSelector("a#btn-make-appointment"));
        make_appointment_btn.click();

        // Verify redirection to login page
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");

        // Enter username in login form
        List<WebElement> username_input_box = driver.findElements(By.cssSelector("input[placeholder='Username']"));
        username_input_box.get(1).sendKeys("John Doe");

        // Enter password in login form
        List<WebElement> password_input_box = driver.findElements(By.cssSelector("input[placeholder='Password']"));
        password_input_box.get(1).sendKeys("ThisIsNotAPassword");

        // Click login button
        WebElement login_input_box = driver.findElement(By.cssSelector("button#btn-login"));
        login_input_box.click();

        Thread.sleep(3000); // Wait for appointment page to load

        // Verify redirection to appointment page
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");

        // Verify appointment page header is displayed
        WebElement h2 = driver.findElement(By.cssSelector("div.col-sm-12.text-center > h2"));
        // Alternative XPath: //h2[text()='Make Appointment']
        Assert.assertEquals(h2.getText(), "Make Appointment");
        Assert.assertTrue(h2.isDisplayed());

        // Open sidebar menu to access logout
        WebElement menu_toggle = driver.findElement(By.cssSelector("a#menu-toggle"));
        menu_toggle.click();

        // Click logout option
        WebElement logout_option = driver.findElement(By.cssSelector("a[href*='logout']"));
        logout_option.click();

        // Verify redirection to homepage after logout
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");

        Thread.sleep(3000); // Wait for homepage to reload

        // Verify "Make Appointment" button is visible again after logout
        System.out.println(make_appointment_btn); // Optional: log reference to original button
        WebElement make_appointment_btn1 = driver.findElement(By.cssSelector("a#btn-make-appointment"));
        Assert.assertTrue(make_appointment_btn1.isDisplayed(), "Make Appointment button is not visible");

        // Close browser session
        driver.quit();
    }
}