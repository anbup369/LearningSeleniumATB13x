package com.test.selenium.Task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Task28th_Aug_MiniProject25Test {
    @Test
    public void task1() throws InterruptedException, MalformedURLException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://app.vwo.com/#/login");
        WebElement trial_link = driver.findElement(By.cssSelector("[data-qa='bericafeqo']"));
        trial_link.click();
        Thread.sleep(3000);//current_url.startswith(expected_url)

        // Get the current URL
        String currentUrl = driver.getCurrentUrl();
        // Parse the URL to extract base path
        URL url = new URL(currentUrl);
        String baseUrl = url.getProtocol() + "://" + url.getHost() + url.getPath();
        System.out.println("current_url: " + baseUrl);
        // Define expected base URL
        String expectedUrl = "https://vwo.com/free-trial/";
        System.out.println("expected_url: " + expectedUrl);

        // Assertion: Check if base URL matches expected
        Assert.assertEquals(expectedUrl, baseUrl);

        WebElement input_box = driver.findElement(By.id("page-v1-step1-email"));
        input_box.sendKeys("abc@d.com");
        Thread.sleep(3000);
        WebElement checkbox = driver.findElement(By.name("gdpr_consent_checkbox"));
        checkbox.click();
        Thread.sleep(3000);
        WebElement create_button = driver.findElement(By.cssSelector("[data-qa='page-su-submit']"));
        create_button.click();
        Thread.sleep(3000);
//        WebElement errorMessage = driver.findElement(By.xpath("//*[text()='The email address you entered is incorrect.']"));
        WebElement errorMessage = driver.findElement(By.className("invalid-reason"));
        System.out.println("\n" + errorMessage.getText());
        driver.quit();
    }
}
