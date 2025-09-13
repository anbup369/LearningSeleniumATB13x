package com.test.selenium.ex06_Input_Select_Alerts_Radio_Checkbox;

import com.test.selenium.utils.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium26_Input_Checkbox_Radio extends CommonToAll {
    WebDriver driver;
    @Test
    public  void main() {

        driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/practice.html");

        // Input box
        WebElement firstname = driver.findElement(By.name("firstname"));
//        WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstname.sendKeys("testFirstNamelong");


        // Radio Button
        WebElement radiobutton = driver.findElement(By.id("exp-1"));
        radiobutton.click();

        // checkbox
        WebElement checkbox = driver.findElement(By.id("profession-0"));
        checkbox.click();


        // CHeck Box
        driver.quit();


    }
}
