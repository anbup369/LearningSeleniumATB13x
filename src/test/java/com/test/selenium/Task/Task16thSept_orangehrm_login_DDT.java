package com.test.selenium.Task;

import com.test.selenium.utils.CommonToAll;
import com.test.selenium.utils.UtilExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task16thSept_orangehrm_login_DDT {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test(dataProvider = "getData")
    public void test_vwo_login(String username, String password) {

        driver.navigate().to("https://awesomeqa.com/hr");
        System.out.println(driver.getTitle());


        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
        Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/hr/web/index.php/auth/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='company-branding']")));

        WebElement usernameInputBox = driver.findElement(By.name("username"));
        System.out.println("username is:" + username);
        usernameInputBox.sendKeys(username);


        WebElement passwordInputBox = driver.findElement(By.name("password"));
        System.out.println("password is:" + password);
        passwordInputBox.sendKeys(password);

        WebElement buttonSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
        buttonSubmit.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role=\"alert\"]")));
//
        WebElement error_message = driver.findElement(By.xpath("//p[text()='Invalid credentials']"));
        Assert.assertEquals(error_message.getText(), "Invalid credentials");


    }


    @DataProvider
    public Object[][] getData() {
        // READ THE DATA FROM THE EXCEL FILE
        // GIVE THEM IN THE 2D ARRAY
        return UtilExcel.getTestDataFromExcel("sheet1");

    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
