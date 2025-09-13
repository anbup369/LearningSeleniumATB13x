package com.test.selenium.ex06_Input_Select_Alerts_Radio_Checkbox;

import java.time.Duration;

import com.test.selenium.utils.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class WebElementCommandsTest {

    WebDriver driver;
    WebDriverWait wait;
    CommonToAll utils = new CommonToAll();
    @BeforeClass
    public void setup() {
        driver = utils.launchChrome();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @Test(priority = 1)
    public void loginAndVerifyElements() {
        driver.get("https://www.saucedemo.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));

        // Enter credentials
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");

        // Verify login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        Assert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed.");
        Assert.assertTrue(loginButton.isEnabled(), "Login button is not enabled.");

        // UI properties
        System.out.println("Login button location: " + loginButton.getLocation());
        System.out.println("Login button size: " + loginButton.getSize());
        System.out.println("Login button background: " + loginButton.getCssValue("background-color"));
        System.out.println("Login button value: " + loginButton.getAttribute("value"));
        System.out.println("Login button tag: " + loginButton.getTagName());

        // Click login
        loginButton.click();

        // Wait for post-login page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
        WebElement title = driver.findElement(By.className("title"));
        Assert.assertEquals(title.getText(), "Products", "Unexpected page title after login.");
    }

    @Test(priority = 2)
    public void verifyDropdownSelection() {
        WebElement filter = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(filter);

        // Check default selected option
        WebElement selectedOption = select.getFirstSelectedOption();
        System.out.println("Default selected filter: " + selectedOption.getText());
        Assert.assertEquals(selectedOption.getAttribute("value"), "az", "Default filter is not 'az'.");

        // Change selection
        // Select the new value
        select.selectByValue("lohi");

        //To avoid StaleElementReferenceException ,Re-locate the dropdown element and re-wrap it in a new Select object
        WebElement filter1 = driver.findElement(By.className("product_sort_container"));
        Select updatedSelect = new Select(filter1);

        // Now safely get the selected option
        WebElement selectedOption1 = updatedSelect.getFirstSelectedOption();
        Assert.assertEquals(selectedOption1.getAttribute("value"), "lohi", "Filter did not change to 'lohi'.");
    }

    @Test(priority = 3)
    public void clearAndReenterUsername() {
        driver.get("https://www.saucedemo.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("invalid_user");
        username.clear();
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
        WebElement title = driver.findElement(By.className("title"));
        Assert.assertEquals(title.getText(), "Products", "Login failed after re-entering credentials.");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}