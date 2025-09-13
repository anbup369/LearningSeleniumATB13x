package com.test.selenium.ex06_Input_Select_Alerts_Radio_Checkbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestSelenium27_Select_Static {

    @Test
    public  void Select_dropdown() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();


        WebElement element_select = driver.findElement(By.id("dropdown"));
        Select select = new Select(element_select);

        // select.selectByVisibleText("Option 2");
        select.selectByIndex(2);

        // Verify the selected option
        WebElement selectedOption = select.getFirstSelectedOption();
        System.out.println("Selected option: " + selectedOption.getText());

        // Optional: Assert the selected value (if using a testing framework like JUnit/TestNG)
        Assert.assertEquals(selectedOption.getText(), "Option 2");


        driver.quit();

    }
}
