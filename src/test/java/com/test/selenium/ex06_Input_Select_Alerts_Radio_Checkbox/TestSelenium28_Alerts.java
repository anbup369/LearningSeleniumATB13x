package com.test.selenium.ex06_Input_Select_Alerts_Radio_Checkbox;

import com.test.selenium.utils.CommonToAll;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium28_Alerts extends CommonToAll {

    @Test
    public void test_alerts() {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            System.out.println(driver.getTitle());
            driver.manage().window().maximize();

            // Handle simple alert
            WebElement elementAlert = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
            elementAlert.click();
            Alert simpleAlert = driver.switchTo().alert();
            simpleAlert.accept();
            String alertResult = driver.findElement(By.id("result")).getText();
            Assert.assertEquals(alertResult, "You successfully clicked an alert");
            System.out.println(alertResult);

            // Handle confirm alert
            WebElement elementConfirm = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
            elementConfirm.click();
            Alert confirmAlert = driver.switchTo().alert();
            confirmAlert.dismiss(); // or accept()
            String confirmResult = driver.findElement(By.id("result")).getText();
            Assert.assertEquals(confirmResult, "You clicked: Cancel");
            System.out.println(confirmResult);

            // Handle prompt alert
            WebElement elementPrompt = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
            elementPrompt.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();
            String name = "testName";
            alert.sendKeys(name);
            alert.accept();

            String promptResult = driver.findElement(By.id("result")).getText();
            Assert.assertEquals(promptResult, "You entered: " + name);
            System.out.println(promptResult);

        } catch (Exception e) {
            System.err.println("Test encountered an error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeBrowser(driver);
        }
    }
}