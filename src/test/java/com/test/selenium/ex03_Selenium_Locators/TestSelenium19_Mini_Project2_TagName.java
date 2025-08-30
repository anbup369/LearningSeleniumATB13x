package com.test.selenium.ex03_Selenium_Locators;

import com.test.selenium.utils.CommonToAll;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium19_Mini_Project2_TagName extends CommonToAll {
    @Owner("Pramod")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("https://bugz.atlassian.net/browse/BUG-17")
    @Description("Verify that the error message comes with invalid email on signup page.")
    @Test
    public void vwo_free_trail_error_verify() {

        WebDriver driver = new ChromeDriver();
        openBrowser(driver, "https://app.vwo.com");


        WebElement a_tag_partial_match = findElementByPartialText(driver, "trial");
        a_tag_partial_match.click();

        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("free-trial"));


        WebElement email = driver.findElement(By.id("page-v1-step1-email"));
        email.sendKeys("abc@t.com");

        WebElement checkbox_policy = driver.findElement(By.name("gdpr_consent_checkbox"));
        checkbox_policy.click();

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement error_msg = driver.findElement(By.className("invalid-reason"));


        System.out.println(error_msg.isDisplayed());
        Assert.assertEquals(error_msg.getText(), "The email address you entered is incorrect.");


        closeBrowser(driver);


    }

}
