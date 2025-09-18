package com.test.selenium.ex9_Actions_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Lab36_ActionClass_Drag_Drop {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        WebElement from = driver.findElement(By.id("column-a"));
        System.out.println("Column A is : "+from.getText());
        WebElement to = driver.findElement(By.id("column-b"));
        System.out.println("Column B is : "+to.getText());

        Thread.sleep(5000);
        actions.dragAndDrop(from,to).build().perform();
        System.out.println("\nAfter dragging elements");
        System.out.println("Column A is : "+from.getText());
        System.out.println("Column B is : "+to.getText());

        Assert.assertEquals(from.getText(),"B");
        Assert.assertEquals(to.getText(),"A");

        driver.quit();

    }
}
