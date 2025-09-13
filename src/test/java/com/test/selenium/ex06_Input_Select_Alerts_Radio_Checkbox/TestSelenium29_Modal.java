package com.test.selenium.ex06_Input_Select_Alerts_Radio_Checkbox;

import com.test.selenium.ex07_WaitHelper.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium29_Modal {

    @Test
    public void Handle_Modal_dialog() {
        ChromeDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.makemytrip.com/");
            System.out.println(driver.getTitle());
            driver.manage().window().maximize();

            // Wait for modal and close it
            new WaitHelpers().waitForVisibility(driver, 5000, "//span[@data-cy='closeModal']");
            WebElement e = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
            e.click();

        } catch (Exception e) {
            System.err.println("Exception occurred while handling modal dialog: " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Exception occurred while handling modal dialog: "+e.getMessage());
        } finally {
            driver.quit();
        }
    }
}