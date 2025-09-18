package com.test.selenium.ex10_File_Upload;

import com.test.selenium.ex07_WaitHelper.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Lab38_FileUpload_Success {

    @Test
    public  void uploadFileTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();

        WebElement uploadFileInput = driver.findElement(By.id("file-upload"));
        String user_dir = System.getProperty("user.dir");
        System.out.println(user_dir);
        String file_name = "Untitled.png";
        String path = user_dir + "/src/test/java/com/test/selenium/ex10_File_Upload/" + file_name;
        uploadFileInput.sendKeys(path);
        driver.findElement(By.id("file-submit")).click();

        WebElement success_text = driver.findElement(By.xpath("//div[@class=\"example\"]/h3"));
        System.out.println(success_text.getText());
        Assert.assertEquals(success_text.getText(), "File Uploaded!");

        WebElement Uploaded_file_display = driver.findElement(By.id("uploaded-files"));
        System.out.println(Uploaded_file_display.getText());
        Assert.assertEquals(Uploaded_file_display.getText(), file_name);

        driver.quit();

    }

}
