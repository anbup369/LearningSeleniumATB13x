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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Test Case: Verify login and appointment page functionality on Katalon demo site(using xpath)

public class TestSelenium21_MiniProject_3 {

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

        // Click on "Make Appointment" button on homepage
        WebElement make_appointment_btn_xpath = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        make_appointment_btn_xpath.click();

        // Enter username in login form
        List<WebElement> username_input_box_xpath_placeholder = driver.findElements(By.xpath("//input[@placeholder='Username']"));
        username_input_box_xpath_placeholder.get(1).sendKeys("John Doe");

        // Enter password in login form
        List<WebElement> password_input_box = driver.findElements(By.xpath("//input[@placeholder='Password']"));
        password_input_box.get(1).sendKeys("ThisIsNotAPassword");

        // Click on login button
        WebElement login_input_box = driver.findElement(By.xpath("//button[@id='btn-login']"));
        // Alternative XPath: //button[text()='Login']
        login_input_box.click();

        Thread.sleep(3000); // Wait for appointment page to load

        // Verify URL after successful login
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");

        // Verify appointment page header is displayed
        WebElement h2 = driver.findElement(By.xpath("//h2[text()='Make Appointment']"));
        Assert.assertEquals(h2.getText(), "Make Appointment");
        Assert.assertTrue(h2.isDisplayed());

        // Open sidebar menu to access logout
        WebElement menu_toggle = driver.findElement(By.xpath("//a[@id='menu-toggle']"));
        menu_toggle.click();

        // Click on logout option
        WebElement logout_option = driver.findElement(By.xpath("//a[contains(@href,'logout')]"));
        logout_option.click();

        // Verify URL after logout
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");

        Thread.sleep(3000); // Wait for homepage to reload

        // Verify "Make Appointment" button is visible again after logout
        System.out.println(make_appointment_btn_xpath); // Optional: log reference to original button
        WebElement make_appointment_btn_xpath1 = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        Assert.assertTrue(make_appointment_btn_xpath1.isDisplayed(), "Make Appointment button is not visible");

        // Close browser session
        driver.quit();
    }
}