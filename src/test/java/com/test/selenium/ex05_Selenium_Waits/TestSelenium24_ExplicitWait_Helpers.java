package com.test.selenium.ex05_Selenium_Waits;

import com.test.selenium.ex07_WaitHelper.WaitHelpers;
import com.test.selenium.utils.CommonToAll;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium24_ExplicitWait_Helpers extends CommonToAll {

    @Description("Verify  makemytrip opens with modal")
    @Test
    public void testCloseModal() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.makemytrip.com/");
        System.out.println(driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy=\"closeModal\"]")));


        WebElement closeModel = driver.findElement(By.xpath("//span[@data-cy=\"closeModal\"]"));
        closeModel.click();

        //  Wait for modal to disappear
        boolean isModalGone = wait.until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']"))
        );

        System.out.println("\nModal closed???: " + isModalGone);
        Assert.assertTrue(isModalGone, "Modal is still visible after clicking close");

        closeBrowser(driver);


    }
}
