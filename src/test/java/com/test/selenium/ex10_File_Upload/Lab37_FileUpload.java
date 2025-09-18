package com.test.selenium.ex10_File_Upload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab37_FileUpload {
    @Test
    public void testUploadFile() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/selenium/upload.html");

        WebElement uploadFileInput = driver.findElement(By.id("fileToUpload"));
        String user_dir = System.getProperty("user.dir");
        String path = user_dir + "/src/test/java/com/test/selenium/ex10_File_Upload/testdata.txt";
        uploadFileInput.sendKeys(path);
        driver.findElement(By.name("submit")).click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/selenium/photo_upload.png");

        driver.quit();

    }
}
