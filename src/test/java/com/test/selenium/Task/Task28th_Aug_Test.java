package com.test.selenium.Task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Task28th_Aug_Test {
    @Test
    public void task1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://app.vwo.com/#/login");
        WebElement trial_link = driver.findElement(By.cssSelector("[data-qa='bericafeqo']"));
        trial_link.click();

        Thread.sleep(3000);

        WebElement input_box = driver.findElement(By.id("page-v1-step1-email"));
        input_box.sendKeys("abc@d.com");
        Thread.sleep(3000);
        WebElement checkbox = driver.findElement(By.name("gdpr_consent_checkbox"));
        checkbox.click();
        Thread.sleep(3000);
        WebElement create_button = driver.findElement(By.cssSelector("[data-qa='page-su-submit']"));
        create_button.click();
        Thread.sleep(3000);
        WebElement errorMessage = driver.findElement(By.xpath("//*[text()='The email address you entered is incorrect.']"));
        System.out.println("\n"+errorMessage.getText());
        driver.quit();
    }
}
